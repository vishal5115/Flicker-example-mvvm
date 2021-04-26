package com.flicker.example.project.di.component

import com.flicker.example.project.di.FragmentScope
import com.flicker.example.project.di.module.FragmentModule
import com.flicker.example.project.ui.home.HomeFragment
import dagger.Component

@FragmentScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {

    fun inject(fragment: HomeFragment)
}