package com.bgame

class Monster {
    String name
    int gold = 25 			// Gold
    MyEnum wtyp = "nah"		// Waffentyp
	double strmult = 1		//St‰rke Multiplikator
	double gesmult = 1		//Geschick Multiplikator
	double inzmult = 1		//Inteligenz Multiplikator
	double hpmult = 1
	double goldmult = 1
	double expmult = 1
	
	int str = 1				//St‰rke
    int ges = 1				//Geschick
    int inz = 1				//Inteligenz
    int exp = 15
    int monsterexp = 125
    int curhp = 999
    int maxhp = 999

    static constraints = {
        name blank: false, unique: true

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

def addmonsterexp(davalue){
    this.monsterexp += (int)davalue

}
    def dmg(){
        def dmg = this.str
        def min = 0
        def max = 0
        def random = new Random()
        if ((min+max)>0){
            dmg += min
            dmg += random.nextInt((max-min))
        }
        return dmg
    }
	
	def getlvl(davalue){
		def expToNextlvl = 100
		def i = 1
		for (i; davalue > expToNextlvl;++i){
			expToNextlvl+=25*(i*i)
			// System.out.println("\nfolgendes:\n exptoCurr:"+expTocurrlvl+" \nexptoNext:"+expToNextlvl+" \nund exp:"+exp)
		}
		(i-2)
	}

	def recalcMonster() {
	//alles auf str

		//str = Monsterexp * St‰rkemultiplikator 
		this.str = 3+ getlvl((int)(this.monsterexp*this.strmult))
		
		//ges =
		this.ges = 2+ getlvl((int)(this.monsterexp*this.gesmult))
		//inz = 150% Mag + 0% Fernkampf + 0% Nahkampf
		this.inz = 1+ getlvl((int)(this.monsterexp*this.inzmult))
		
		//exp f√ºr den exppool im kampf
		this.exp = (int)((this.str+this.ges+this.inz)*2*this.expmult)
		
		this.gold = (int)((this.str+this.ges+this.inz)*2* this.goldmult)
		
		this.maxhp = (int)((this.str*20+this.ges*10+this.inz*5)*this.hpmult) //wie units...
		this.curhp = this.maxhp
		System.out.println("recalced monster with ${monsterexp} Monsterexp\nValues:\nStr:${str}\nGes:${ges}\nInz:${inz}\nGold:${gold}\nExp:${exp}\nHp:${curhp}")
		
	}
	
	
def createcopy(monster){
    this.name = monster.name
    this.gold = monster.gold
    this.wtyp = monster.wtyp.getKey()
	this.strmult = monster.strmult
	this.gesmult = monster.gesmult
	this.inzmult = monster.inzmult
    this.hpmult = monster.hpmult
    this.maxhp = monster.maxhp
}

    def setwtype(newWtype){
    //    System.out.println("\n so hier wegen setWtype\nnewWtype: "+newWtype+"\n gerade wtype: "+this.wtyp.getKey())
        if (newWtype != this.wtyp.getKey()){
            this.wtyp = newWtype
        }
    }
    String toString(){
        return "${name} (${curhp}/${maxhp})"
    }
}