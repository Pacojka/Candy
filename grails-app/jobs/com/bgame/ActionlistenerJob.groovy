package com.bgame


class ActionlistenerJob {
    // def timeout = 60000l // execute job once in 50 seconds
    // def repeatInterval  = 100000

    static triggers = {
        simple name: 'myActionTrigger', startDelay: 30000, repeatInterval: 1000
    }

    def execute() {
        println "checking Actions"

        long number = 0
        def actioncount = Actionstack.withCriteria {
            ge("id", number)
        }
        def izahl = 0
        actioncount.each{
            izahl++
            println"wawaw drinnenr "+izahl+"${it}"
        }
        def allActions = Actionstack.withCriteria {
            lt("endtime", new Date())
            }

            if(allActions){
            println "folgende:${izahl}"
            allActions.each{
                println it
                if (it.actiontype.getKey() == "hin"){
                    it.setToFight()
                    it.fightblog = it.fightsim()
                    it.sendMessageEnemy()
                    it.travelBack()
                    }else if(it.actiontype.getKey() == "rue"){
                        it.user.gold.add(it.goldgain.get())
                        it.units().each{it.setBack()}
                        //NACHRICHT AN USER
                        it.sendMessageUser()
                    	def disuser = it.user
                        disuser.removeFromActions(it)
			it.delete()
                        }
                
                        }

                        }else println "nix von  ${izahl}\n"
                        /*
                        def cal = Calendar.instance
                        def H = cal.get(Calendar.HOUR)
                        def M = cal.get(Calendar.MINUTE)
                        def S = cal.get(Calendar.SECOND)


                        System.out.println("HEAL ALL THE UNITS!!!!!!!! ${H}:${M}:${S}")
                        healthisunits.each{
                            it.curhp ++
                            it.calchppr()
                            }

                            */
                            }
                            }
