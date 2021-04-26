package com.flicker.example.project.ui.photo

import com.flicker.example.project.ui.base.BaseViewModel
import com.flicker.example.project.utils.network.NetworkHelper
import com.flicker.example.project.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class PhotoViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {


    override fun onCreate() {

    }
}