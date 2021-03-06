package com.bgame


class User {

	transient springSecurityService
	String email = ""
	String username
	String password
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired
	int unitcount = 0
	Value candy
	static hasMany = [useritems:Usritm, units:Unit,fields:Map, actions:Actionstack, messages:Message]
	static embedded = ['candy']

	String toString(){
		return "${username}"
	}

	static constraints = {
		username blank: false, unique: true
		email unique: true
		password blank: false
	}

	static mapping = { password column: '`password`' }

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
	def mapexp(){
		def result = 0
		units().each{result += it.getmapexp()}
		result
	}

	def messages(){
		return this.messages.collect{it}.sort {it.dateCreated}
	}
	def hasAvailableUnits(){
		def avCount = 0
		this.units.collect{if(!it.away())avCount++}
		return avCount
		}
	def units(){
		return this.units.collect{it}.sort {it.dateCreated}
	}
	def availableUnits(){
		return this.units.collect{if(!it.away())it}.sort {it.dateCreated}
	}
	def actions(){
		return this.actions.collect{it}.sort {it.starttime}
	}

	def fields(){
		return this.fields.collect{it}
	}
	def nextunitcost(){
		unitcount*unitcount*unitcount*100
	}

	def items(){
		return this.useritems.collect{it}.sort{it.id}
	}

	def noMaxHpUnits(){
		def result = []
		units().each{if(it.curhp < it.maxhp)result << it}
		return result
	}

	def nowpnunits(){
		def result = []
		units().each{if(!it.haswpn() && !it.away())result << it}
		return result
	}

	def nohlmunits(){
		def result = []
		units().each{if(!it.hashlm() && !it.away())result << it}
		return result
	}

	def noamuunits(){
		def result = []
		units().each{if(!it.hasamu() && !it.away())result << it}
		return result
	}

	def norustunits(){
		def result = []
		units().each{if(!it.hasrust() && !it.away())result << it}
		return result
	}

	def nohndunits(){
		def result = []
		units().each{if(!it.hashnd() && !it.away())result << it}
		return result
	}

	def nobnsunits(){
		def result = []
		units().each{if(!it.hasbns() && !it.away())result << it}
		return result
	}

	def nostfunits(){
		def result = []
		units().each{if(!it.hasstf() && !it.away())result << it}
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