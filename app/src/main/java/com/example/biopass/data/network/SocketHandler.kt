package com.example.biopass.data.network

import android.util.Log
import com.example.biopass.constant.Constants
import io.socket.client.IO
import io.socket.client.Socket
import java.net.URISyntaxException

object SocketHandler {
    lateinit var mSocket: Socket

    @Synchronized
    fun setSocket() {
        try {
            mSocket = IO.socket(Constants.SAMHOUSETESTURL)
            Log.v("working","It's working")
        } catch (e: URISyntaxException) {
            Log.v("working","It's not working")
        }
    }

    @Synchronized
    fun getSocket(): Socket {
        return mSocket
    }

    @Synchronized
    fun establishConnection() {
        mSocket.connect()
    }

    @Synchronized
    fun closeConnection() {
        mSocket.disconnect()
    }
}