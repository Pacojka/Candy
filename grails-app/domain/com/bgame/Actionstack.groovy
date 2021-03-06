package com.bgame

class Actionstack {
	Date starttime
	Date endtime
	Map destinationmap
	User user
	static hasMany = [units:Unit]
	Value goldgain = new Value()
	Actionenum actiontype = "hin"
	String fightblog = ""

	static embedded = ['goldgain']
	static constraints = { endtime(nullable:true) }
	String toString(){
		def result = ""
		if(actiontype.getKey() == "hin"){
			if(destinationmap.fieldtype.getKey() == "user" && destinationmap.hasUser()){
				result += "bis zum Angriff auf ${destinationmap.user.username}(${destinationmap.xaxis}/${destinationmap.yaxis})"
			}else{
				result += "bis zum Angriff auf ${destinationmap.fieldtype.toString()}(${destinationmap.xaxis}/${destinationmap.yaxis})"
			}
		}else if(actiontype.getKey() == "kam"){

			result += "Kampf läuft (${destinationmap.xaxis}/${destinationmap.yaxis})."
		}else{
			result += "bis zur Ankunft im Heimatdorf."
		}
		result
	}

	public enum Actionenum {
		hin("Hinweg"),
		rue("Rückweg"),
		kam("Kampf")
		final String value
		Actionenum (String value) {
			this.value = value
		}
		String toString() {
			value
		}
		String getKey() {
			name()
		}
	}

	def units(){
		return this.units.collect{it}.sort {it.dateCreated}
	}

	def setToFight(){
		actiontype = "kam"
	}

	def travelBack(){
		def result = endtime.time - starttime.time + endtime.time
		endtime = new Date(result)
		actiontype = "rue"
	}

	def timeleft(){
		def result = (int)((endtime.time - (new Date().time))/1000)
		if(result < 0)result = 0
		result
	}

	def travelSetTime(traveltime){
		goldgain.val = 0
		def result = starttime.time
		result += (traveltime*1000)
		endtime = new Date(result)
	}

	def sendMessageEnemy(){
		if(destinationmap.hasUser()){
			destinationmap.user.addToMessages(new Message(titel:"Kampfbericht",text:fightblog))
		}
	}

	def sendMessageUser(){
		user.addToMessages(new Message(titel:"Kampfbericht",text:fightblog))
	}

	def getMonsterTeam(){
		def exp = (int)(destinationmap.monsterexp * destinationmap.staerkefaktor)
		def result = []
		def random = new Random()
		def anzmonster= 1 + random.nextInt(3)
		def enemy = new Monster()
		for(int i = 1; i<=anzmonster;i++){
			enemy = new Monster()//.discard()
			enemy.createcopy(Monster.read(random.nextInt(Monster.count())+1))
			enemy.name = "(${i}) "+enemy.name
			result << enemy
			enemy = null
		}
		if(exp >10){
			exp = (int)(exp/10)
		}else{
			exp = 1
		}

		for(int i = 1;i<=10;i++){
			result[random.nextInt(anzmonster)].addmonsterexp(exp)
		}
		result.each{println "${it.name} mit ${it.monsterexp}\n"}
		result.each{
			it.recalcMonster()
			it.gold *=destinationmap.staerkefaktor
		}
		result
	}


	def fightsim() {
		def userteam = units()
		def enemyteam = []
		def enemyIsUser
		def fuckfeld = false
		def result = "" //rueckgabewert
		if(destinationmap.hasUser()){
			enemyteam = destinationmap.user.availableUnits()
			enemyIsUser = true
		}else if(destinationmap.fieldtype.getKey()=="user"){fuckfeld = true}
		else{

			enemyteam = getMonsterTeam()
			enemyteam.each{System.out.println("${it} monsterexp:${it.monsterexp}\n")}

			enemyIsUser = false
		}
		if(!fuckfeld){

			def roundcount = 0
			def t1count = 0
			userteam.each {if (it.curhp >0) t1count++}
			def unitcount = t1count
			def t2count = 0
			enemyteam.each {if (it.curhp >0) t2count++}
			def random = new Random()
			if (t2count > unitcount) {
				unitcount = t2count
			}
			def goldpool = 0
			def t1exppool = 1
			def t2exppool = 1
			def t1hppool = 1
			def t2hppool = 1

			userteam.each {
				if (it.curhp > 0){
					t1exppool += (int)(it.exp/(it.maxhp/it.curhp))
					t1hppool += it.curhp
				}
			}
			def t1dpexp = (int)(t1hppool/t1exppool)
			if(t1dpexp < 1){t1dpexp = 1}//FEEEEEEEEEEEEEEEEHLER GLAUB ICH! UNTEN AUCH!
			enemyteam.each {
				if (it.curhp > 0){
					t2exppool += (int)(it.exp/(it.maxhp/it.curhp))
					t2hppool += it.curhp
				}
			}

			def t2dpexp = (int)(t2hppool/t2exppool)
			if(t2dpexp < 1){t2dpexp = 1}
			while (t1count > 0 && t2count > 0){
				roundcount++
				if(!destinationmap.hasUser()){
					enemyteam.each {result += "${it} Monsterexp: ${it.monsterexp}<br>"}
				}
				result += "<br><br>Round."+roundcount+" begins:<br>"

				for (int i = 0; i < unitcount;++i){

					def rand = -1
					if (userteam.size() >= i+1 && t2count > 0 && t1count > 0){
						if(userteam[i].curhp >0){
							result += userteam[i].name +"["+userteam[i].curhp+"/"+userteam[i].maxhp+ "] attaks enemy "

							rand = random.nextInt(enemyteam.size())
							while(enemyteam[rand].curhp <=0){
								rand = random.nextInt(enemyteam.size())
							}
							result += enemyteam[rand].name +"["+enemyteam[rand].curhp+"/"+enemyteam[rand].maxhp+ "] dealing " + userteam[i].dmg() +" dmg.<br>"
							if(enemyteam[rand].curhp < userteam[i].dmg()){
								enemyteam[rand].curhp = 0
							}else{
								enemyteam[rand].curhp -= userteam[i].dmg()
							}





							//if(destinationmap.hasUser()){

							//enemyteam[rand].save(flush: true)
							//}
							if (t2exppool > 0){
								def expgain = 0
								if (t2dpexp <= userteam[i].dmg()){
									expgain = (int)(userteam[i].dmg()/t2dpexp)
								}
								else{
									expgain = 1
								}

								switch(userteam[i].wtyp.value){
									case "Nahkampf":
										userteam[i].nahexp += expgain
										break
									case "Fernkampf":
										userteam[i].ferexp += expgain
										break
									case "Magie":
										userteam[i].magexp += expgain
										break
								}
								result +=  userteam[i].name +" gets "+expgain+" Exp on "+userteam[i].wtyp.value+". <br>"
								/*
								 if(userteam[i].wtyp.value == "Nahkampf"){
								 userteam[i].nahexp += expgain
								 result +=  userteam[i].name +" gets "+expgain+" Exp on Nahkampf. <br>"
								 }else if(userteam[i].wtyp.value == "Fernkampf"){
								 userteam[i].ferexp += expgain
								 result +=  userteam[i].name +" gets "+expgain+" Exp on Fernkampf. <br>"
								 }else if(userteam[i].wtyp.value == "Magie"){
								 userteam[i].magexp += expgain
								 result +=  userteam[i].name +" gets "+expgain+" Exp on Magie. <br>"
								 }
								 */


								if(t2exppool >= expgain){
									t2exppool -= expgain
								}else t2exppool = 0


								//userteam[i].recalcUnit()
								//userteam[i].save(flush: true)
							}

							if (enemyteam[rand].curhp < 1){
								result += enemyteam[rand].name +"["+enemyteam[rand].curhp+"/"+enemyteam[rand].maxhp+ "] died.<br><br>"
								t2count--
								def money = enemyteam[rand].gold
								if(money >= 4){
									def unitmoney = (int)(money/4)
									userteam[i].gold += unitmoney
									money -= unitmoney

								}
								enemyteam[rand].gold = 0
								goldpool += money
							}
							else{
								result += "<br><br>"
							}
						}
					}
					if (enemyteam.size() >= i+1 && t2count > 0 && t1count > 0){
						if(enemyteam[i].curhp >0){
							result += "Enemy " + enemyteam[i].name +"["+enemyteam[i].curhp+"/"+enemyteam[i].maxhp+ "] attaks "
							rand = random.nextInt(userteam.size())
							while(userteam[rand].curhp <=0){
								rand = random.nextInt(userteam.size())
							}
							result += userteam[rand].name +"["+userteam[rand].curhp+"/"+userteam[rand].maxhp+ "] dealing " + enemyteam[i].dmg() +" dmg.<br>"
							if(userteam[rand].curhp < enemyteam[i].dmg()){
								userteam[rand].curhp = 0
							}else{
								userteam[rand].curhp -= enemyteam[i].dmg()
							}
							//userteam[rand].save(flush: true)

							if(destinationmap.hasUser()){
								if (t1exppool > 0){
									def expgain = 0
									if (t1dpexp <= enemyteam[i].dmg()){
										expgain = (int)(enemyteam[i].dmg()/t1dpexp)
									}
									else{
										expgain = 1
									}
									if(enemyteam[i].wtyp.value == "Nahkampf"){
										enemyteam[i].nahexp += expgain
										result +=  enemyteam[i].name +" gets "+expgain+" Exp on Nahkampf. <br>"
									}else if(enemyteam[i].wtyp.value == "Fernkampf"){
										enemyteam[i].ferexp += expgain
										result +=  enemyteam[i].name +" gets "+expgain+" Exp on Fernkampf. <br>"
									}else if(enemyteam[i].wtyp.value == "Magie"){
										enemyteam[i].magexp += expgain
										result +=  enemyteam[i].name +" gets "+expgain+" Exp on Magie. <br>"
									}
									if(t1exppool >= expgain){
										t1exppool -= expgain
									}else t1exppool = 0

									//enemyteam[i].recalcUnit()
									//enemyteam[i].save(flush: true)
								}
							}


							if (userteam[rand].curhp < 1){
								result += userteam[rand].name +"["+userteam[rand].curhp+"/"+userteam[rand].maxhp+ "] died.<br><br>"
								t1count--
								def money = userteam[rand].gold

								if(destinationmap.hasUser()){
									if(money >= 4){
										def unitmoney = (int)(money/4)
										enemyteam[i].gold += unitmoney
										money -= unitmoney

									}
								}
								userteam[rand].gold = 0
								goldpool += money




							}
							else{
								result += "<br><br>"
							}
						}
					}
				}
			}
			if (t2count < 1){
				result += "Attacker "+ userteam[0].user.username+ " wins.<br>"

				if(goldpool > 0){
					result += userteam[0].user.username+ " gets "+goldpool+" Gold."
					this.goldgain.add(goldpool)
				}

				if(t2exppool >= t1count){
					def expgain =(int)(t2exppool/t1count)
					userteam.each{
						if(it.curhp >0){
							if(it.wtyp.value == "Nahkampf"){
								it.nahexp += expgain
							}else if(it.wtyp.value == "Fernkampf"){
								it.ferexp += expgain
							}else if(it.wtyp.value == "Magie"){
								it.magexp += expgain
							}
							//it.recalcUnit()
						}
					}
					result += "All alive Units from "+ userteam[0].user.username+ " get "+expgain+"Exp.<br>"

				}

			}else if(t1count < 1){


				if(destinationmap.hasUser()){
					result += "Enemy "+ enemyteam[0].user.username+ " wins."
					if(goldpool > 0){
						result += enemyteam[0].user.username+ " gets "+goldpool+" Gold."
						enemyteam[0].user.gold.add(goldpool)
					}

					if(t1exppool >= t2count){
						def expgain =(int)(t1exppool/t2count)
						enemyteam.each{
							if(it.curhp >0){
								if(it.wtyp.value == "Nahkampf"){
									it.nahexp += expgain
								}else if(it.wtyp.value == "Fernkampf"){
									it.ferexp += expgain
								}else if(it.wtyp.value == "Magie"){
									it.magexp += expgain
								}
								//it.recalcUnit()
							}
						}
						result += "All alive Units from "+ enemyteam[0].user.username+ " get "+expgain+"Exp"
					}
				}else{
					result += "Monsterteam wins."
				}


			}else{
				result += "something is wrong here: t1usercount:"+t1count+" t2enemycount:"+t2count
			}


			if(destinationmap.hasUser()){
				enemyteam.each{
					it.recalcUnit()
					it.save()
				}
			}




			userteam.each{
				it.recalcUnit()
				it.save()
			}
		}else{result += "<br>Du hast ein leeres Lager vorgefunden :("}
		return result
	}
}
