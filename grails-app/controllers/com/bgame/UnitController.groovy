package com.bgame
import grails.plugins.springsecurity.Secured
class UnitController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def springSecurityService
    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def index = {
        def usrunits = lookupUser().units
        def useractions = lookupUser().actions()
        [useractions:useractions,userunits: usrunits,gold:lookupUser().gold.get()]

        //redirect(action: "userunits", params: params)
    }
    
    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def messages = {
        def messages = lookupUser().messages()
        [messages: messages,gold:lookupUser().gold.get()]
    }
	
	def gb = {
	}

    def messageview = {
        def damessage = Message.get(params.messageid)
        //if(damessage.user != lookupUser()){
        // redirect(action: "messages")

        //}else
        [message: damessage,gold:lookupUser().gold.get()]
    }

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def map = {
        def range 
        def x
        def y
        if(!params.newx){

            def field= lookupUser().fields()
            x = field[0].xaxis
            y = field[0].yaxis
            range = 6
        }else{
            range = Integer.parseInt(params.newrange)
            x = Integer.parseInt(params.newx)
            y = Integer.parseInt(params.newy)
        }

        def allfields = getfields(x,y,range)
        def nextcol = x + range
        // System.out.println("nach raussuchen")
        //allfields.each{System.out.println(it)}

        [rangenow:range,xnow:x,ynow:y,range:nextcol,fields: allfields,gold:lookupUser().gold.get()]
    }

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def fightquestion = {
        def usr = lookupUser()
        def usrfield = usr.fields()
        def destfield = Map.findByXaxisAndYaxis(params.x,params.y)
        def distance = usrfield[0].distance(destfield)
        if(usr==destfield.user)redirect(action: "index")
        def userUnits = lookupUser().units()
        [distance:distance,units:userUnits,user: usr,field:destfield ,gold:lookupUser().gold.get()]
    }

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def travel = {
        // user enemy und die felder raussuchen
        def usr = lookupUser()
        def usrfield = usr.fields()
        def destfield = Map.findByXaxisAndYaxis(params.x,params.y)
        //weg berechnen und die Action erzeugen und finden ende berechnen
        def distance = usrfield[0].distance(destfield)
        def now = new Date()
        def disAction = new Actionstack(starttime:now,destinationmap:destfield)
        usr.addToActions(disAction)
        disAction.travelSetTime(distance)

        def usrunits = []
        if(params.selectedUnits)params.selectedUnits.each{
            def daunit = Unit.get(it)
            if(daunit)if(daunit.user == lookupUser()){
                disAction.addToUnits(daunit)
                daunit.setAway()
            } 
        }
        //maybe message aber brauch nciht wir ja angezeigt
        redirect(action: "index")

    }

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def fight = {

        params.each{System.out.println(it)}
        def usrunits = []
        if(params.selectedUnits)params.selectedUnits.each{
            System.out.println("luuuuul\n\n\n")
            def daunit = Unit.get(it)
            if(daunit)if(daunit.user == lookupUser()) usrunits << daunit
        }
        def enemyunits = User.get(params.enemyid).units()
        def result = fightsim(usrunits, enemyunits)
        [result: result,gold:lookupUser().gold.get()]

    }
    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def sellquestion = {
        def ui = Usritm.findById(params.useritemid)
        [useritem: ui,gold:lookupUser().gold.get()]
    }
    
    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def sell = {
        def usr = lookupUser()
        def ui = new Usritm()
        ui.unlink(params.useritemid,usr)
        def g =Integer.parseInt(params.gold)
        usr.gold.add(g)
        usr.save(flush: true)
        redirect(action: "items")

    }

    def uvequipt = {

        if (params.useritemid != "null"){
            def ui = new Usritm()
            def unit = Unit.get(params.unitid)
            ui.linkunit(params.useritemid,unit).save()
        }
        redirect(action: "unitview", params:[unitid:params.unitid])

    }

    def equipt = {
        if (params.unitid != "null"){
            def ui = new Usritm()
            def unit = Unit.get(params.unitid)
            System.out.println("vorm linken!")
            ui.linkunit(params.useritemid,unit).save()
        }
        redirect(action: "items")

    }
 
    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def unequipt = {
        def ui = new Usritm()
        ui.unlinkunit(params.usritemid)
        redirect(action: "items")

    }

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def unequiptuv = {
        def ui = new Usritm()
        ui.unlinkunit(params.usritemid)
        redirect(action: "unitview", params:[unitid:params.unitid])

    }

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def shop = {
        def allitems = getShopItems()
        [items: allitems ,gold:lookupUser().gold.get()]

    }

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def shopbuy = {
        def allitems = getShopItems()
        def usr = lookupUser()
        def i = Item.findById(params.itemid)
        if(usr.gold.hasleft(i.gold) == true){
            def ui = new Usritm()
            ui.link(i,usr)
            usr.gold.sub(i.gold)
        }

        redirect(action: "shop")

    }


    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def unitview = {
        def thisunit = getUserUnit(params.unitid)
        def items = thisunit.useritems.collect{it}
        [unit: thisunit,items: items,gold:lookupUser().gold.get()]
    }

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def items = {
        def hisuseritems = lookupUser().items()
        [useritems: hisuseritems,gold:lookupUser().gold.get()]
    }

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def healer = {
        def usrunits = lookupUser().noMaxHpUnits()
        [userunits: usrunits,gold:lookupUser().gold.get()]
    }

    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def healunit = {
        def unit = Unit.get(params.unitid)
        lookupUser().gold.sub(unit.healcost())
        unit.addgold(unit.healcost())
        unit.heal()
        redirect(action: "healer")
    }

    def healteam (userteam) {
        userteam.each {
            it.curhp = it.maxhp
            it.calchppr()
        }
    }
    //KANN WEG WENNS IM ACTIONSTACK LÄUFT!!!!!!!!!!!!!!!!!!!!!!
    def fightsim(userteam, enemyteam) {
        def result = "" //rueckgabewert
        def roundcount = 0
        def t1count = 0
        userteam.each {if (it.curhp >0) t1count++}
        def unitcount = t1count
        def t2count = 0
        enemyteam.each {if (it.curhp >0) t2count++}
        def random = new Random()
        if (t2count > unitcount) {
            unitcount = t2count
        }
        def goldpool = 0
        def t1exppool = 1
        def t2exppool = 1
        def t1hppool = 1
        def t2hppool = 1

        userteam.each {
            if (it.curhp > 0){
                t1exppool += (int)(it.exp/(it.maxhp/it.curhp))
                t1hppool += it.curhp
            }
        }
        def t1dpexp = (int)(t1hppool/t1exppool)

        enemyteam.each {
            if (it.curhp > 0){
                t2exppool += (int)(it.exp/(it.maxhp/it.curhp))
                t2hppool += it.curhp
            }
        }
        def t2dpexp = (int)(t2hppool/t2exppool)
        while (t1count > 0 && t2count > 0){
            roundcount++
            result += "Round."+roundcount+" begins:<br>"

            for (int i = 0; i < unitcount;++i){

                //System.out.println("\ngoldpool: "+goldpool)

                def rand = -1
                if (userteam.size() >= i+1 && t2count > 0 && t1count > 0){
                    if(userteam[i].curhp >0){
                        result += userteam[i].name +"["+userteam[i].curhp+"/"+userteam[i].maxhp+ "] attaks enemy "

                        rand = random.nextInt(enemyteam.size())
                        while(enemyteam[rand].curhp <=0){
                            rand = random.nextInt(enemyteam.size())
                        }
                        result += enemyteam[rand].name +"["+enemyteam[rand].curhp+"/"+enemyteam[rand].maxhp+ "] dealing " + userteam[i].dmg() +" dmg.<br>"
                        if(enemyteam[rand].curhp < userteam[i].dmg()){
                            enemyteam[rand].curhp = 0
                        }else{
                            enemyteam[rand].curhp -= userteam[i].dmg()
                        }
                        enemyteam[rand].save(flush: true)

                        if (t2exppool > 0){
                            def expgain = 0
                            if (t2dpexp <= userteam[i].dmg()){
                                expgain = (int)(userteam[i].dmg()/t2dpexp)
                            }
                            else{
                                expgain = 1
                            }
                            
                            switch(userteam[i].wtyp.value){
                                case "Nahkampf":
                                userteam[i].nahexp += expgain
                                break
                                case "Fernkampf":
                                userteam[i].ferexp += expgain
                                break
                                case "Magie":
                                userteam[i].magexp += expgain
                                break
                            }
                            result +=  userteam[i].name +" gets "+expgain+" Exp on "+userteam[i].wtyp.value+". <br>"
                            /*
                            if(userteam[i].wtyp.value == "Nahkampf"){
                            userteam[i].nahexp += expgain
                            result +=  userteam[i].name +" gets "+expgain+" Exp on Nahkampf. <br>"
                            }else if(userteam[i].wtyp.value == "Fernkampf"){
                            userteam[i].ferexp += expgain
                            result +=  userteam[i].name +" gets "+expgain+" Exp on Fernkampf. <br>"
                            }else if(userteam[i].wtyp.value == "Magie"){
                            userteam[i].magexp += expgain
                            result +=  userteam[i].name +" gets "+expgain+" Exp on Magie. <br>"
                            }
                             */


                            if(t2exppool >= expgain){
                                t2exppool -= expgain
                            }else t2exppool = 0


                            //userteam[i].recalcUnit()
                            //userteam[i].save(flush: true)
                        }

                        if (enemyteam[rand].curhp < 1){
                            result += enemyteam[rand].name +"["+enemyteam[rand].curhp+"/"+enemyteam[rand].maxhp+ "] died.<br><br>"
                            t2count--
                            def money = enemyteam[rand].gold
                            if(money >= 4){
                                def unitmoney = (int)(money/4)
                                userteam[i].gold += unitmoney
                                money -= unitmoney

                            }
                            enemyteam[rand].gold = 0
                            goldpool += money
                        }
                        else{
                            result += "<br><br>"
                        }
                    }
                }
                if (enemyteam.size() >= i+1 && t2count > 0 && t1count > 0){
                    if(enemyteam[i].curhp >0){
                        result += "Enemy " + enemyteam[i].name +"["+enemyteam[i].curhp+"/"+enemyteam[i].maxhp+ "] attaks "
                        rand = random.nextInt(userteam.size())
                        while(userteam[rand].curhp <=0){
                            rand = random.nextInt(userteam.size())
                        }
                        result += userteam[rand].name +"["+userteam[rand].curhp+"/"+userteam[rand].maxhp+ "] dealing " + enemyteam[i].dmg() +" dmg.<br>"
                        if(userteam[rand].curhp < enemyteam[i].dmg()){
                            userteam[rand].curhp = 0
                        }else{
                            userteam[rand].curhp -= enemyteam[i].dmg()
                        }
                        //userteam[rand].save(flush: true)
                        if (t1exppool > 0){
                            def expgain = 0
                            if (t1dpexp <= enemyteam[i].dmg()){
                                expgain = (int)(enemyteam[i].dmg()/t1dpexp)
                            }
                            else{
                                expgain = 1
                            }
                            if(enemyteam[i].wtyp.value == "Nahkampf"){
                                enemyteam[i].nahexp += expgain
                                result +=  enemyteam[i].name +" gets "+expgain+" Exp on Nahkampf. <br>"
                            }else if(enemyteam[i].wtyp.value == "Fernkampf"){
                                enemyteam[i].ferexp += expgain
                                result +=  enemyteam[i].name +" gets "+expgain+" Exp on Fernkampf. <br>"
                            }else if(enemyteam[i].wtyp.value == "Magie"){
                                enemyteam[i].magexp += expgain
                                result +=  enemyteam[i].name +" gets "+expgain+" Exp on Magie. <br>"
                            }
                            if(t1exppool >= expgain){
                                t1exppool -= expgain
                            }else t1exppool = 0

                            //enemyteam[i].recalcUnit()
                            //enemyteam[i].save(flush: true)
                        }
                        if (userteam[rand].curhp < 1){
                            result += userteam[rand].name +"["+userteam[rand].curhp+"/"+userteam[rand].maxhp+ "] died.<br><br>"
                            t1count--
                            def money = userteam[rand].gold
                            if(money >= 4){
                                def unitmoney = (int)(money/4)
                                enemyteam[i].gold += unitmoney
                                money -= unitmoney

                            }
                            userteam[rand].gold = 0
                            goldpool += money




                        }
                        else{
                            result += "<br><br>"
                        }
                    }
                }
            }
        }
        if (t2count < 1){
            result += "Attacker "+ userteam[0].user.username+ " wins.<br>"

            if(goldpool > 0){
                result += userteam[0].user.username+ " gets "+goldpool+" Gold."
                userteam[0].user.gold.add(goldpool)
            }



            if(t2exppool >= t1count){
                def expgain =(int)(t2exppool/t1count)
                userteam.each{
                    if(it.curhp >0){
                        if(it.wtyp.value == "Nahkampf"){
                            it.nahexp += expgain
                        }else if(it.wtyp.value == "Fernkampf"){
                            it.ferexp += expgain
                        }else if(it.wtyp.value == "Magie"){
                            it.magexp += expgain
                        }
                        //it.recalcUnit()
                    }
                }
                result += "All alive Units from "+ userteam[0].user.username+ " get "+expgain+"Exp.<br>"

            }

        }else if(t1count < 1){
            result += "Enemy "+ enemyteam[0].user.username+ " wins."
            if(goldpool > 0){
                result += enemyteam[0].user.username+ " gets "+goldpool+" Gold."
                enemyteam[0].user.gold.add(goldpool)
            }

            if(t1exppool >= t2count){
                def expgain =(int)(t1exppool/t2count)
                enemyteam.each{
                    if(it.curhp >0){
                        if(it.wtyp.value == "Nahkampf"){
                            it.nahexp += expgain
                        }else if(it.wtyp.value == "Fernkampf"){
                            it.ferexp += expgain
                        }else if(it.wtyp.value == "Magie"){
                            it.magexp += expgain
                        }
                        //it.recalcUnit()
                    }
                }
                result += "All alive Units from "+ enemyteam[0].user.username+ " get "+expgain+"Exp"
            }
        }else{
            result += "something is wrong here: t1usercount:"+t1count+" t2enemycount:"+t2count
        }
        enemyteam.each{
            it.recalcUnit()
            it.save()
        }
        userteam.each{
            it.recalcUnit()
            it.save()
        }
        return result
    }

    @Secured(['ROLE_ADMIN'])
    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [unitInstanceList: Unit.list(params), unitInstanceTotal: Unit.count()]
    }
    @Secured(['ROLE_ADMIN'])
    def create = {
        def unitInstance = new Unit()
        unitInstance.properties = params
        return [unitInstance: unitInstance]
    }
    @Secured(['ROLE_ADMIN'])
    def save = {
        def unitInstance = new Unit(params)
        if (unitInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'unit.label', default: 'Unit'), unitInstance.id])}"
            redirect(action: "show", id: unitInstance.id)
        }
        else {
            render(view: "create", model: [unitInstance: unitInstance])
        }
    }
    @Secured(['ROLE_ADMIN'])
    def show = {
        def unitInstance = Unit.get(params.id)
        if (!unitInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'unit.label', default: 'Unit'), params.id])}"
            redirect(action: "list")
        }
        else {
            [unitInstance: unitInstance]
        }
    }
    @Secured(['ROLE_ADMIN'])
    def edit = {
        def unitInstance = Unit.get(params.id)
        if (!unitInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'unit.label', default: 'Unit'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [unitInstance: unitInstance]
        }
    }
    @Secured(['ROLE_ADMIN'])
    def update = {
        def unitInstance = Unit.get(params.id)
        if (unitInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (unitInstance.version > version) {
                    
                    unitInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'unit.label', default: 'Unit')] as Object[], "Another user has updated this Unit while you were editing")
                    render(view: "edit", model: [unitInstance: unitInstance])
                    return
                }
            }
            unitInstance.properties = params
            if (!unitInstance.hasErrors() && unitInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'unit.label', default: 'Unit'), unitInstance.id])}"
                redirect(action: "show", id: unitInstance.id)
            }
            else {
                render(view: "edit", model: [unitInstance: unitInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'unit.label', default: 'Unit'), params.id])}"
            redirect(action: "list")
        }
    }
	
    @Secured(['ROLE_ADMIN','ROLE_USER'])
    def createUnit = {
        def unitInstance = new Unit()
        unitInstance.properties = params
        return [unitInstance: unitInstance,gold:lookupUser().gold.get(), costnext:lookupUser().nextunitcost()]
    }

    def getfields(xcor,ycor,range){

        def allfields = Map.withCriteria {
            between("xaxis",xcor-range,xcor+range)
            and {
                between("yaxis", ycor-range, ycor+range)
            }
        }
        //System.out.println("nach raussuchen vor liste ausgeben")
        //allfields.each{System.out.println(it)}
        allfields.sort {it.id}
        allfields
    }

    def saveunit = {
		System.out.println("is im saveunit also kommt der error hier irgendwo :)")
		def unitInstance = new Unit(params)
        def loggeduser = lookupUser()
        //if(loggeduser.unitcount == 0)
        //überlegen wies beim usererstellen ausgelöst werden kann
        //MACHEN:^abfrage einbauen ob user ne einheit hat wenn nicht erstellen
        //mit username und main = true
        //unitInstance.str = 10;
        //unitInstance.main = false;
        //unitInstance.curhp = 100;
        //unitInstance.maxhp = 100;

        unitInstance.user = loggeduser
        unitInstance.recalcUnit()
        if (unitInstance.save(flush: true)) {
			System.out.println("blap")
            flash.message = "${message(code: 'unit.created.message', args: [message(code: 'unit.label', default: 'Unit'), unitInstance.id])}"
            redirect(action: "index")
            loggeduser.gold.sub(loggeduser.nextunitcost())
            loggeduser.unitcount ++
        }
        else {
			System.out.println("blup")
            render(view: "createUnit", model: [unitInstance: unitInstance])
        }
    }
	
	
	
    @Secured(['ROLE_ADMIN'])
    def delete = {
        def unitInstance = Unit.get(params.id)
        if (unitInstance) {
            try {
                unitInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'unit.label', default: 'Unit'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'unit.label', default: 'Unit'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'unit.label', default: 'Unit'), params.id])}"
            redirect(action: "list")
        }
    }
	

    private getShopItems(){
        def items = Item.withCriteria {
            like ('itemname', '%%')
            order "gold", "asc"
        }
        items
    }
    
    private getUserUnit(id){
        def curunit = Unit.findById(id)
        curunit   
    }
    
    private getEnemyUsers(User usr){
        def enemys = User.withCriteria {
            ne ('username', usr.username)
            gt("unitcount",0)

            //maxResults 10
            //order 'asc'
        }
        enemys
    }


    private lookupUser(){
        User.get(springSecurityService.principal.id)
    }
}
