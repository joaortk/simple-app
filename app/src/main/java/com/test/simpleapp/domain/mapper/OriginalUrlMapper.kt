package com.test.simpleapp.domain.mapper

import com.test.simpleapp.data.response.AliasLinkResponse
import com.test.simpleapp.data.response.UrlResponse
import com.test.simpleapp.domain.model.OriginalUrl

object OriginalUrlMapper {
    fun toOriginalUrl(response: UrlResponse): OriginalUrl {
        return OriginalUrl(url = response.url)
    }

    fun toOriginalUrl(response: AliasLinkResponse): OriginalUrl {
        return OriginalUrl(url = response.self)
    }
}