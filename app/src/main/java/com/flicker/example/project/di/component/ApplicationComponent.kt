package com.flicker.example.project.di.component

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.flicker.example.project.FlickerApplication
import com.flicker.example.project.data.local.db.DatabaseService
import com.flicker.example.project.data.remote.NetworkService
import com.flicker.example.project.di.ApplicationContext
import com.flicker.example.project.di.module.ApplicationModule
import com.flicker.example.project.utils.network.NetworkHelper
import com.flicker.example.project.utils.rx.SchedulerProvider
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton


@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(app: FlickerApplication)

    fun getApplication(): Application

    @ApplicationContext
    fun getContext(): Context

    fun getNetworkService(): NetworkService

    fun getDatabaseService(): DatabaseService

    fun getSharedPreferences(): SharedPreferences

    fun getNetworkHelper(): NetworkHelper

    fun getSchedulerProvider(): SchedulerProvider

    fun getCompositeDisposable(): CompositeDisposable
}