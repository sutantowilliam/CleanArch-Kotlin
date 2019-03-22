package com.example.presentation.browse

import com.example.domain.model.Profile
import com.example.domain.usecase.SingleUseCase
import com.example.presentation.mapper.ProfileMapper
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class BrowseProfilesPresenter @Inject constructor(
    private val browseView: BrowseProfilesContract.View,
    private val getProfilesUseCase: SingleUseCase<List<Profile>, Void>,
    private val profileMapper: ProfileMapper
    ) : BrowseProfilesContract.Presenter {
    init {
        browseView.setPresenter(this)
    }

    override fun retrieveProfiles() {
        getProfilesUseCase.execute(ProfileSubscriber())
    }

    override fun start() {
        retrieveProfiles()
    }

    override fun stop() {
        getProfilesUseCase.dispose()
    }

    internal fun handleGetBufferoosSuccess(profiles: List<Profile>) {
//        browseView.hideErrorState()
        if (profiles.isNotEmpty()) {
//            browseView.hideEmptyState()
            browseView.showProfiles(profiles.map { profileMapper.mapToView(it) })
        } else {
//            browseView.hideBufferoos()
//            browseView.showEmptyState()
        }
    }

    inner class ProfileSubscriber : DisposableSingleObserver<List<Profile>>() {

        override fun onSuccess(t: List<Profile>) {
            handleGetBufferoosSuccess(t)
        }

        override fun onError(exception: Throwable) {
//            browseView.hideBufferoos()
//            browseView.hideEmptyState()
//            browseView.showErrorState()
        }

    }
}