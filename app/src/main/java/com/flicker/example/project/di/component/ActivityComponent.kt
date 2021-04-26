package com.flicker.example.project.di.component

import com.flicker.example.project.di.ActivityScope
import com.flicker.example.project.di.module.ActivityModule
import com.flicker.example.project.ui.main.MainActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ActivityModule::class]
)
interface ActivityComponent {

    fun inject(activity: MainActivity)
}