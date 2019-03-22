package com.example.presentation.browse

import com.example.presentation.BasePresenter
import com.example.presentation.BaseView
import com.example.presentation.model.ProfileView

interface BrowseProfilesContract {
    interface View : BaseView<Presenter> {
        fun showProfiles(bufferoos: List<ProfileView>)
    }

    interface Presenter : BasePresenter {
        fun retrieveProfiles()

    }
}