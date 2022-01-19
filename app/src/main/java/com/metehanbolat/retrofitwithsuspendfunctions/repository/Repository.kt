package com.metehanbolat.retrofitwithsuspendfunctions.repository

import com.metehanbolat.retrofitwithsuspendfunctions.api.RetrofitInstance
import com.metehanbolat.retrofitwithsuspendfunctions.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}