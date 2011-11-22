package com.bgame

class Usritm {
    User user = null
    Item item = null
    Unit unit = null
    Date dateCreated

    //static belongsTo = [user:User,item:Item]
    String toString(){
        def ergebnis = item.itemname+": Dmg:"+item.dmgmin+"-"+item.dmgmax+",Vert.:"+item.defens
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
        def u = Usritm.findById(id)       
        if (u)
        {           
            if (u.unit != null) {
                u.unit?.removeFromUseritems(u)
                u.unit.setwtype("nah")
            }
            giveunit?.addToUseritems(u)
            giveunit.setwtype(u.item.item_type.getKey())
            u.save()

        }
        return u
    }
    

    static void unlinkunit(id) {
        def u = Usritm.findById(id)
        if (u)
        {
            if (u.unit != null) {
                u.unit.setwtype("nah")
                u.unit?.removeFromUseritems(u)
                u.save()
            }
        }
    }

    static void unlink(id,user) {
        def u = Usritm.findByIdAndUser(id,user)
        if (u)
        {
            u.item?.removeFromUseritems(u)
            user?.removeFromUseritems(u)
            if (u.unit != null) u.unit?.removeFromUseritems(u)
            u.delete()
        }
    }

    def isequipted(){
        def result = false
        if(this.unit)result = true
        result
    }

}
