package com.bgame

class Item {
    String itemname = "NAMENVERgaeeeeben"
    ItemEnum item_type = "nah"
    int dmgmin = 0
    int dmgmax = 0
    int defens = 0
    int gold = 99999
    int str = 0
    int ges = 0
    int inz = 0
//    int spd = 0
    static hasMany = [useritems:Usritm]

    String toString(){
        return "${itemname}"
    }
    static constraints = {
    }



    public enum ItemEnum {

        nah("Nahkampf"),
        fer("Fernkampf"),
        mag("Magie"),
        hlm("Helm"),
        amu("Amulett"),
        rust("Rüstung"),
        hnd("Handschuhe"),
        bns("Beinschutz"),
        stf("Stiefel")


        final String value
        ItemEnum (String value) {
            this.value = value
        }
        String toString() { value }
        String getKey() { name() }
    }



}
