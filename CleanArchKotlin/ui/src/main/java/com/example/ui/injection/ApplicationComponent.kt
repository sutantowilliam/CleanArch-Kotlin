package com.example.ui.injection

import android.app.Application
import com.example.ui.RandomProfilesApplication
import com.example.ui.injection.module.ActivityBindingModule
import com.example.ui.injection.module.ApplicationModule
import com.example.ui.injection.scopes.PerApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule

@PerApplication
@Component(
    modules = arrayOf(
        ActivityBindingModule::class,
        ApplicationModule::class,
        AndroidSupportInjectionModule::class
    )
)
interface ApplicationComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: RandomProfilesApplication)
}