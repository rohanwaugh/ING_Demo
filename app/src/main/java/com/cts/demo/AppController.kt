package com.cts.demo

import android.app.Application

class AppController : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        instance = this
        setup()

    }

    fun setup() {
        component = DaggerAppComponent.builder().appModule( AppModule()).build()
    }

    fun getApplicationComponent(): AppComponent {
        return component
    }

    companion object {
        lateinit var instance: AppController private set
    }
}