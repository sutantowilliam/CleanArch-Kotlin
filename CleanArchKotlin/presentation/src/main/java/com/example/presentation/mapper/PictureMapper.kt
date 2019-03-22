package com.example.presentation.mapper

import com.example.domain.model.Picture
import com.example.presentation.model.PictureView

class PictureMapper : Mapper<PictureView, Picture>{
    override fun mapToView(type: Picture): PictureView {
        return PictureView(type.large,type.medium,type.thumbnail)
    }
}