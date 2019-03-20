package com.example.data.repository

import com.example.data.store.ProfileDataStore
import com.example.domain.model.Profile
import com.example.domain.repository.ProfileRepository
import io.reactivex.Single
import javax.inject.Inject

class ProfileDataRepository @Inject constructor(private val dataStore: ProfileDataStore) : ProfileRepository {
    override fun getProfiles(): Single<List<Profile>> {
        return dataStore.getProfiles()
    }
}