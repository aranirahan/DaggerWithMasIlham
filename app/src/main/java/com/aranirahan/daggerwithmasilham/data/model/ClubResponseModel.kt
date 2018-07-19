package com.aranirahan.daggerwithmasilham.data.model

import com.google.gson.annotations.SerializedName

data class ClubResponseModel(
        @field:SerializedName("name")
        val name: String? = "",
        @field:SerializedName("clubs")
        val clubs: List<ClubModel>? = emptyList()
)