package com.example.data.mapper

import com.example.data.model.NameEntity
import com.example.data.model.ProfileEntity
import com.example.domain.model.Profile
import javax.inject.Inject

open class ProfileMapper @Inject constructor() : Mapper<ProfileEntity, Profile> {
    override fun mapFromEntity(type: ProfileEntity): Profile {
        val name = NameMapper().mapFromEntity(type.name)
        val picture = PictureMapper().mapFromEntity(type.picture)
        return Profile(name,picture)
    }

    override fun mapToEntity(type: Profile): ProfileEntity {
        val nameEntity = NameMapper().mapToEntity(type.name)
        val pictureEntity = PictureMapper().mapToEntity(type.picture)
        return ProfileEntity(nameEntity,pictureEntity)
    }
}