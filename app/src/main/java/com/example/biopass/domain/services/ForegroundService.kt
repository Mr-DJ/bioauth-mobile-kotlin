package com.example.biopass.domain.services

import android.annotation.SuppressLint
import android.app.*
import android.content.Intent
import android.os.Build
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.biopass.MainActivity
import com.example.biopass.R
import com.example.biopass.data.network.SocketHandler
import kotlinx.coroutines.*

const val INTENT_COMMAND = "Command"
const val INTENT_COMMAND_CANCEL = "Cancel Notification"

class ForegroundService : Service() {

    private var job: Job? = null
    private var socket = SocketHandler.mSocket
    private lateinit var handler: Handler
    private lateinit var notificationManager: NotificationManagerCompat
    private lateinit var notificationBuilder: NotificationCompat.Builder

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createNotificationChannel()
        startForegroundService()
        handler = Handler(Looper.getMainLooper())
        notificationManager = NotificationManagerCompat.from(this)
        notificationBuilder = createNotification("My Foreground Service", "Service is running")
        notificationManager.notify(1, notificationBuilder.build())

        val command = intent?.getStringExtra(INTENT_COMMAND)
        if (command == INTENT_COMMAND_CANCEL) {
            // cancel the notification
            notificationManager.cancel(1)
            stopService()
            return START_NOT_STICKY
        }
        return START_STICKY
    }

    private fun stopService(){
        stopSelf()
    }

    override fun onBind(p0: Intent?): IBinder? {
        return null
    }

    private fun startForegroundService(){
        startForeground(1,createNotification("Athentication required","Google").build())
        job = CoroutineScope(Dispatchers.IO).launch {
            try {
                socket.on(""){args->
                    if (args[0]!=null){
                        handler.post{

                        }
                    }

                }
            }catch (e:Exception){
                Log.e("job broke","Error: ${e.message}")
            }
        }
    }

    @SuppressLint("UnspecifiedImmutableFlag")
    private fun createNotification(title:String, text:String):NotificationCompat.Builder{
        val resultIntent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            action = "my_action"
            putExtra(INTENT_COMMAND,INTENT_COMMAND_CANCEL)
        }
        val pendingIntent = PendingIntent.getActivity(this,1,resultIntent,0)

        val notification = NotificationCompat.Builder(this, "my_service_channel")
            .setContentTitle(title)
            .setContentText(text)
            .setSmallIcon(R.drawable.baseline_notifications_24)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setOngoing(false)

        return notification
    }


    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "my_service_channel",
                "My Foreground Service",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        notificationManager.cancel(1)
        job?.cancel()

    }
}