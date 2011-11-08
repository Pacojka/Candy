package com.bgame

class Item {
    String item_name
    ItemEnum item_type
    int dmgmin
    int dmgmax
    int defens
    int gold
    static hasMany = [useritem:UserItem]

    static constraints = {
    }
        public enum ItemEnum {

        nah("Nahkampf"),
        fer("Fernkampf"),
        mag("Magie"),
        rust("Ruestung")
        final String value
        ItemEnum (String value) {
            this.value = value
        }
        String toString() { value }
        String getKey() { name() }
    }
}
