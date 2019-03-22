package com.example.ui.mapper

import com.example.presentation.model.ProfileView
import com.example.ui.model.ProfileViewModel

class ProfileMapper : Mapper<ProfileViewModel, ProfileView>{
    override fun mapToViewModel(type: ProfileView): ProfileViewModel {
        return ProfileViewModel(NameMapper().mapToViewModel(type.name), PictureMapper().mapToViewModel(type.picture))
    }
}