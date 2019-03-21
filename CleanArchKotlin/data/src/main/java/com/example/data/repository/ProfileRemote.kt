package com.example.data.repository

import com.example.data.model.ProfileEntity
import io.reactivex.Single

interface ProfileRemote {
    fun getProfiles(): Single<List<ProfileEntity>>
}