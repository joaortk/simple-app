package com.test.simpleapp.domain.repository

import com.test.simpleapp.domain.model.OriginalUrl
import com.test.simpleapp.domain.model.ShortLink

interface ShortenerRepository {
    suspend fun shortenUrl(url: String) : ShortLink
    suspend fun decodeAlias(alias: String) : OriginalUrl
}