import com.bgame.*
class BootStrap {

    def init = { servletContext ->
        /*ROLES*/
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)
        /*ITEMS*/
        def item1 = new Item(itemname: 'Stumpfer Dolch',item_type: 'nah', dmgmin: 3,dmgmax:5,defens:0,gold:5).save()
        def i1 = Item.findByItemname('Stumpfer Dolch')

        def item2 = new Item(itemname: 'Spielzeugbogen',item_type: 'fer', dmgmin: 2,dmgmax:6,defens:0,gold:5).save()
        def i2 = Item.findByItemname('Spielzeugbogen')

        def item3 = new Item(itemname: 'Damenhandtasche',item_type: 'nah', dmgmin: 2,dmgmax:2,defens:0,gold:15).save()
        def i3 = Item.findByItemname('Damenhandtasche')

        def item4 = new Item(itemname: 'Holzbein',item_type: 'nah', dmgmin: 2,dmgmax:2,defens:0,gold:1).save()
        def i4 = Item.findByItemname('Holzbein')
        
        def item5 = new Item(itemname: 'Doppelrammler',item_type: 'nah', dmgmin: 6,dmgmax:10,defens:0,gold:20).save()
        def i5 = Item.findByItemname('Doppelrammler')
        
        def item6 = new Item(itemname: 'Periode',item_type: 'nah', dmgmin: 70,dmgmax:100,defens:0,gold:999).save()
        def i6 = Item.findByItemname('Periode')

        def item7 = new Item(itemname: 'Amulett der Stärke',item_type: 'amu', dmgmin: 3,dmgmax:3,defens:0,gold:7).save()
        def i7 = Item.findByItemname('Amulett der Stärke')

        def item8 = new Item(itemname: 'Blechhelm',item_type: 'hlm', dmgmin: 0,dmgmax:0,defens:3,gold:4).save()
        def i8 = Item.findByItemname('Blechhelm')

        def item9 = new Item(itemname: 'Jute Handschuh',item_type: 'hnd', dmgmin: 0,dmgmax:0,defens:2,gold:3).save()
        def i9 = Item.findByItemname('Jute Handschuh')

        def item10 = new Item(itemname: 'Hölzerne Schienbeinschoner',item_type: 'bns', dmgmin: 0,dmgmax:0,defens:3,gold:5).save()
        def i10 = Item.findByItemname('Hölzerne Schienbeinschoner')

        def item11 = new Item(itemname: 'Sneakers',item_type: 'stf', dmgmin: 0,dmgmax:0,defens:2,gold:4).save()
        def i11 = Item.findByItemname('Sneakers')

        def item12 = new Item(itemname: 'Stoffmantel',item_type: 'stf', dmgmin: 0,dmgmax:0,defens:2,gold:4).save()
        def i12 = Item.findByItemname('Stoffmantel')

        /*ITEMS*/

        /*ADMIN*/
        def testUser = new User(username: 'me', enabled: true, password: 'p')
        testUser.save(flush: true)
        /*ADMIN*/

        /*USER+Items+Units*/
        /*USER*/
        def testUser2 = new User(username: 'xian', enabled: true, password: 'p').save()
        def xian = User.findByUsername('xian')
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
        def testUser3 = new User(username: 'paco', enabled: true, password: 'p').save()
        def paco = User.findByUsername('paco')
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
        def testUser4 = new User(username: 'janis', enabled: true, password: 'p').save()
        def janis = User.findByUsername('janis')
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

}

