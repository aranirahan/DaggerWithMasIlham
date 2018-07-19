package com.aranirahan.daggerwithmasilham.data

import com.aranirahan.daggerwithmasilham.data.model.ClubResponseModel
import com.google.gson.JsonObject
import io.reactivex.Flowable
import retrofit2.Call
import retrofit2.http.GET
import java.util.concurrent.Callable

interface ApiService {
    @GET("opendatajson/football.json/master/2017-18/es.1.clubs.json")
    fun getClubList(): Flowable<ClubResponseModel>
}