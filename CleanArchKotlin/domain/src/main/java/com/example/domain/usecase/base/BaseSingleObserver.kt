package com.example.domain.usecase.base
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class BaseSingleObserver<T>:SingleObserver<T> {
    override fun onSuccess(t: T) {
    }

    override fun onSubscribe(d: Disposable) {
    }

    override fun onError(e: Throwable) {
    }
}