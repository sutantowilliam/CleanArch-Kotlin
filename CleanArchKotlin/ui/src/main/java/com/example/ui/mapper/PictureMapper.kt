package com.example.ui.mapper

import android.graphics.Picture
import com.example.presentation.model.PictureView
import com.example.ui.model.PictureViewModel

class PictureMapper :Mapper<PictureViewModel,PictureView>{
    override fun mapToViewModel(type: PictureView): PictureViewModel {
        return PictureViewModel(type.large, type.medium, type.thumbnail)
    }
}