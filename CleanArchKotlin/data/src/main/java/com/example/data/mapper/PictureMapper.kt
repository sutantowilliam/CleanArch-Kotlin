package com.example.data.mapper

import com.example.data.model.PictureEntity
import com.example.domain.model.Picture
import javax.inject.Inject

class PictureMapper @Inject constructor () : Mapper <PictureEntity, Picture> {
    override fun mapFromEntity(type: PictureEntity): Picture {
        return Picture(type.large,type.medium,type.thumbnail)
    }

    override fun mapToEntity(type: Picture): PictureEntity {
        return PictureEntity(type.large,type.medium,type.thumbnail)
    }
}