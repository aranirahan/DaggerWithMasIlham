package com.aranirahan.daggerwithmasilham

import android.app.Application
import com.aranirahan.daggerwithmasilham.di.component.AppComponent
import com.aranirahan.daggerwithmasilham.di.component.DaggerAppComponent
import com.aranirahan.daggerwithmasilham.di.module.AppModule

class AppClass : Application() {

    val appComponent: AppComponent by lazy {
        //by lezy adalah
        DaggerAppComponent.builder().appModule(AppModule()).build()
        //sebenarnya tidak deprecated
    }
    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}