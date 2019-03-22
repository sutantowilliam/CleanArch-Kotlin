package com.example.data

import com.example.data.mapper.ProfileMapper
import com.example.data.source.ProfileDataStoreFactory
import com.example.data.source.ProfileRemoteDataStore
import com.example.domain.model.Profile
import com.example.domain.repository.ProfileRepository
import io.reactivex.Single
import javax.inject.Inject

class ProfileDataRepository @Inject constructor(
    private val factory: ProfileDataStoreFactory,
    private val profileMapper: ProfileMapper
) : ProfileRepository {
    override fun getProfiles(): Single<List<Profile>> {
        val dataStore = factory.retrieveDataStore()
        return dataStore.getProfiles().flatMap {
            Single.just(it)
        }.map { list ->
            list.map { listItem ->
                profileMapper.mapFromEntity(listItem)
            }
        }
    }
}