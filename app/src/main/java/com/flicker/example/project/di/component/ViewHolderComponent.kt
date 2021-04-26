package com.flicker.example.project.di.component

import com.flicker.example.project.di.ViewModelScope
import com.flicker.example.project.di.module.ViewHolderModule
import com.flicker.example.project.ui.home.posts.PostItemViewHolder
import dagger.Component

@ViewModelScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [ViewHolderModule::class]
)
interface ViewHolderComponent {
    fun inject(viewHolder: PostItemViewHolder)
}