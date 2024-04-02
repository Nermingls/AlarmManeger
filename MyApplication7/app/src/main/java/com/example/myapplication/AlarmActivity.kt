package com.example.myapplication

import android.media.Ringtone
import android.media.RingtoneManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AlarmActivity : AppCompatActivity() {

    lateinit var ringtone: Ringtone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)

        var alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM)

        if (alarmUri == null){
            alarmUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        }

        ringtone = RingtoneManager.getRingtone(this,alarmUri)
        ringtone.play()
    }


    fun btnKapat(){
        if (ringtone.isPlaying)
            ringtone.stop()
    }
}
