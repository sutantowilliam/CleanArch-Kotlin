package com.example.presentation.mapper

import com.example.domain.model.Name
import com.example.presentation.model.NameView

class NameMapper : Mapper<NameView,Name>{
    override fun mapToView(type: Name): NameView {
        return NameView(type.title,type.first,type.last)
    }
}