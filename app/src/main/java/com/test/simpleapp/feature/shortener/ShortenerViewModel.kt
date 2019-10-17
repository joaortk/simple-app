package com.test.simpleapp.feature.shortener

import android.webkit.URLUtil
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.simpleapp.domain.exception.SimpleException
import com.test.simpleapp.domain.model.OriginalUrl
import com.test.simpleapp.domain.model.ShortLink
import com.test.simpleapp.domain.repository.ShortenerRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class ShortenerViewModel @Inject constructor(private val repository: ShortenerRepository) : ViewModel() {

    val urlInput = ObservableField<String>()
    val resultUrl = ObservableField<String>()
    val errorMessage = ObservableField<String>()

    val decodeErrorMessage = ObservableField<String>()

    fun shortenUrl() {
        urlInput.get()?.let { url ->
            if (validate(url)) {
                viewModelScope.launch {
                    try {
                        repository.shortenUrl(url).apply {
                            updateState(this)
                        }
                    } catch (e: SimpleException) {
                        errorMessage.set(e.message ?: "Erro inesperado")
                    }

                }
            } else {
                errorMessage.set("URL inválida")
            }
        } ?: run { errorMessage.set("URL deve ser informada") }
    }

    fun decodeUrl() {
        urlInput.get()?.let { url ->
            if (validate(url)) {
                viewModelScope.launch {
                    try {
                        repository.decodeAlias(url).apply {
                            updateState(this)
                        }
                    } catch (e: SimpleException) {
                        errorMessage.set(e.message ?: "Erro inesperado")
                    }

                }
            } else {
                errorMessage.set("URL inválida")
            }
        } ?: run { errorMessage.set("URL deve ser informada") }
    }

    private fun updateState(shortLink: ShortLink) {
        resultUrl.set(shortLink.alias)
        errorMessage.set(null)
    }

    private fun updateState(originalUrl: OriginalUrl) {
        resultUrl.set(originalUrl.url)
        errorMessage.set(null)
    }

    private fun validate(url: String): Boolean {
        return URLUtil.isValidUrl(url)
    }
}