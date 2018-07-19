package com.aranirahan.daggerwithmasilham.utils

import com.google.gson.Gson
import com.google.gson.JsonElement

fun Any.toJson(): JsonElement{
    return Gson().toJsonTree(this)
}