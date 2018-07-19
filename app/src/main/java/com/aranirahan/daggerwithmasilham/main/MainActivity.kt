package com.aranirahan.daggerwithmasilham.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.aranirahan.daggerwithmasilham.AppClass
import com.aranirahan.daggerwithmasilham.R
import com.aranirahan.daggerwithmasilham.di.ActivityScope
import com.aranirahan.daggerwithmasilham.di.component.ActivityComponent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@ActivityScope
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.injectActivity()
        this.initView()
    }
    private fun initView(){
        btnLoadApi.setOnClickListener{
            presenter.getClubList()
        }
    }

    private fun injectActivity() {
        val injector: ActivityComponent = (applicationContext as AppClass).appComponent
                .buildActivityComponent()
                .build()
        injector.inject(this)
    }
}
