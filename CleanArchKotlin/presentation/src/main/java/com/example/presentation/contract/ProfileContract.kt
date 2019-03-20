package com.example.presentation.contract

import com.example.domain.model.Profile
import com.example.presentation.base.BasePresenter
import com.example.presentation.base.BaseView

interface ProfileContract {
    interface View : BaseView<ProfileContract.Presenter> {
        fun showProfiles(profiles: List<Profile>)
    }

    interface Presenter : BasePresenter {
        fun getProfiles()
    }
}