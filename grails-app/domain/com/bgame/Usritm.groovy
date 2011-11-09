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
        unit nullable:true
    }

    static Usritm link(item, user) {
        def u = Usritm.findByItemAndUser(item, user)
        if (!u)
        {
            u = new Usritm()
            item?.addToUseritems(u)
            user?.addToUseritems(u)
            u.save()
        }
        return u
    }

    static void unlink(item, user) {
        def u = Usritm.findByItemAndUser(item, user)
        if (u)
        {
            item?.removeFromUseritems(u)
            user?.removeFromUseritems(u)
            u.delete()
        }
    }








}
