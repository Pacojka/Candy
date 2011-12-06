package com.bgame

class Map {
    int xaxis
    int yaxis
    Feldtypenum fieldtype = "fel"
    boolean main = false
    User user = null
    static constraints = {
        user(nullable:true)
    }

    def distance(destField){
        def scale = 12 //1227.89 ist cool! ca 83 min zu gegner
        def movespeed = 2.2
        def result = (int)((scale*Math.sqrt(((this.xaxis - destField.xaxis)*(this.xaxis - destField.xaxis))+ ((this.yaxis - destField.yaxis)*(this.yaxis - destField.yaxis))))/movespeed)
        
        result
    }

    def hasUser(){
        def result = false
        if(this.user) result = true
        result
    }
        String toString(){
            def add = ""            
            return "${fieldtype} (${xaxis},${yaxis})"
        }
        //allfields.sort(id)
        //allfields
    public enum Feldtypenum {
        user("User"),
        wal("Wald"),
        geb("Gebirge"),
        fel("Feld"),
        wue("Wüste"),
        doe("Dörfchen")
        final String value
        Feldtypenum (String value) {
            this.value = value
        }
        String toString() { value }
        String getKey() { name() }
    }
}
