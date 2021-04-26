package com.flicker.example.project.ui.home.posts

import android.view.ViewGroup
import androidx.lifecycle.Lifecycle
import com.flicker.example.project.data.model.Post
import com.flicker.example.project.ui.base.BaseAdapter

class PostsAdapter(
    parentLifecycle: Lifecycle,
    posts: ArrayList<Post>
) : BaseAdapter<Post, PostItemViewHolder>(parentLifecycle, posts) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PostItemViewHolder(parent)
}