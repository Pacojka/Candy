import com.bgame.*
class BootStrap {

    def init = { servletContext ->

        /*map erzeugen*/
        //feldgrösse vielfache 25 + x * 10 {x E N} :D(hoffentlich nicht falsch :D)
        def fieldsize = 45

        def random = new Random()
        def field
        def zufall
        def fieldtop
        def fieldleft
        def zufall_feld
        def fieldtext = "penis"
        def possible_fields=["wal","geb","fel","wue"] //,"doe"
        
        for (int ycor = 0; ycor < fieldsize;++ycor){
            for (int xcor = 0; xcor < fieldsize;++xcor){
                fieldtop = Map.findByXaxisAndYaxis(xcor,ycor-1)
                fieldleft = Map.findByXaxisAndYaxis(xcor-1,ycor)
                zufall=random.nextInt(3)
                if(fieldtop && fieldleft){
                    switch(zufall){
                        case 0:
                        fieldtext=fieldleft.fieldtype.getKey()
                        break
                        case 1:
                        fieldtext=fieldtop.fieldtype.getKey()
                        break
                        default:
                        zufall_feld = random.nextInt(4)
                        fieldtext = possible_fields[zufall_feld]
                    }
                }else if(fieldtop){
                    switch(zufall){
                        case 1:
                        fieldtext=fieldtop.fieldtype.getKey()
                        break
                        default:
                        zufall_feld = random.nextInt(4)
                        fieldtext = possible_fields[zufall_feld]
                    }
                }
                else if(fieldleft){
                    switch(zufall){
                        case 0:
                        fieldtext=fieldleft.fieldtype.getKey()
                        break
                        default:
                        zufall_feld = random.nextInt(4)
                        fieldtext = possible_fields[zufall_feld]
                    }
                }else{
                    zufall_feld = random.nextInt(4)
                    fieldtext = possible_fields[zufall_feld]
                }

                field = new Map(xaxis:xcor,yaxis:ycor,fieldtype:fieldtext).save()
            }
        }
        System.out.println("nun userfelder erstellen")
        
        for (int ycor = 4; ycor < fieldsize;ycor+=9){
            for (int xcor = 4; xcor < fieldsize;xcor+=9){
                field = Map.findByXaxisAndYaxis(xcor,ycor)
                field.fieldtype = "user"
            }
        }
        System.out.println("fertig")
        

        /*
         *            System.out.println("\n\n\n nun collection machen wa\n\n\n")

        def allfields = Map.withCriteria {
        ge("x",0)
        }

        allfields.each{System.out.println(it)}
         */

        /*ROLES*/
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
        /*ITEMS*/
        def item01 = new Item(itemname: 'Stumpfer Dolch',item_type: 'nah', dmgmin: 3,dmgmax:5,defens:0,gold:5).save()
        def i1 = Item.findByItemname('Stumpfer Dolch')

        def item02 = new Item(itemname: 'Spielzeugbogen',item_type: 'fer', dmgmin: 2,dmgmax:6,defens:0,gold:5).save()
        def i2 = Item.findByItemname('Spielzeugbogen')

        def item03 = new Item(itemname: 'Damenhandtasche',item_type: 'nah', dmgmin: 2,dmgmax:2,defens:0,gold:15).save()
        def i3 = Item.findByItemname('Damenhandtasche')

        def item04 = new Item(itemname: 'Holzbein',item_type: 'nah', dmgmin: 2,dmgmax:2,defens:0,gold:1).save()
        def i4 = Item.findByItemname('Holzbein')
        
        def item05 = new Item(itemname: 'Doppelrammler',item_type: 'nah', dmgmin: 6,dmgmax:10,defens:0,gold:20).save()
        def i5 = Item.findByItemname('Doppelrammler')
        
        def item06 = new Item(itemname: 'Periode',item_type: 'nah', dmgmin: 70,dmgmax:100,defens:0,gold:999).save()
        def i6 = Item.findByItemname('Periode')

        def item07 = new Item(itemname: 'Amulett der Stärke',item_type: 'amu', dmgmin: 3,dmgmax:3,defens:0,gold:7).save()
        def item08 = new Item(itemname: 'Blechhelm',item_type: 'hlm', dmgmin: 0,dmgmax:0,defens:3,gold:4).save()
        def item09 = new Item(itemname: 'Jute Handschuh',item_type: 'hnd', dmgmin: 0,dmgmax:0,defens:2,gold:3).save()
        def item10 = new Item(itemname: 'Hölzerne Schienbeinschoner',item_type: 'bns', dmgmin: 0,dmgmax:0,defens:3,gold:5).save()
        def item11 = new Item(itemname: 'Sneakers',item_type: 'stf', dmgmin: 0,dmgmax:0,defens:2,gold:4).save()
        def item12 = new Item(itemname: 'Stoffmantel',item_type: 'rust', dmgmin: 0,dmgmax:0,defens:3,gold:4).save()
        //mustr|def item99 = new Item(itemname: 'NAME',item_type: 'nah,fer,mag oder hlm,amu,rust,hnd,bns,stf', dmgmin: 0, dmgmax:0,str: 0, ges: 0, inz: 0,defens:0,gold:999).save()
        


        
        /*ITEMS*/

        /*ADMIN*/
        def testUser = new User(username: 'me', enabled: true, password: 'p', gold:new Value()).save(flush: true)
        /*ADMIN*/

        /*USER+Items+Units*/
        /*USER*/
        def testUser2 = new User(username: 'xian', enabled: true, password: 'p', gold:new Value()).save()
        def xian = User.findByUsername('xian')
        /*Map zuweisen*/
        if(freemapfields())usertomap(xian)
        /*Items*/
        def ua11 = new com.bgame.Usritm()
        ua11.link(i1,xian).save()
        def ua12 = new com.bgame.Usritm()
        ua12.link(i3,xian).save()
        /*Units*/
        testUser2.addToUnits(new Unit(name: 'Xian', main: true, nahexp: 9000, magexp : 150,wtyp: 'nah'))
        testUser2.addToUnits(new Unit(name: 'mongo', main: false,ferexp: 6523, nahexp: 150, magexp : 150,wtyp: 'fer'))
        testUser2.unitcount = 2
        testUser2.save(flush: true)
        testUser2.units.each { it.recalcUnit() }
        /*User Role zuweisung UNTEN!*/


        /*USER+Items+Units*/
        /*USER*/
        def testUser3 = new User(username: 'paco', enabled: true, password: 'p', gold:new Value()).save()
        def paco = User.findByUsername('paco')
        /*Map zuweisen*/
        if(freemapfields())usertomap(paco)
        /*Items*/

        def ua21 = new com.bgame.Usritm()
        ua21.link(i2,paco).save()
        def ua22 = new com.bgame.Usritm()//UNITS MIT EINBEZIEHEN!!!!!
        ua22 = ua22.link(i1,paco).save()
        
        def ua23 = new com.bgame.Usritm()
        ua23 = ua23.link(i6,paco).save()
        /*Units*/
        testUser3.addToUnits(new Unit(name: 'Paco', main: true, ferexp: 12000, nahexp: 800, magexp : 150,wtyp: 'fer'))
        testUser3.addToUnits(new Unit(name: 'Cora', main: false,ferexp: 150, nahexp: 150, magexp : 13000,wtyp: 'mag'))
        testUser3.unitcount = 2
        testUser3.save(flush: true)
        def upaco = Unit.findByName('Paco')
        ua22 = ua22.linkunit(ua22.id,upaco)
        def ucora = Unit.findByName('Cora')
        ua23 = ua23.linkunit(ua23.id,ucora)
        testUser3.units.each { it.recalcUnit() }


        /*User Role zuweisung UNTEN!*/


        /*USER+Items+Units*/
        /*USER*/
        def testUser4 = new User(username: 'janis', enabled: true, password: 'p', gold:new Value()).save()
        def janis = User.findByUsername('janis')
        /*Map zuweisen*/
        if(freemapfields())usertomap(janis)
        /*Items*/
        def ua31 = new com.bgame.Usritm()
        ua31.link(i1,janis).save()
        def ua32 = new com.bgame.Usritm()
        ua32.link(i4,janis).save()
        /*Units*/
        testUser4.addToUnits(new Unit(name: 'Janis', main: true, ferexp: 750, nahexp: 9000, magexp : 150,wtyp: 'nah'))
        testUser4.addToUnits(new Unit(name: 'Jizzalot', main: false,ferexp: 8000, nahexp: 150, magexp : 150,wtyp: 'fer'))
        testUser4.unitcount = 2
        testUser4.save(flush: true)
        testUser4.units.each { it.recalcUnit() }
        /*User Role zuweisung UNTEN!*/

        /*User Role zuweisung*/
        UserRole.create testUser, adminRole, true
        UserRole.create testUser2, userRole, true
        UserRole.create testUser3, userRole, true
        UserRole.create testUser4, userRole, true

        assert User.count() == 4
        assert Role.count() == 2
        assert UserRole.count() == 4

    }

    def destroy = {
    }

    def freemapfields(){
        def result = true
        def lastfield = Map.findByXaxisAndYaxis(2,2)
        if(lastfield.user != null) result = false
        result
    }
    // def (fieldsize-1)/2
    def usertomap(user){
        def startx = 22
        def starty = 22
        def field = Map.findByXaxisAndYaxis(startx,starty)
        def done = false
        def distance = 1
        def distancecopy = distance
        def times = 2
        def richtungen = ["oben","rechts","unten","links"]
        def richtunglauf = 0
        def richtung = richtungen[richtunglauf]
        while(!done){
            if(!field.hasUser()){
                user.addToFields(field)
                done = true
            }
            if(!done){
                if(distancecopy <= 0){
                    times--
                    distancecopy = distance
                    if(richtunglauf < 3){
                        richtunglauf++
                        richtung = richtungen[richtunglauf]
                    }else{
                        richtunglauf = 0
                        richtung = richtungen[richtunglauf]
                    }
                    if(times == 0){
                        times = 2
                        distance++
                    }
                }
                distancecopy--
                switch(richtung){
                    case "oben":
                    starty -= 9
                    break
                    case "rechts":
                    startx += 9
                    break
                    case "unten":
                    starty += 9
                    break
                    case "links":
                    startx -= 9
                    break
                }
                field = Map.findByXaxisAndYaxis(startx,starty)
            }
        }
    }
    // 1Ho 1Re 2Ru 2Li 3Ho 3Re 4 Ru 4 Li bis x =
    // 5er sprünge bis x und y == 2 (oder y und x == 3 wenn index bei 1 beginnt (x-1 und y-1 beim zuweisen))
}


