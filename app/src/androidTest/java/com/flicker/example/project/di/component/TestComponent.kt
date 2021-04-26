package com.flicker.example.project.di.component

import com.flicker.example.project.di.module.ApplicationTestModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationTestModule::class])
interface TestComponent : ApplicationComponent {
}