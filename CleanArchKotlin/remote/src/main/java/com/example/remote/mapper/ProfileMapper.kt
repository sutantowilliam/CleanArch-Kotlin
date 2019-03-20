package com.example.remote.mapper


import com.example.domain.model.Name
import com.example.domain.model.Picture
import com.example.domain.model.Profile
import com.example.remote.model.NameRemoteModel
import com.example.remote.model.PictureRemoteModel
import com.example.remote.model.ProfileRemoteModel

object ProfileMapper : Mapper<ProfileRemoteModel, Profile> {
    override fun mapFromCacheModel(type: ProfileRemoteModel): Profile {
        return Profile(
            Name(type.name.title, type.name.first, type.name.last),
            Picture(type.picture.large, type.picture.medium, type.picture.thumbnail)
        )
    }

    override fun mapToCacheModel(type: Profile): ProfileRemoteModel {
        return ProfileRemoteModel(
            NameRemoteModel(type.name.title, type.name.first, type.name.last),
            PictureRemoteModel(type.picture.large, type.picture.medium, type.picture.thumbnail)
        )
    }

    override fun mapFromCacheModel(items: List<ProfileRemoteModel>): List<Profile> {
        val list = mutableListOf<Profile>()
        for (item: ProfileRemoteModel in items) {
            list.add(
                Profile(
                    Name(item.name.title, item.name.first, item.name.last),
                    Picture(item.picture.large, item.picture.medium, item.picture.thumbnail)
                )
            )
        }
        return list
    }

    override fun mapToCacheModel(items: List<Profile>): List<ProfileRemoteModel> {
        val list = mutableListOf<ProfileRemoteModel>()
        for (item: Profile in items) {
            list.add(
                ProfileRemoteModel(
                    NameRemoteModel(item.name.title, item.name.first, item.name.last),
                    PictureRemoteModel(item.picture.large, item.picture.medium, item.picture.thumbnail)
                )
            )
        }
        return list
    }
}