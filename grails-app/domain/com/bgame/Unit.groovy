package com.bgame

class Unit {
    String name
    User user
    boolean main = false
    Date dateCreated
    int gold = 25
    MyEnum wtyp = "nah"
    boolean away = false

    int ferexp = 125
    int nahexp = 125
    int magexp = 125
    int exp = 1
    int ferlvl = 1
    int ferToNext = 0
    int nahlvl = 1
    int nahToNext = 0
    int maglvl = 1
    int magToNext = 0
    
    int str = 1
    int strToNext = 1
    int ges = 1
    int gesToNext = 1
    int inz = 1
    int inzToNext = 1

    int curhp = 999
    int curhppr = 100
    int maxhp = 999
    
    static hasMany = [useritems:Usritm]
    static belongsTo = User
    static constraints = {
		
        name  unique: 'user', validator: {
				return it.length() != 0
			}

    }

    public enum MyEnum {

        nah("Nahkampf"),
        fer("Fernkampf"),
        mag("Magie")

        final String value
        MyEnum (String value) {
            this.value = value
        }
        String toString() { value }
        String getKey() { name() }
    }

    //in isAway umbenennnnen! :D
    def away(){
        away
    }
        def setAway(){
        away = true
    }
    def setBack(){
        away = false
    }
    def toggleinbase(){
        away = !away
    }
    def healcost(){
        def cost
        if(curhp == 0) cost = (int)(maxhp*0.2)
        else cost = (int)(((maxhp-curhp)*0.1))
        return cost
    }

    def heal(){
        curhp = maxhp
        this.calchppr()
    }

    def healx(value){
        curhp += value
        if (curhp > maxhp)curhp = maxhp
        this.calchppr()
    }

    def dmg(){
        def dmg = this.str
        def min = 0
        def max = 0
        def random = new Random()

        items().each{
            min += it.item.dmgmin
            max += it.item.dmgmax
        }
        if ((min+max)>0){
            dmg += min
            dmg += random.nextInt((max-min))
        }
        return dmg
    }


    def items(){
        return this.useritems.collect{it}.sort{it.item.itemname}
    }

    def addgold(value){
        gold += value
    }

    def notequipteditemtypes(){
        def haswpn = haswpn()
        def hashlm = hashlm()
        def hasamu = hasamu()
        def hasrust = hasrust()
        def hashnd = hashnd()
        def hasbns = hasbns()
        def hasstf = hasstf()
        def result = []
        user.uneqitems().each{
            switch ( it.item.item_type.getKey() ) {

                case "hlm":
                if(!hashlm)result << it
                break
                case "amu":
                if(!hasamu)result << it
                break
                case "rust":
                if(!hasrust)result << it
                break
                case "hnd":
                if(!hashnd)result << it
                break
                case "bns":
                if(!hasbns)result << it
                break
                case "stf":
                if(!hasstf)result << it
                break

                default:
                if(!haswpn)result << it
            }
        }
        result
    }
  
    def haswpn(){
        def rueckgabe = false
        this.items().each{
            if ((it.item.item_type.getKey() == "nah") || (it.item.item_type.getKey() == "fer")|| (it.item.item_type.getKey() == "mag")){
                rueckgabe = true
            }
        }
        rueckgabe
    }
    def setwtype(newWtype){
        //    System.out.println("\n so hier wegen setWtype\nnewWtype: "+newWtype+"\n gerade wtype: "+this.wtyp.getKey())
        if (newWtype != this.wtyp.getKey()){
            this.wtyp = newWtype
        }
    }

    def hashlm(){
        def rueckgabe = false
        this.items().each{
            if (it.item.item_type.getKey() == "hlm"){
                rueckgabe = true
            }
        }
        rueckgabe
    }

    def hasamu(){
        def rueckgabe = false
        this.items().each{
            if (it.item.item_type.getKey() == "amu"){
                rueckgabe = true
            }
        }
        rueckgabe
    }

    def hasrust(){
        def rueckgabe = false
        this.items().each{
            if (it.item.item_type.getKey() == "rust"){
                rueckgabe = true
            }
        }
        rueckgabe
    }

    def hashnd(){
        def rueckgabe = false
        this.items().each{
            if (it.item.item_type.getKey() == "hnd"){
                rueckgabe = true
            }
        }
        rueckgabe
    }

    def hasbns(){
        def rueckgabe = false
        this.items().each{
            if (it.item.item_type.getKey() == "bns"){
                rueckgabe = true
            }
        }
        rueckgabe
    }

    def hasstf(){
        def rueckgabe = false
        this.items().each{
            if (it.item.item_type.getKey() == "stf"){
                rueckgabe = true
            }
        }
        rueckgabe
    }

    def recalcwpntype(){
        def rueckgabe = null
        this.items().each{
            if ((it.item.item_type.getKey() == "nah") || (it.item.item_type.getKey() == "fer")|| (it.item.item_type.getKey() == "mag")){
                rueckgabe = it.item.item_type.getKey()
            }
        }
        if(!rueckgabe){rueckgabe = "nah"}
        if(wtyp != rueckgabe)wtyp = rueckgabe

    }
	
	def getlvl(exp){
		def expToNextlvl = 100
		def expTocurrlvl = 0
		def i = 1
		for (i; exp > expToNextlvl;++i){
			expTocurrlvl = expToNextlvl
			expToNextlvl+=25*(i*i)
			// System.out.println("\nfolgendes:\n exptoCurr:"+expTocurrlvl+" \nexptoNext:"+expToNextlvl+" \nund exp:"+exp)
		}
		((1-(expToNextlvl-exp)/(expToNextlvl-expTocurrlvl))+(i-2))
	}

    def recalcUnit() {
		if (this.curhp <= 0 && this.main)this.curhp = 1
        def number = getlvl(this.ferexp)
        if((int)number != this.ferlvl)this.ferlvl = (int)number
        if(this.ferToNext != (int)(100*(number - this.ferlvl)))this.ferToNext = (int)(100*(number - this.ferlvl))

        number = getlvl(this.nahexp)
        if((int)number != this.nahlvl)this.nahlvl = (int)number
        if(this.nahToNext != (int)(100*(number - this.nahlvl)))this.nahToNext = (int)(100*(number - this.nahlvl))

        number = getlvl(this.magexp)
        if((int)number != this.maglvl)this.maglvl = (int)number
        if(this.magToNext != (int)(100*(number - this.maglvl)))this.magToNext = (int)(100*(number - this.maglvl))


        //str = 120% Nahkampf + 30% Fernkampf + 0 %Mag
        number = getlvl((this.nahexp*1.2)+(this.ferexp*0.3))
        if(this.str !=9 + (int)number)this.str =9 + (int)number
        this.strToNext = (int)(100*(number-(int)number))

        //ges = 120% fernkamp + 30% Nahkampf + 0% mag
        number = getlvl((this.ferexp*1.2)+(this.nahexp*0.3))
        if(this.ges !=9 + (int)number)this.ges =9 + (int)number
        this.gesToNext = (int)(100*(number-(int)number))

        //str = 150% Mag + 0% Fernkampf + 0% Nahkampf
        number = getlvl((this.magexp*1.5))
        if(this.inz != 9 + (int)number)this.inz =9 + (int)number
        this.inzToNext = (int)(100*(number-(int)number))
        //exp für den exppool im kampf
        this.exp = (this.str+this.ges+this.inz)*2

        def maxihp = this.str*20+this.ges*10+this.inz*5
        if (maxihp != this.curhp){
            if (this.maxhp != maxihp)this.maxhp = maxihp;
            if (this.curhp > this.maxhp) this.curhp = this.maxhp
            if (this.curhp < 0) this.curhp = 0
            this.calchppr()
        }
        

    }
    def calchppr(){
        if (this.curhp <= 0){
            this.curhppr = 0
        }
        else if(this.curhp == this.maxhp){
            this.curhppr = 100
        }else{
            this.curhppr = this.curhp/(this.maxhp /100)
        }
    }

	def getmapexp(){
		def mapexp = 0
		if((magexp <= ferexp) && (magexp <= nahexp)){
			mapexp = (ferexp + nahexp)
			}else if((ferexp <= magexp) && (ferexp <= nahexp)){
			mapexp = (magexp + nahexp)
			}else{mapexp = (magexp + ferexp)}
		}
	
    String toString(){
        return "${name}"
    }
}
