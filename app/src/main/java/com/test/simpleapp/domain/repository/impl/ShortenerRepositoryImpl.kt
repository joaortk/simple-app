package com.test.simpleapp.domain.repository.impl

import com.test.simpleapp.data.api.AliasAPI
import com.test.simpleapp.data.request.PostAliasRequestBody
import com.test.simpleapp.domain.exception.SimpleException
import com.test.simpleapp.domain.mapper.OriginalUrlMapper
import com.test.simpleapp.domain.mapper.ShortLinkMapper
import com.test.simpleapp.domain.model.OriginalUrl
import com.test.simpleapp.domain.model.ShortLink
import com.test.simpleapp.domain.repository.ShortenerRepository
import retrofit2.HttpException
import javax.inject.Inject

class ShortenerRepositoryImpl @Inject constructor(private val aliasAPI: AliasAPI) : ShortenerRepository {
    override suspend fun shortenUrl(url: String): ShortLink {
        try {
            val response = aliasAPI.postAlias(PostAliasRequestBody(url))
            return ShortLinkMapper.toShortLink(response)
        } catch (ex: HttpException) {
            //Map possible exceptions to the right treatments
            throw SimpleException(message = "Não encontrado!")
        } catch (ex: Exception) {
            //Map possible exceptions to the right treatments
            throw SimpleException(ex)
        }
    }

    override suspend fun decodeAlias(alias: String): OriginalUrl {
        try {
            val response = aliasAPI.getUrl(alias)
            return OriginalUrlMapper.toOriginalUrl(response)
        } catch (ex: HttpException) {
            //Map possible exceptions to the right treatments
            throw SimpleException(message = "Não encontrado!")
        } catch (ex: Exception) {
            //Map possible exceptions to the right treatments
            throw SimpleException(ex)
        }
    }

}