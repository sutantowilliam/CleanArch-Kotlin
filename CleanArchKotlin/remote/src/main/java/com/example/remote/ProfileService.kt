package com.example.remote

import com.example.remote.model.ProfileRemoteModel
import io.reactivex.Single
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProfileService {
    @GET("api")
    fun getProfiles(@Query("results") size: Int): Single<ProfileResponse>

    class ProfileResponse {
        lateinit var profiles: List<ProfileRemoteModel>
    }
}