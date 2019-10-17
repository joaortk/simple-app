package com.test.simpleapp.data.response

import com.google.gson.annotations.SerializedName

data class AliasResponse(
    val alias: String,
    @SerializedName("_links") val links: AliasLinkResponse
)