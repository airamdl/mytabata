package com.example.contador


import android.os.CountDownTimer
import android.util.Log

class CounterDown(var seconds:Int, var loQueHaceAlHacerTick : (Long) -> Unit) {
    var myCounter : CountDownTimer
    var counterState : Boolean = false

    init {


        myCounter = object : CountDownTimer((seconds * 1000L), 1000) {

            override fun onTick(millisUntilFinished: Long){
                loQueHaceAlHacerTick (millisUntilFinished /1000)
                Log.i("dam", "tick $millisUntilFinished")
            }

            override fun onFinish(){
                counterState = false
            }

        }
    }
}