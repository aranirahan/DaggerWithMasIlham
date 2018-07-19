package com.aranirahan.daggerwithmasilham.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.aranirahan.daggerwithmasilham.AppClass
import com.aranirahan.daggerwithmasilham.R
import com.aranirahan.daggerwithmasilham.di.ActivityScope
import com.aranirahan.daggerwithmasilham.di.component.ActivityComponent
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@ActivityScope
class MainActivity : AppCompatActivity(), MainView {

    private val TAG = "MainActivity"

    @Inject
    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.injectActivity()
        presenter.bind(this)// inject dari main view
        this.initView()
    }

    private fun initView() {
        btnLoadApi.setOnClickListener {
            presenter.getClubList()
        }
    }

    private fun injectActivity() {
        val injector: ActivityComponent = (applicationContext as AppClass).appComponent
                .buildActivityComponent()
                .build()
        injector.inject(this)
    }

    override fun showClubList(clubList: List<Club>?) {
        Log.d(TAG, "Clublist : ${Gson().toJsonTree(clubList)}")
    }
}
