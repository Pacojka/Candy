package com.bgame

class Map {
    int xaxis
    int yaxis
    Feldtypenum fieldtype = "fel"

    static constraints = {
    }

    
        String toString(){
            return "${fieldtype} (${xaxis},${yaxis}))"
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
