package com.flicker.example.project.ui.home

import androidx.lifecycle.MutableLiveData
import com.flicker.example.project.data.model.Post
import com.flicker.example.project.data.repository.PostRepository
import com.flicker.example.project.ui.base.BaseViewModel
import com.flicker.example.project.utils.common.Resource
import com.flicker.example.project.utils.network.NetworkHelper
import com.flicker.example.project.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.processors.PublishProcessor
import io.reactivex.schedulers.Schedulers


class HomeViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val postRepository: PostRepository,
    private val allPostList: ArrayList<Post>,
    private val paginator: PublishProcessor<Pair<String?, String?>>
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    val loading: MutableLiveData<Boolean> = MutableLiveData()
    val posts: MutableLiveData<Resource<List<Post>>> = MutableLiveData()

    val searchField: MutableLiveData<String> = MutableLiveData()
    val searchButton: MutableLiveData<Boolean> = MutableLiveData()

//
    init {

        compositeDisposable.add(
            paginator
                .onBackpressureDrop()
                .doOnNext {
                    loading.postValue(true)
                }
                .concatMapSingle { pageIds ->
                    return@concatMapSingle postRepository
                        .fetchHomePostList("india", "1")
                        .subscribeOn(Schedulers.io())
                        .doOnError {
                            handleNetworkError(it)
                        }
                }
                .subscribe(
                    {
                        allPostList.addAll(it)
                        loading.postValue(false)
                        posts.postValue(Resource.success(it))
                    },
                    {
                        handleNetworkError(it)
                    }
                )
        )
    }


    override fun onCreate() {
        loadMorePosts()
    }


    fun onSearchChange(search: String) = searchField.postValue(search)

    fun onSearch() {
        val searchText = searchField.value

        compositeDisposable.addAll(

            postRepository.fetchHomePostList(searchText, "1")
                .subscribeOn(schedulerProvider.io())
                .subscribe(
                    {
                        allPostList.addAll(it)
                        loading.postValue(false)
                        posts.postValue(Resource.success(it))
                    },
                    {
                        handleNetworkError(it)
                    }
                )
        )

    }


    private fun loadMorePosts() {
        val searchText = searchField.value
        if (checkInternetConnectionWithMessage()) paginator.onNext(Pair(searchText, "1"))
    }

    fun onLoadMore() {
        if (loading.value !== null && loading.value == false) loadMorePosts()
    }
}