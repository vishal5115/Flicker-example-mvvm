package com.flicker.example.project.data.repository

import com.flicker.example.project.data.local.db.DatabaseService
import com.flicker.example.project.data.model.Post
import com.flicker.example.project.data.remote.NetworkService
import io.reactivex.Single
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService
) {

    fun fetchHomePostList(tag:String?,perPage:String?): Single<List<Post>> {
        return networkService.doHomePostListCall("64c0f179f8aec0444033c8b2c57a7db0",tag,"json",perPage,"url_s").map { it.photos.photo }
    }

}