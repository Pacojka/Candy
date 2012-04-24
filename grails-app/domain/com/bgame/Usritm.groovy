package com.bgame

class Usritm {
    User user = null
    Item item = null
    Unit unit = null
    Date dateCreated

    //static belongsTo = [user:User,item:Item]
    String toString(){
        def ergebnis = item.itemName+": Str.:"+item.staerke+", Int.:"+item.intelligenz+", Cns.:"+item.coolness+", Gesw.:"+item.geschwindigkeit
        return ergebnis
    }
	
    static constraints = {
        unit(nullable: true)
    }

    static Usritm link(item, user) {        
        def u = new Usritm()
        item?.addToUseritems(u)
        user?.addToUseritems(u)
        u.save()
        return u
    }

    static Usritm linkunit(id,giveunit) {
//         System.out.println("drinne")
        def u = Usritm.findById(id)
        if (u)
        {           
            if (u.unit != null) {
            }
            
            giveunit?.addToUseritems(u)
			switch ( u.item.item_type.getKey()) {				
								case "acc":
								giveunit.setAccessoire(u.item.getDateiName())
								break
								case "kpf":
								giveunit.setKopfbedeckung(u.item.getDateiName())
								break
								case "rus":
								giveunit.setRuestung(u.item.getDateiName())
								break
								case "waf":
								giveunit.setWaffe(u.item.getDateiName())
								break
							}
            u.save()

        }
        return u
    }
    

    static void unlinkunit(id) {
        def u = Usritm.findById(id)
        if (u)
        {
            if (u.unit != null) {
				
				
				switch ( u.item.item_type.getKey()) {
					case "acc":
					u.unit.setAccessoire("empty.png")
					break
					case "kpf":
					u.unit.setKopfbedeckung("empty.png")
					break
					case "rus":
					u.unit.setRuestung("empty.png")
					break
					case "waf":
					u.unit.setWaffe("empty.png")
					break
				}
				
				u.unit?.removeFromUseritems(u)
                u.save()
            }
        }
    }

    static void unlink(id,user) {
        def u = Usritm.findByIdAndUser(id,user)
        if (u)
        {
			if (u.unit != null){
				u.unlinkunit(u.id)
			}
			u.item?.removeFromUseritems(u)
            user?.removeFromUseritems(u)

            u.delete()
        }
    }

    def isequipted(){
        def result = false
        if(this.unit)result = true
        result
    }

}
