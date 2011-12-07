package com.bgame

class Message {
 Date dateCreated
 String titel
 String text
 User user
 User sender
    static constraints = {
        sender(nullable:true)
    }
}
