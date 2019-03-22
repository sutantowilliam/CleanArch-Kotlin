package com.example.presentation.mapper

import com.example.domain.model.Profile
import com.example.presentation.model.NameView
import com.example.presentation.model.ProfileView

class ProfileMapper : Mapper<ProfileView, Profile> {
    override fun mapToView(type: Profile): ProfileView {
        return ProfileView(NameMapper().mapToView(type.name),PictureMapper().mapToView(type.picture))
    }
}