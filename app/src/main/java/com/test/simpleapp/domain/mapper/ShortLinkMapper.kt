package com.test.simpleapp.domain.mapper

import com.test.simpleapp.data.response.AliasResponse
import com.test.simpleapp.domain.model.ShortLink

object ShortLinkMapper {
    fun toShortLink(response: AliasResponse): ShortLink {
        return ShortLink(response.alias, OriginalUrlMapper.toOriginalUrl(response.links))
    }
}