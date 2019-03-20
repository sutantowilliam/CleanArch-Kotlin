package com.example.remote.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PictureRemoteModel (@SerializedName("large") @Expose val large:String, @SerializedName("medium") @Expose val medium:String, @SerializedName("thumbnail") @Expose val thumbnail:String)