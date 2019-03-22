package com.example.ui.injection.module

import com.example.domain.usecase.browse.GetProfiles
import com.example.presentation.browse.BrowseProfilesContract
import com.example.presentation.browse.BrowseProfilesPresenter
import com.example.ui.browse.BrowseActivity
import com.example.ui.injection.scopes.PerActivity
import com.example.presentation.mapper.ProfileMapper
import dagger.Module
import dagger.Provides

/**
 * Module used to provide dependencies at an activity-level.
 */
@Module
open class BrowseActivityModule {

    @PerActivity
    @Provides
    internal fun provideBrowseView(browseActivity: BrowseActivity): BrowseProfilesContract.View {
        return browseActivity
    }

    @PerActivity
    @Provides
    internal fun provideBrowsePresenter(mainView: BrowseProfilesContract.View,
                                        getProfiles: GetProfiles, mapper: ProfileMapper
    ):
            BrowseProfilesContract.Presenter {
        return BrowseProfilesPresenter(mainView, getProfiles, mapper)
    }

}