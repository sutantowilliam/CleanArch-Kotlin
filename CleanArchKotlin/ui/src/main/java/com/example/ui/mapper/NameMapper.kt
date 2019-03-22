package com.example.ui.mapper

import com.example.ui.model.NameViewModel
import com.example.presentation.model.NameView

class NameMapper : Mapper<NameViewModel, NameView> {
    override fun mapToViewModel(type: NameView): NameViewModel {
        return NameViewModel(type.title, type.first, type.last)
    }
}