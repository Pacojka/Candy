package com.bgame

class Unit {
	static final float ZUFRIEDENHEITS_KOSTEN_MULTIPLIKATOR = 0.2f
	static final int BASIS_GESCHWINDIGKEIT = 20
	static final int MAX_ZUFRIEDENHEIT = 1000
	static final int MAX_WACHHEIT = 1000
	
    String name
    
	//aussehen
	String teint ="empty.png"
	String kleidung ="empty.png"
	String variation ="empty.png"
	
	String ruestung ="empty.png"
	String accessoire ="empty.png"
	String kopfbedeckung ="empty.png"
	String waffe ="empty.png"
	
	User user
    boolean main = false
    Date dateCreated
    int candy = 25
    boolean unterwegs = false
	boolean wach = true
	
	int staerke = 1
	int intelligenz = 1
	int coolness = 1
	
	int geschwindigkeit = BASIS_GESCHWINDIGKEIT
	
	int schaden = 1 			//staerke
	int ausweichchance = 1		//intelligenz
	int schdensReduktion = 1	//coolness
	
    int zufriedenheit = MAX_ZUFRIEDENHEIT
    int zufriedenheitPr = 100
  
	int wachheit = MAX_WACHHEIT
	int wachheitPr = 100
  
    static hasMany = [useritems:Usritm]
    static belongsTo = User
    static constraints = {
		
        name  unique: 'user', validator: {
				return it.length() != 0
			}

    }

	def getTeint(){
		this.teint
	}

	def setTeint(wert){
		this.teint = wert
	}
		
	def getKleidung(){
		this.kleidung
	}

	def setKleidung(wert){
		this.kleidung = wert
	}
	
	def getVariation(){
		this.variation
	}

	def setVariation(wert){
		this.variation = wert
	}
	
	def getRuestung(){
		this.ruestung
	}

	def setRuestung(wert){
		this.ruestung = wert
	}
		
	def getAccessoire(){
		this.accessoire
	}

	def setAccessoire(wert){
		this.accessoire = wert
	}
	
	def getKopfbedeckung(){
		this.kopfbedeckung
	}

	def setKopfbedeckung(wert){
		this.kopfbedeckung = wert
	}
		
	def getWaffe(){
		this.waffe
	}	
	
	def setWaffe(wert){
		this.waffe = wert
	}
	//SETTER FUER ALLE
	
	
    def getUnterwegs(){
        unterwegs
    }
        def setUnterwegs(){
        unterwegs = true
    }
    def setZurueck(){
        unterwegs = false
    }
    def toggleUnterwegs(){
        unterwegs = !unterwegs
    }
    def zufriedenheitsKosten(){
        def kosten
        if(zufriedenheit == 0) kosten = (int)(zufriedenheitMax*ZUFRIEDENHEITS_KOSTEN_MULTIPLIKATOR)
        else kosten = (int)(((maxhp-curhp)*ZUFRIEDENHEITS_KOSTEN_MULTIPLIKATOR/2))
        return kosten
    }

    def zufriedenheitMaxFuellen(){
        zufriedenheit = zufriedenheitMax
        this.calchppr()
    }

	def zufriedenheitPrBerechnen(){
		if (this.zufriedenheit <= 0){
			this.zufriedenheitPr = 0
		}
		else if(this.zufriedenheit == this.zufriedenheitMax){
			this.zufriedenheitPr = 100
		}else{
			this.zufriedenheitPr = this.zufriedenheit/(this.zufriedenheitMax /100)
		}
	}
	
    def zufriedenheitXFuellen(value){
        zufriedenheit += value
        if (zufriedenheit > zufriedenheitMax)zufriedenheit = zufriedenheitMax
        this.zufriedenheitPrBerechnen()
    }

    def berechneSchaden(){
        def schaden = this.staerke

        items().each{
            schaden += it.item.staerke
        }
        return schaden
    }


    def items(){
        return this.useritems.collect{it}.sort{it.item.itemname}
    }

    def addCandy(value){
        this.candy += value
    }

    def verfuegbareItems(){
        def hasAcc = hasAcc()
        def hasKpf = hasKpf()
        def hasRus = hasRus()
        def hasSpc = hasSpc()
        def hasWaf = hasWaf()
        def result = []
        user.uneqitems().each{
            switch ( it.item.item_type.getKey() ) {

                case "acc":
                if(!hasAcc)result << it
                break
                case "kpf":
                if(!hasKpf)result << it
                break
                case "rus":
                if(!hasRus)result << it
                break
                case "waf":
                if(!hasWaf)result << it
                break
            }
        }
        result
    }

	
    def hasAcc(){
        def rueckgabe = false
        this.items().each{
            if (it.item.item_type.getKey() == "acc"){
                rueckgabe = true
            }
        }
        rueckgabe
    }

    def hasKpf(){
        def rueckgabe = false
        this.items().each{
            if (it.item.item_type.getKey() == "kpf"){
                rueckgabe = true
            }
        }
        rueckgabe
    }

    def hasRus(){
        def rueckgabe = false
        this.items().each{
            if (it.item.item_type.getKey() == "rus"){
                rueckgabe = true
            }
        }
        rueckgabe
    }

    def hasWaf(){
        def rueckgabe = false
        this.items().each{
            if (it.item.item_type.getKey() == "waf"){
                rueckgabe = true
            }
        }
        rueckgabe
    }
	
	
    def recalcUnit() {
		
		this.schaden = 1 			//staerke
		this.ausweichchance = 1		//intelligenz
		this.schdensReduktion = 1	//coolness
		/*
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
        */

    }

/*
	def getmapexp(){
		def mapexp = 0
		if((magexp <= ferexp) && (magexp <= nahexp)){
			mapexp = (ferexp + nahexp)
			}else if((ferexp <= magexp) && (ferexp <= nahexp)){
			mapexp = (magexp + nahexp)
			}else{mapexp = (magexp + ferexp)}
		}
	*/
    String toString(){
        return "${name}"
    }
}
