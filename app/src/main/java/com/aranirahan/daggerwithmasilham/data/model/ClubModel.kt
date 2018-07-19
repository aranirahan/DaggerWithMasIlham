package com.aranirahan.daggerwithmasilham.data.model

import com.google.gson.annotations.SerializedName

data class ClubModel(
        @field:SerializedName("key")
        val key: String? = "",
        @field:SerializedName("name")
        val name: String?,
        @field:SerializedName("code")
        val code: String?)
