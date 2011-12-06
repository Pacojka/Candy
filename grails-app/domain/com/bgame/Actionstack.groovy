package com.bgame

class Actionstack {
    Date starttime
    Date endtime
    Map destinationmap
    User user
    static hasMany = [units:Unit]
    Value goldgain = new Value()
    Actionenum actiontype = "hin"

    static embedded = ['goldgain']
    static constraints = {
        endtime(nullable:true)
    }

    public enum Actionenum {
        hin("Hinweg"),
        rue("Rückweg"),
        kam("Kampf")
        final String value
        Actionenum (String value) {
            this.value = value
        }
        String toString() { value }
        String getKey() { name() }
    }

    def units(){
        return this.units.collect{it}.sort {it.dateCreated}
    }

    def fight(){
        action_type = "kam"
    }

    def travelBackSetGold(gold){
        def result = endtime.time - starttime.time + endtime.time
        endtime = new Date(result)
        goldgain.val = gold
        actiontype = "rue"
    }


    def travelSetTime(traveltime){
        goldgain.val = 0
        def result = starttime.time
        result += (traveltime*1000)
        endtime = new Date(result)
    }
}
