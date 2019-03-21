package com.example.remote.mapper


import com.example.data.model.ProfileEntity
import com.example.domain.model.Name
import com.example.domain.model.Picture
import com.example.domain.model.Profile
import com.example.remote.model.NameRemoteModel
import com.example.remote.model.PictureRemoteModel
import com.example.remote.model.ProfileRemoteModel

open class ProfileEntityMapper : EntityMapper<ProfileRemoteModel, ProfileEntity> {
    override fun mapFromRemote(type: ProfileRemoteModel): ProfileEntity {
        val nameEntity = NameEntityMapper().mapFromRemote(type.name)
        val pictureEntity = PictureEntityMapper().mapFromRemote(type.picture)
        return ProfileEntity(nameEntity,pictureEntity)
    }
}