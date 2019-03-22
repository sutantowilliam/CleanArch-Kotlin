package com.example.ui.injection.component

import com.example.ui.browse.BrowseActivity
import dagger.Subcomponent
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector

@Subcomponent
interface BrowseActivitySubComponent : AndroidInjector<BrowseActivity> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<BrowseActivity>()
}