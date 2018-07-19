package com.aranirahan.daggerwithmasilham.data.model.repository

import com.aranirahan.daggerwithmasilham.data.ApiService
import com.aranirahan.daggerwithmasilham.main.Club
import io.reactivex.Flowable
import javax.inject.Inject

class MainRepo @Inject constructor(val api: ApiService) {

    fun getClubList(): Flowable<List<Club>> {
        return api.getClubList()
                //mentransfrom dari ClubModel ke Club
                .flatMap {
                    Flowable.fromIterable(it.clubs)  //transform satu persatu data secara berulang2 hingga data habis
                }
                .map {
                    Club(name = it.name, code = it.code)
                }//masih Club biasa bukan listClub
                .toList()
                //masih singli list
                .toFlowable() //sudah menjadi list
    }
}