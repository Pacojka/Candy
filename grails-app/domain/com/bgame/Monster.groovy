package com.bgame

class Monster {
    String name
    int gold = 25
    MyEnum wtyp = "nah"
    int str = 1
    int ges = 1
    int inz = 1
    int exp = 15
    int monsterexp = 125
    int curhp = 999
    int maxhp = 999

    static constraints = {
        name blank: false, unique: true

    }
    public enum MyEnum {

        nah("Nahkampf"),
        fer("Fernkampf"),
        mag("Magie")

        final String value
        MyEnum (String value) {
            this.value = value
        }
        String toString() { value }
        String getKey() { name() }
    }

def addmonsterexp(davalue){
    this.monsterexp += (int)davalue

}
    def dmg(){
        def dmg = this.str
        def min = 0
        def max = 0
        def random = new Random()
        if ((min+max)>0){
            dmg += min
            dmg += random.nextInt((max-min))
        }
        return dmg
    }
def createcopy(monster){
    this.name = monster.name
    this.gold = monster.gold
    this.wtyp = monster.wtyp.getKey()
    this.str = monster.str
    this.ges = monster.ges
    this.inz = monster.inz
    this.exp = monster.exp

    this.curhp = monster.curhp
    this.maxhp = monster.maxhp
}
    def setwtype(newWtype){
    //    System.out.println("\n so hier wegen setWtype\nnewWtype: "+newWtype+"\n gerade wtype: "+this.wtyp.getKey())
        if (newWtype != this.wtyp.getKey()){
            this.wtyp = newWtype
        }
    }
    String toString(){
        return "${name} (${curhp}/${maxhp})"
    }
}