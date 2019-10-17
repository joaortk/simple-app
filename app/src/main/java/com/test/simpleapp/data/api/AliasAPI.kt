package com.test.simpleapp.data.api

import com.test.simpleapp.data.request.PostAliasRequestBody
import com.test.simpleapp.data.response.AliasResponse
import com.test.simpleapp.data.response.UrlResponse
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface AliasAPI {
    @POST("/api/alias")
    suspend fun postAlias(@Body postAliasRequestBody: PostAliasRequestBody): AliasResponse

    @POST("/api/alias/{aliasId}")
    suspend fun getUrl(@Path("aliasId") aliasId: String): UrlResponse
}