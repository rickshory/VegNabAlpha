package com.rickshory.vegnabalpha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ProcessLifecycleOwner
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // experiment with 'launch'
        GlobalScope.launch { // no stated dispatcher
            Log.i(TAG,"no dispatcher given   : I'm working in thread ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.Main) { // context of the parent, main runBlocking coroutine
            Log.i(TAG,"main runBlocking      : I'm working in thread ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.Unconfined) { // not confined -- will work with main thread
            Log.i(TAG,"Unconfined            : I'm working in thread ${Thread.currentThread().name}")
        }
        GlobalScope.launch(Dispatchers.Default) { // will get dispatched to DefaultDispatcher
            Log.i(TAG,"Default               : I'm working in thread ${Thread.currentThread().name}")
        }
        GlobalScope.launch(newSingleThreadContext("MyOwnThread")) { // will get its own new thread
            Log.i(TAG,"newSingleThreadContext: I'm working in thread ${Thread.currentThread().name}")
        }
    }

}
