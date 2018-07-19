package com.aranirahan.daggerwithmasilham.di.component

import com.aranirahan.daggerwithmasilham.AppClass
import com.aranirahan.daggerwithmasilham.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    fun buildActivityComponent(): ActivityComponent.Builder
    fun inject(appClass: AppClass)
}