package com.bgame

class Item {
    String itemName = "NAMENVERgaeeeeben"
	String dateiName = "NAMEN_VERgaeeeeben.png"
    ItemEnum itemType = "waf"
    int staerke = 0
    int intelligenz = 0
    int coolness = 0
    int geschwindigkeit = 0
	int candy = 99999

    static hasMany = [useritems:Usritm]

    String toString(){
        return "${itemname}"
    }
    static constraints = {
    }

	def getDateiName(){
		String pfad = dateiName
	}

    public enum ItemEnum {

        acc("Accessoire"),
        kpf("Kopfbedeckung"),
        rus("Ruestung"),
        waf("Waffe")

        final String value
        ItemEnum (String value) {
            this.value = value
        }
        String toString() { value }
        String getKey() { name() }
    }



}
