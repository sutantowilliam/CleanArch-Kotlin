package com.example.remote.mapper

import com.example.data.model.NameEntity
import com.example.data.model.PictureEntity
import com.example.remote.model.NameRemoteModel
import com.example.remote.model.PictureRemoteModel

class NameEntityMapper: EntityMapper<NameRemoteModel,NameEntity> {
    override fun mapFromRemote(type: NameRemoteModel): NameEntity {
        return NameEntity(type.title,type.first,type.last)
    }
}