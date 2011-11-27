package com.bgame


class User {

    transient springSecurityService

    String username
    String password
    boolean enabled
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired
    int unitcount = 0
    Value gold
    static hasMany = [useritems:Usritm, units:Unit]
    static embedded = ['gold']

    String toString(){
        return "${username}"
    }
    
    static constraints = {
        username blank: false, unique: true
        password blank: false
    }

    static mapping = {
        password column: '`password`'
    }

    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this).collect { it.role } as Set
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService.encodePassword(password)
    }

    def units(){
        return this.units.collect{it}.sort {it.dateCreated}
    }


    def items(){
        return this.useritems.collect{it}.sort{it.id}
    }
    
    def nowpnunits(){
        def result = []
        units().each{if(!it.haswpn())result << it}
        return result
    }

    def nohlmunits(){
        def result = []
        units().each{if(!it.hashlm())result << it}
        return result
    } 

    def noamuunits(){
        def result = []
        units().each{if(!it.hasamu())result << it}
        return result
    }

    def norustunits(){
        def result = []
        units().each{if(!it.hasrust())result << it}
        return result
    }

    def nohndunits(){
        def result = []
        units().each{if(!it.hashnd())result << it}
        return result
    }

    def nobnsunits(){
        def result = []
        units().each{if(!it.hasbns())result << it}
        return result
    }

    def nostfunits(){
        def result = []
        units().each{if(!it.hasstf())result << it}
        return result
    }


    def getitemunits(type){
        def result = []

        switch ( type ) {

            case "hlm":
            result = nohlmunits()
            break
            case "amu":
            result = noamuunits()
            break
            case "rust":
            result = norustunits()
            break
            case "hnd":
            result = nohndunits()
            break
            case "bns":
            result = nobnsunits()
            break
            case "stf":
            result = nostfunits()
            break

            default:
            result = nowpnunits()
        }
        result
    }



    def uneqitems(){       
        def result = []
        items().each{if(!it.isequipted())result << it}
        return result
    }
    


}