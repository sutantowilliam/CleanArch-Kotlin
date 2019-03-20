package com.example.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class NameRemoteModel(@SerializedName("title") @Expose val title: String, @SerializedName("first") @Expose val first: String, @SerializedName("last") @Expose val last:String)