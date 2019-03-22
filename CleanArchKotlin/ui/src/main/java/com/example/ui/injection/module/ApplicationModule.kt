package com.example.ui.injection.module

import android.app.Application
import android.content.Context
import com.example.data.ProfileDataRepository
import com.example.data.executor.JobExecutor
import com.example.domain.executor.PostExecutionThread
import com.example.domain.executor.ThreadExecutor
import com.example.domain.repository.ProfileRepository
import com.example.data.mapper.ProfileMapper
import com.example.data.repository.ProfileRemote
import com.example.data.source.ProfileDataStoreFactory
import com.example.remote.ProfileRemoteImpl
import com.example.remote.ProfileService
import com.example.remote.mapper.ProfileEntityMapper
import com.example.remote.ProfileServiceFactory
import com.example.ui.BuildConfig
import com.example.ui.UIThread
import com.example.ui.injection.scopes.PerApplication
import dagger.Module
import dagger.Provides

/**
 * Module used to provide dependencies at an application-level.
 */
@Module
open class ApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }

//    @Provides
//    @PerApplication
//    internal fun providePreferencesHelper(context: Context): PreferencesHelper {
//        return PreferencesHelper(context)
//    }


    @Provides
    @PerApplication
    internal fun provideProfileRepository(factory: ProfileDataStoreFactory,
                                          mapper: ProfileMapper
    ): ProfileRepository {
        return ProfileDataRepository(factory, mapper)
    }

//    @Provides
//    @PerApplication
//    internal fun provideProfileCache(factory: DbOpenHelper,
//                                      entityMapper: ProfileEntityMapper,
//                                      mapper: org.buffer.android.boilerplate.cache.db.mapper.ProfileMapper,
//                                      helper: PreferencesHelper): ProfileCache {
//        return ProfileCacheImpl(factory, entityMapper, mapper, helper)
//    }

    @Provides
    @PerApplication
    internal fun provideProfileRemote(service: ProfileService,
                                      factory: ProfileEntityMapper
    ): ProfileRemote {
        return ProfileRemoteImpl(service, factory)
    }

    @Provides
    @PerApplication
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @PerApplication
    internal fun providePostExecutionThread(uiThread: UIThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @PerApplication
    internal fun provideProfileService(): ProfileService {
        return ProfileServiceFactory.makeProfileService(BuildConfig.DEBUG)
    }
}
