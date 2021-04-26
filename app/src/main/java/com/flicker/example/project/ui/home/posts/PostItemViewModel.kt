package com.flicker.example.project.ui.home.posts

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.flicker.example.project.data.model.Image
import com.flicker.example.project.data.model.Post
import com.flicker.example.project.data.repository.PostRepository
import com.flicker.example.project.ui.base.BaseItemViewModel
import com.flicker.example.project.utils.display.ScreenUtils
import com.flicker.example.project.utils.log.Logger
import com.flicker.example.project.utils.network.NetworkHelper
import com.flicker.example.project.utils.rx.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class PostItemViewModel @Inject constructor(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper,
    private val postRepository: PostRepository
) : BaseItemViewModel<Post>(schedulerProvider, compositeDisposable, networkHelper) {

    companion object {
        const val TAG = "PostItemViewModel"
    }

    private val screenWidth = ScreenUtils.getScreenWidth()
    private val screenHeight = ScreenUtils.getScreenHeight()


    val imageDetail: LiveData<Image> = Transformations.map(data) {

        Image(
            "https://farm"+it.farm+".staticflickr.com/"+it.server+"/"+it.id+"_"+it.secret+".jpg",
            screenWidth,
            100?.let { height ->
                return@let (calculateScaleFactor(it) * height).toInt()
            } ?: screenHeight / 3)
    }

    override fun onCreate() {
        Logger.d(TAG, "onCreate called")
    }

    private fun calculateScaleFactor(post: Post) =
        100?.let { return@let screenWidth.toFloat() / it } ?: 1f

}