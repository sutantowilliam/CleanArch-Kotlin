package com.example.remote

import com.example.data.model.ProfileEntity
import com.example.data.repository.ProfileRemote
import com.example.remote.mapper.ProfileEntityMapper
import io.reactivex.Single
import javax.inject.Inject

class ProfileRemoteImpl @Inject constructor(
    private val profileService: ProfileService,
    private val entityMapper: ProfileEntityMapper
) : ProfileRemote {
    override fun getProfiles(): Single<List<ProfileEntity>> {
        return profileService.getProfiles(10).map {
            it.profiles.map { listItem ->
                entityMapper.mapFromRemote(listItem)
            }
        }
    }
}