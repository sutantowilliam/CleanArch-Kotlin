package com.example.domain.usecase

import com.example.domain.executor.PostExecutionThread
import com.example.domain.executor.ThreadExecutor
import com.example.domain.model.Profile
import com.example.domain.repository.ProfileRepository
import com.example.domain.usecase.base.SingleUseCase
import io.reactivex.Single
import javax.inject.Inject

open class GetProfiles @Inject constructor(
    private val profileRepository: ProfileRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
): SingleUseCase<List<Profile>, Void?>(threadExecutor, postExecutionThread){
    public override fun buildUseCaseObservable(params: Void?): Single<List<Profile>> {
        return profileRepository.getProfiles()
    }
}