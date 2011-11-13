package com.bgame

class Usritm {
    User user = null
    Item item = null
    Unit unit = null

    //static belongsTo = [user:User,item:Item]
    String toString(){
        def ergebnis = "wuut"
        if((user != null) && (item != null)){
            ergebnis = this.user.username+" besitzt " + this.item.itemname
        }else if((user = null) && (item != null)){
            ergebnis = "user null und item " + this.item.itemname
        }else if((user != null) && (item = null)){
            ergebnis = "item null und user " + this.user.username
        }else ergebnis = "beide nulll"
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
            }
            giveunit?.addToUseritems(u)
            u.save()
        }
        return u
    }
    

    static void unlinkunit(id) {
        def u = Usritm.findById(id)
        if (u)
        {
            if (u.unit != null) u.unit?.removeFromUseritems(u)
            u.save()
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








}
