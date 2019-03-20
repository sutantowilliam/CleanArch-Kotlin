package com.example.domain.repository

import io.reactivex.Single
import com.example.domain.model.Profile

interface ProfileRepository {
    fun getProfiles() : Single<List<Profile>>
}