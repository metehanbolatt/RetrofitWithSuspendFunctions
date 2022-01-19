package com.metehanbolat.retrofitwithsuspendfunctions.repository

import com.metehanbolat.retrofitwithsuspendfunctions.api.RetrofitInstance
import com.metehanbolat.retrofitwithsuspendfunctions.model.Post

class Repository {

    suspend fun getPost(): Post {
        return RetrofitInstance.api.getPost()
    }
}