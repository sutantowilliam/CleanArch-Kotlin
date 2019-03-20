package com.example.presentation.presenter

import com.example.domain.model.Profile
import com.example.domain.usecase.GetProfiles
import com.example.presentation.contract.ProfileContract
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class ProfilePresenter @Inject constructor(val profileView: ProfileContract.View, private val getProfileUseCase: GetProfiles) :
    ProfileContract.Presenter {
    init {
        profileView.setPresenter(this)
    }

    override fun start() {
        getProfiles()
    }

    override fun stop() {
        getProfileUseCase.dispose()
    }

    override fun getProfiles() {
        getProfileUseCase.execute(GetProfileSubscriber())
    }

    inner class GetProfileSubscriber : DisposableSingleObserver<List<Profile>>() {

        override fun onSuccess(it: List<Profile>) {
            profileView.showProfiles(it)
        }

        override fun onError(exception: Throwable) {
        }
    }
}