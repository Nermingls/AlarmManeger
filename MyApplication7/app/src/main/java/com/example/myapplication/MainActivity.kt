package com.example.myapplication

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun btnAlarmKur(view : View){
        val calendar = Calendar.getInstance()

        var tpDialog = TimePickerDialog(this,onTimeSetListener,calendar[Calendar.HOUR_OF_DAY],
            calendar[Calendar.MINUTE],true)
        tpDialog.setTitle("Zaman Seçiniz")

        tpDialog.show()
    }

    var onTimeSetListener = TimePickerDialog.OnTimeSetListener{
        view,hour,minute ->
        val choseenCalendar =Calendar.getInstance()
        choseenCalendar[Calendar.HOUR_OF_DAY] = hour
        choseenCalendar[Calendar.MINUTE] = minute

        val intent = Intent(this,AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this,1,intent,PendingIntent.FLAG_IMMUTABLE )
        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager[AlarmManager.RTC_WAKEUP,choseenCalendar.timeInMillis] = pendingIntent
    }
}
