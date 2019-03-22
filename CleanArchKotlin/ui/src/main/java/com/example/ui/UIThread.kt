package com.example.ui

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import com.example.domain.executor.PostExecutionThread
import javax.inject.Inject

/**
 * MainThread (UI Thread) implementation based on a [Scheduler]
 * which will execute actions on the Android UI thread
 */
class UIThread @Inject internal constructor() : PostExecutionThread {

    override val scheduler: Scheduler
        get() = AndroidSchedulers.mainThread()

}