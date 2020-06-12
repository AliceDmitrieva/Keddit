package com.alisadmitrieva.keddit.api

import retrofit2.Call

interface NewsApi {
    fun getNews(after: String, limit: String): Call<RedditNewsResponse>
}
