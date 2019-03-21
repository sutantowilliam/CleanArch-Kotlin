package com.example.data.mapper

import com.example.data.model.NameEntity
import com.example.domain.model.Name
import javax.inject.Inject

class NameMapper @Inject constructor () : Mapper <NameEntity, Name> {
    override fun mapFromEntity(type: NameEntity): Name {
        return Name(type.title,type.first,type.last)
    }

    override fun mapToEntity(type: Name): NameEntity {
        return NameEntity(type.title,type.first,type.last)
    }
}