package com.example.remote.mapper

import com.example.data.model.PictureEntity
import com.example.remote.model.PictureRemoteModel

class PictureEntityMapper: EntityMapper<PictureRemoteModel, PictureEntity> {
    override fun mapFromRemote(type: PictureRemoteModel): PictureEntity {
        return PictureEntity(type.large,type.medium,type.thumbnail)
    }
}