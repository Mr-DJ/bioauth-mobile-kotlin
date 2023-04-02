package com.example.biopass.data.network

import android.app.Application
import android.util.Log
import com.example.biopass.constant.Constants
import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException

class SocketInstance : Application() {
    private var mSocket: Socket? = null

    override fun onCreate() {
        super.onCreate()
        try {
            //creating socket instance
            mSocket = IO.socket(Constants.TESTSOCKET)
            Log.v("worked","did work")
        } catch (e: URISyntaxException) {
            Log.v("worked","didn't work work")
            throw RuntimeException(e)
        }
    }
}