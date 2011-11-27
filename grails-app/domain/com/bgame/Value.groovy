package com.bgame

class Value {
    int val = 50

    def get(){
        this.val
    }
    def add(davalue){
        this.val += davalue
    }

    def sub(davalue){
        this.val -= davalue
    }

    def hasleft(davalue){
        def ret
        if (this.val >= davalue) ret = true
        else ret = false
        ret
    }

     String toString(){
        this.val
    }
}
