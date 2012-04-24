import com.bgame.*
class BootStrap {

    def init = { servletContext ->
		System.out.println("BootStrap GO!!!")
	
/*XYZ
        /*map erzeugen*/
        //feldgrösse vielfache 25 + x * 10 {x E N} :D(hoffentlich nicht falsch :D)
/*XYZ
		def fieldsize = 45

        def random = new Random()
        def field
        def zufall
        def fieldtop
        def fieldleft
        def zufall_feld
        def fieldtext = "penis"
        def possible_fields=["wal","geb","fel","wue"] //,"doe"
		def fieldlvls2 = [1.9,2,1.3,2,2.3,2.6,2.9,3,1.3,1.6,1.9,3,4,5]
		
        for (int ycor = 0; ycor < fieldsize;++ycor){
            for (int xcor = 0; xcor < fieldsize;++xcor){
                fieldtop = Map.findByXaxisAndYaxis(xcor,ycor-1)
                fieldleft = Map.findByXaxisAndYaxis(xcor-1,ycor)
                zufall=random.nextInt(3)
                if(fieldtop && fieldleft){
                    switch(zufall){
                        case 0:
                        fieldtext=fieldleft.fieldtype.getKey()
                        break
                        case 1:
                        fieldtext=fieldtop.fieldtype.getKey()
                        break
                        default:
                        zufall_feld = random.nextInt(4)
                        fieldtext = possible_fields[zufall_feld]
                    }
                }else if(fieldtop){
                    switch(zufall){
                        case 1:
                        fieldtext=fieldtop.fieldtype.getKey()
                        break
                        default:
                        zufall_feld = random.nextInt(4)
                        fieldtext = possible_fields[zufall_feld]
                    }
                }
                else if(fieldleft){
                    switch(zufall){
                        case 0:
                        fieldtext=fieldleft.fieldtype.getKey()
                        break
                        default:
                        zufall_feld = random.nextInt(4)
                        fieldtext = possible_fields[zufall_feld]
                    }
                }else{
                    zufall_feld = random.nextInt(4)
                    fieldtext = possible_fields[zufall_feld]
                }
                field = new Map(xaxis:xcor,yaxis:ycor,fieldtype:fieldtext,staerkefaktor:(fieldlvls2[random.nextInt(14)])).save()
            }
        }
        System.out.println("nun userfelder erstellen")
        
        for (int ycor = 4; ycor < fieldsize;ycor+=9){
            for (int xcor = 4; xcor < fieldsize;xcor+=9){
                int randomex = random.nextInt(5)-2
                int randomey = random.nextInt(5)-2
                field = Map.findByXaxisAndYaxis(xcor+randomex,ycor+randomey)
                field.fieldtype = "user"
            }
        }
        System.out.println("fertig")
        

        /*
         *            System.out.println("\n\n\n nun collection machen wa\n\n\n")

        def allfields = Map.withCriteria {
        ge("x",0)
        }

        allfields.each{System.out.println(it)}
         */

        /*ROLES*/
 
		def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
        /*ITEMS*/
        
		def item01 = new Item(itemName: 'Monokel',dateiName: 'Monokel.png',itemType: 'acc', staerke: 0,intelligenz:3,coolness:1,geschwindigkeit:0,candy:10).save()
        def i1 = Item.findByItemName('Monokel')

		def item02 = new Item(itemName: 'Propellerhut',dateiName: 'Propellerhut.png',itemType: 'kpf', staerke: 1,intelligenz:1,coolness:3,geschwindigkeit:10,candy:15).save()
		def i2 = Item.findByItemName('Propellerhut')
		
		def item03 = new Item(itemName: 'Blinkeschuhe',dateiName: 'Blinkeschuhe.png',itemType: 'rus', staerke: 4,intelligenz:0,coolness:2,geschwindigkeit:20,candy:20).save()
		def i3 = Item.findByItemName('Blinkeschuhe')
		
		def item04 = new Item(itemName: 'Schleuder',dateiName: 'Schleuder.png',itemType: 'waf', staerke: 10,intelligenz:0,coolness:2,geschwindigkeit:0,candy:25).save()
		def i4 = Item.findByItemName('Schleuder')
/*MONSTER*//*XYZ
		def monster001 = new Monster(name:'Ratte', wtyp: 'nah', goldmult:1, strmult:0.8, gesmult:0.5, inzmult:0.1, hpmult:0.7, expmult:1.2).save()
		def monster002 = new Monster(name:'Wolf', wtyp: 'nah', goldmult:1.2, strmult:1.2, gesmult:0.8, inzmult:0.3, hpmult:0.7, expmult:1.4).save()
		def monster003 = new Monster(name:'Ork', wtyp: 'nah', goldmult:1.4, strmult:2.0, gesmult:0.8, inzmult:0.1, hpmult:1.1, expmult:1.8).save()
		//def monster04 = new Monster(name:'Schwein',gold:30,wtyp: 'nah', str:20, ges:20, inz:100, exp:50, curhp:250, maxhp:250).save()
		//def monster05 = new Monster(name:'Jude',gold:5000,wtyp: 'fer', str:1, ges:1, inz:1, exp:1000, curhp:10, maxhp:19).save()
		//def monster06 = new Monster(name:'Peter Lustig',gold:60,wtyp: 'nah', str:40, ges:30, inz:100, exp:50, curhp:250, maxhp:250).save()

        /*ITEMS*/

        /*ADMIN*/
        def testUser = new User(username: 'me', enabled: true, password: 'p', gold:new Value()).save(flush: true)
		/*User Role zuweisung*/
		UserRole.create testUser, adminRole, true

		 /*ADMIN*/

        /*USER+Items+Units*/
        /*USER*/

		
        def testUser2 = new User(username: 'xian', email: 'xian@gmail.com', enabled: true, password: 'p', candy:new Value()).save()
        def xian = User.findByUsername('xian')
		/*User Role zuweisung*/
		UserRole.create testUser2, userRole, true
		/*Map zuweisen*/
        
/*XYZ
		if(freemapfields())usertomap(xian)
		
        /*Items*/  
		def ua11 = new com.bgame.Usritm()
        ua11.link(i1,xian).save()
        
		def ua12 = new com.bgame.Usritm()
        ua12.link(i2,xian).save()
		
		def ua13 = new com.bgame.Usritm()
		ua13.link(i3,xian).save()
		
		def ua14 = new com.bgame.Usritm()
		ua14.link(i4,xian).save()
        /*Units*/
		
		//System.out.println("hiers noch ok aaaaaaaaaaber")
        testUser2.addToUnits(new Unit(name: 'Xian', main: true)).save()
		testUser2.addToUnits(new Unit(name: 'Robert', main: false))
		def xianUnit1 = Unit.findByName('Xian')
		
		ua11.linkunit(ua11.id, xianUnit1)
		//ua12.linkunit(ua12.id, xianUnit1)
		//ua13.linkunit(ua13.id, xianUnit1)
		//ua14.linkunit(ua14.id, xianUnit1)
		/*XYZ
		System.out.println("hier gehts doch weiter! :D")
		testUser2.addToUnits(new Unit(name: 'mongo', main: false,ferexp: 6523, nahexp: 150, magexp : 150,wtyp: 'fer'))
        testUser2.unitcount = 2
        testUser2.save(flush: true)
        testUser2.units.each { it.recalcUnit() }
		setMonsterArroundUser(xian)
        /*User Role zuweisung UNTEN!*/


        /*USER+Items+Units*/
        /*USER*/
        /*XYZ
		def testUser3 = new User(username: 'paco', email: 'paco@gmail.com', enabled: true, password: 'p', gold:new Value()).save()
        def paco = User.findByUsername('paco')
        /*Map zuweisen*/
        /*XYZ
		if(freemapfields())usertomap(paco)
        /*Items*/

		/*XYZ
        def ua21 = new com.bgame.Usritm()
        ua21.link(i2,paco).save()
        def ua22 = new com.bgame.Usritm()//UNITS MIT EINBEZIEHEN!!!!!
        ua22 = ua22.link(i1,paco).save()
        
        def ua23 = new com.bgame.Usritm()
        ua23 = ua23.link(i6,paco).save()
        /*Units*/
        /*XYZ
		testUser3.addToUnits(new Unit(name: 'Paco', main: true, ferexp: 12000, nahexp: 800, magexp : 150,wtyp: 'fer'))
        testUser3.addToUnits(new Unit(name: 'Cora', main: false,ferexp: 150, nahexp: 150, magexp : 13000,wtyp: 'mag'))
        testUser3.unitcount = 2
        testUser3.save(flush: true)
        def upaco = Unit.findByName('Paco')
        ua22 = ua22.linkunit(ua22.id,upaco)
        def ucora = Unit.findByName('Cora')
        ua23 = ua23.linkunit(ua23.id,ucora)
        testUser3.units.each { it.recalcUnit() }
		setMonsterArroundUser(paco)

        /*User Role zuweisung UNTEN!*/


        /*USER+Items+Units*/
        /*USER*/
        /*XYZ
		def testUser4 = new User(username: 'janis', email: 'janis@gmail.com', enabled: true, password: 'p', gold:new Value()).save()
        def janis = User.findByUsername('janis')
        /*Map zuweisen*/
        /*XYZ
		if(freemapfields())usertomap(janis)
        /*Items*/
        /*XYZ
		def ua31 = new com.bgame.Usritm()
        ua31.link(i1,janis).save()
        //def ua32 = new com.bgame.Usritm()
        //ua32.link(i4,janis).save()
        /*Units*/
        /*XYZ
		testUser4.addToUnits(new Unit(name: 'Janis', main: true, ferexp: 750, nahexp: 9000, magexp : 150,wtyp: 'nah'))
        testUser4.addToUnits(new Unit(name: 'Jizzalot', main: false,ferexp: 8000, nahexp: 150, magexp : 150,wtyp: 'fer'))
        testUser4.unitcount = 2
        testUser4.save(flush: true)
        testUser4.units.each { it.recalcUnit() }
		setMonsterArroundUser(janis)
		/*User Role zuweisung UNTEN!*/

		
		
		
		/*USER+Items+Units*/
		/*USER*/
/*XYZ
		def testUser5 = new User(username: 'testo', email: 'testo@gmail.com',enabled: true, password: 'qwert123$', gold:new Value()).save()
		def testo = User.findByUsername('testo')
		/*Map zuweisen*//*XYZ
		if(freemapfields())usertomap(testo)
		/*Items*/
		/*Units*//*XYZ
		testUser5.addToUnits(new Unit(name: 'Testo', main: true, ferexp: 150, nahexp: 150, magexp : 150,wtyp: 'nah'))
		testUser5.unitcount = 1
		testUser5.save(flush: true)
		testUser5.units.each { it.recalcUnit() }
		setMonsterArroundUser(testo)
		/*User Role zuweisung UNTEN!*/		
		
		
		/*USER+Items+Units*/
		/*USER*/
/*XYZ
		def testUserjoe = new User(username: 'joe', email: 'joe@gmail.com', enabled: true, password: 'qwert123$', gold:new Value()).save()
		def joe = User.findByUsername('joe')
		/*Map zuweisen*/
/*XYZ
		if(freemapfields())usertomap(joe)
		/*Items*/
		/*Units*/
/*XYZ
		testUserjoe.addToUnits(new Unit(name: 'joe', main: true, ferexp: 150, nahexp: 150, magexp : 150,wtyp: 'nah'))
		testUserjoe.unitcount = 1
		testUserjoe.save(flush: true)
		testUserjoe.units.each { it.recalcUnit() }
		setMonsterArroundUser(joe)
		/*User Role zuweisung*//*XYZ
		UserRole.create testUserjoe, userRole, true
		/*next user*/
		
		
		
		/*USER+Items+Units*/
		/*USER*/
		/*XYZ
		def testUserbubi = new User(username: 'bubi', email: 'bubi@gmail.com', enabled: true, password: 'p', gold:new Value()).save()
		def bubi = User.findByUsername('bubi')
		/*Map zuweisen*/
		/*XYZ
		if(freemapfields())usertomap(bubi)
		/*Items*/
		/*Units*/
		/*XYZ
		testUserbubi.addToUnits(new Unit(name: 'bubi', main: true, ferexp: 150, nahexp: 150, magexp : 150,wtyp: 'nah'))
		testUserbubi.unitcount = 1
		testUserbubi.save(flush: true)
		testUserbubi.units.each { it.recalcUnit() }
		setMonsterArroundUser(bubi)
		/*User Role zuweisung*/
		/*XYZ
		UserRole.create testUserbubi, userRole, true
		/*next user*/
		
		
		/*USER+Items+Units*/
		/*USER*/
		/*XYZ
		def testUserhans = new User(username: 'hans', email: 'hans@gmail.com', enabled: true, password: 'p', gold:new Value()).save()
		def hans = User.findByUsername('hans')
		/*Map zuweisen*/
		/*XYZ
		if(freemapfields())usertomap(hans)
		/*Items*/
		/*Units*/
		/*XYZ
		testUserhans.addToUnits(new Unit(name: 'hans', main: true, ferexp: 150, nahexp: 150, magexp : 150,wtyp: 'nah'))
		testUserhans.unitcount = 1
		testUserhans.save(flush: true)
		testUserhans.units.each { it.recalcUnit() }
		setMonsterArroundUser(hans)
		/*User Role zuweisung*/
		/*XYZ
		UserRole.create testUserhans, userRole, true
		/*next user*/
		//ende weitere USER
		
		
      //  assert User.count() == 5      
	 //	  assert Role.count() == 2
      //  assert UserRole.count() == 5

    }

    def destroy = {
    }

    def freemapfields(){
        def result = true
        def lastfield = Map.findByXaxisAndYaxis(2,2)
        if(lastfield.user != null) result = false
        result
    }

    def getUserfield(dafieldx,dafieldy){
        def field
        def xstart = dafieldx-2
        def ystart = dafieldy-2
        for (int ycor = ystart; ycor < ystart+5;ycor++){
            for (int xcor = xstart; xcor < xstart+5;xcor++){
                field = Map.findByXaxisAndYaxis(xcor,ycor)
                if(field.fieldtype.getKey() == "user"){
                    System.out.println("hab!!!!!!!!!!!")
                    return field
                }
                else{
                    System.out.println("nopedipope:(${xcor}/${ycor}) ")
                }
            }
        }
    }
	
	
	def usertomap(user){
		def startx = 22
		def starty = 22
		def field = getUserfield(startx,starty)
		def done = false
		def distance = 1
		def distancecopy = distance
		def times = 2
		def richtungen = ["oben","rechts","unten","links"]
		def richtunglauf = 0
		def richtung = richtungen[richtunglauf]
		while(!done){
			if(!field.hasUser()){
				user.addToFields(field)
				done = true
			}
			if(!done){
				if(distancecopy <= 0){
					times--					
					if(richtunglauf < 3){
						richtunglauf++
						richtung = richtungen[richtunglauf]
					}else{
						richtunglauf = 0
						richtung = richtungen[richtunglauf]
					}
					if(times == 0){
						times = 2
						distance++
					}
					distancecopy = distance
				}
				distancecopy--
				switch(richtung){
					case "oben":
					starty -= 9
					break
					case "rechts":
					startx += 9
					break
					case "unten":
					starty += 9
					break
					case "links":
					startx -= 9
					break
				}

				field = getUserfield(startx,starty)
			}
		}
	}
	
		
    // def (fieldsize-1)/2
    def setMonsterArroundUser(dauser){
		def fieldexp = dauser.mapexp()
		def userfield = dauser.fields()
		def startx = userfield[0].xaxis
        def starty = userfield[0].yaxis
		def field = Map.findByXaxisAndYaxis(startx,starty)
		def done = false
        def distance = 1
        def distancecopy = distance
        def times = 2
        def richtungen = ["oben","rechts","unten","links"]
        def richtunglauf = 0
        def richtung = richtungen[richtunglauf]
		def random = new Random()
		def fieldlvls1 = [1.0,1.3,1.6,1.4,1.2,1.5,1.0,1.6,1.9]
		def fieldlvls2 = [1.9,1.9,2,2,1.3,2,2.3,2.6,2.9,3,1.3,1.6,1.6,1.9]
		
		def fieldlvlscount1 = 9
		Collections.shuffle(fieldlvls1)
		
		for(int i = 0;i < 7*7;i++){			
			if(i< fieldlvlscount1){
				field.staerkefaktor = fieldlvls1[i]
				}else{
            field.staerkefaktor = fieldlvls2[random.nextInt(14)]
			}
			
			
			field.monsterexp = fieldexp
               if(distancecopy <= 0){
                    times--                    
                    if(richtunglauf < 3){
                        richtunglauf++
                        richtung = richtungen[richtunglauf]
                    }else{
                        richtunglauf = 0
                        richtung = richtungen[richtunglauf]
                    }
                    if(times == 0){
                        times = 2
                        distance++
                    }
					distancecopy = distance
                }
                distancecopy--
                switch(richtung){
                    case "oben":
                    starty -= 1
                    break
                    case "rechts":
                    startx += 1
                    break
                    case "unten":
                    starty += 1
                    break
                    case "links":
                    startx -= 1
                    break
                }
				
                field = Map.findByXaxisAndYaxis(startx,starty)
            
        }
    }
    // 1Ho 1Re 2Ru 2Li 3Ho 3Re 4 Ru 4 Li bis x =
    // 5er sprünge bis x und y == 2 (oder y und x == 3 wenn index bei 1 beginnt (x-1 und y-1 beim zuweisen))
}


