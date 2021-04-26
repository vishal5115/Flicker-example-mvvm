package com.flicker.example.project.data.remote

import com.flicker.example.project.data.remote.response.PostListResponse
import io.reactivex.Single
import retrofit2.http.*
import javax.inject.Singleton

@Singleton
interface NetworkService {

    @GET(Endpoints.HOME_POSTS_LIST)
    fun doHomePostListCall(
        @Query("api_key") apiKeyy: String?,
        @Query("text") text: String?,
        @Query("format") format: String?,
        @Query("nojsoncallback") perPage: String?,
        @Query("extras") extras: String?
    ): Single<PostListResponse>

}