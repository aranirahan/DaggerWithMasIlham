package com.aranirahan.daggerwithmasilham.main

import android.util.Log
import com.aranirahan.daggerwithmasilham.data.ApiService
import com.aranirahan.daggerwithmasilham.data.model.repository.MainRepo
import com.aranirahan.daggerwithmasilham.di.ActivityScope
import com.google.gson.Gson
import com.google.gson.JsonObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import javax.inject.Inject
import retrofit2.Callback
import retrofit2.Response

//@ActivityScope
//class MainPresenter @Inject constructor(val api: ApiService) {
//    fun getClubList() {
//        Log.d("MainPresenter", "MainPresenter : getCLubList")
//        api.getClubList().enqueue(object : Callback<JsonObject> {
//            override fun onFailure(call: Call<JsonObject>?, t: Throwable?) {
//                Log.e("MainPresenter", t?.message)
//            }
//
//            override fun onResponse(call: Call<JsonObject>?, response: Response<JsonObject>?) {
//                Log.d("MainPresenter", "response : ${Gson().toJsonTree(response)}")
//            }
//        })
//    }
//}

@ActivityScope
class MainPresenter @Inject constructor(val repo: MainRepo) {
    private val TAG = "MainPresenter"
    fun getClubList() {
        Log.d("MainPresenter", "MainPresenter : getCLubList")
        repo.getClubList()
                .subscribeOn(Schedulers.io()) //load data
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    //jika sukses
                    Log.d(TAG, "Club List : ${Gson().toJsonTree(it)}")
                }, {
                    //jika gagal
                    Log.e(TAG, "Error : ${it.message}")
                })
    }
}