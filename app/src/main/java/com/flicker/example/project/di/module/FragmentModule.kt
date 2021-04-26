package com.flicker.example.project.di.module

import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.flicker.example.project.data.repository.PostRepository
import com.flicker.example.project.ui.base.BaseFragment
import com.flicker.example.project.ui.home.HomeViewModel
import com.flicker.example.project.ui.home.posts.PostsAdapter

import com.flicker.example.project.utils.ViewModelProviderFactory
import com.flicker.example.project.utils.network.NetworkHelper
import com.flicker.example.project.utils.rx.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.processors.PublishProcessor

@Module
class FragmentModule(private val fragment: BaseFragment<*>) {

    @Provides
    fun provideLinearLayoutManager(): LinearLayoutManager = LinearLayoutManager(fragment.context)

    @Provides
    fun providePostsAdapter() = PostsAdapter(fragment.lifecycle, ArrayList())

    @Provides
    fun provideHomeViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        postRepository: PostRepository
    ): HomeViewModel = ViewModelProviders.of(
        fragment, ViewModelProviderFactory(HomeViewModel::class) {
            HomeViewModel(
                schedulerProvider, compositeDisposable, networkHelper,
                postRepository, ArrayList(), PublishProcessor.create()
            )
        }).get(HomeViewModel::class.java)
}