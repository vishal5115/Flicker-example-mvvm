package com.flicker.example.project.ui.main

import androidx.lifecycle.MutableLiveData
import com.flicker.example.project.ui.base.BaseViewModel
import com.flicker.example.project.utils.common.Event
import com.flicker.example.project.utils.network.NetworkHelper
import com.flicker.example.project.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable

class MainViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    val profileNavigation = MutableLiveData<Event<Boolean>>()
    val homeNavigation = MutableLiveData<Event<Boolean>>()
    val photoNavigation = MutableLiveData<Event<Boolean>>()

    override fun onCreate() {
        homeNavigation.postValue(Event(true))
    }

    fun onProfileSelected() {
        profileNavigation.postValue(Event(true))
    }

    fun onHomeSelected() {
        homeNavigation.postValue(Event(true))
    }

    fun onPhotoSelected() {
        photoNavigation.postValue(Event(true))
    }
}