package com.bgame

class Item {
    String itemname = "boooom"
    ItemEnum item_type = "nah"
    int dmgmin = 1
    int dmgmax = 2
    int defens = 0
    int gold = 3
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
