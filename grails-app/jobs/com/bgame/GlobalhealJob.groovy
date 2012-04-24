package com.bgame

class GlobalhealJob {
    // def timeout = 60000l // execute job once in 50 seconds
    // def repeatInterval  = 100000

    static triggers = {
        simple name: 'mySimpleTrigger', startDelay: 30000, repeatInterval: 10000
    }

    def execute() {
		/*
        def healthisunits = Unit.withCriteria {
            lt("curhppr", 100)
            and{
                gt("curhp",0)
            }
            
        }
*/
       def cal = Calendar.instance
       def H = cal.get(Calendar.HOUR)
       def M = cal.get(Calendar.MINUTE)
       def S = cal.get(Calendar.SECOND)

        
        //System.out.println("HEAL ALL THE UNITS!!!!!!!! ${H}:${M}:${S}")
       /* 
	   healthisunits.each{
            it.curhp ++
            it.calchppr()
        }
        */
    }
}
