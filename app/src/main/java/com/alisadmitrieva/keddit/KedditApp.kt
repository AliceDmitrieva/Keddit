package com.alisadmitrieva.keddit

import android.app.Application

class KedditApp : Application() {

    companion object {
        lateinit var newsComponent: NewsComponent
    }

    override fun onCreate() {
        super.onCreate()
        newsComponent = DaggerNewsComponent.builder()
            .appModule(AppModule(this))
            //.newsModule(NewsModule()) Module with empty constructor is implicitly created by dagger.
            .build()
    }
}