package com.example.data.source

import com.example.data.model.ProfileEntity
import com.example.data.repository.ProfileDataStore
import com.example.data.repository.ProfileRemote
import io.reactivex.Single
import javax.inject.Inject

open class ProfileRemoteDataStore @Inject constructor(private val profileRemote: ProfileRemote) : ProfileDataStore {
    override fun getProfiles(): Single<List<ProfileEntity>> {
        return profileRemote.getProfiles()
    }
}