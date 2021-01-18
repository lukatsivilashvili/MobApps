package com.example.threading

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.util.Log
import android.widget.Toast

class MyService : Service() {

    companion object {
        const val TAG = "MyService"
    }

    private var isServicerunning = false

    private lateinit var myServiceHandler: MyServiceHandler

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun onCreate() {
        super.onCreate()
        isServicerunning = true
        myServiceHandler = MyServiceHandler()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        myServiceHandler.handle()
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        isServicerunning = false
        Toast.makeText(this, "END!!!", Toast.LENGTH_LONG).show()
        super.onDestroy()
    }

    private inner class MyServiceHandler : Handler() {
        fun handle() {
            for (i in 1..10) {

                try {
                    Log.d(MyService.TAG, "MyService $i")
                    Thread.sleep(1000)
                } catch (e: Exception) {
                    Log.d(MyService.TAG, e.message.toString())
                }

                if(!isServicerunning) {
                    break
                }

            }
            stopSelf()
        }
    }

}