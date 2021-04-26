package com.flicker.example.project.di.module

import androidx.lifecycle.LifecycleRegistry
import com.flicker.example.project.di.ViewModelScope
import com.flicker.example.project.ui.base.BaseItemViewHolder
import dagger.Module
import dagger.Provides

@Module
class ViewHolderModule(private val viewHolder: BaseItemViewHolder<*, *>) {

    @Provides
    @ViewModelScope
    fun provideLifecycleRegistry(): LifecycleRegistry = LifecycleRegistry(viewHolder)
}