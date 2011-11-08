package com.bgame

class UserItem {
    //User user
    //Item item
    Unit unit
    static belongsTo = [user:User,item:Item]
    static constraints = {
    }
}
