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
    static hasMany = [useritems:Usritm, units:Unit]

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
    
    def nowpnunis(){
      def result = []
      units().each{if(!it.haswpn())result << it}
      return result
    }

    def uneqitems(){       
      def result = []
      items().each{if(!it.isequipted())result << it}
      return result
    }
    


}
