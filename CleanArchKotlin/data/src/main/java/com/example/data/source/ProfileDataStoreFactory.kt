package com.example.data.source

import com.example.data.model.ProfileEntity
import com.example.data.repository.ProfileDataStore
import com.example.data.repository.ProfileRemote
import io.reactivex.Single
import javax.inject.Inject

open class ProfileDataStoreFactory @Inject constructor(private val profileRemoteDataStore: ProfileRemoteDataStore){
    open fun retrieveRemoteDataStore(): ProfileDataStore {
        return profileRemoteDataStore
    }

    open fun retrieveDataStore(): ProfileDataStore {
        return retrieveRemoteDataStore()
    }
}