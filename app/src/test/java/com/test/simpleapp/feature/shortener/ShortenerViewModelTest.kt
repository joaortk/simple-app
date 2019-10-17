package com.test.simpleapp.feature.shortener

import com.test.simpleapp.common.ValidationUtils
import com.test.simpleapp.domain.model.OriginalUrl
import com.test.simpleapp.domain.model.ShortLink
import com.test.simpleapp.domain.repository.ShortenerRepository
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class ShortenerViewModelTest {

    lateinit var viewModel: ShortenerViewModel

    val repository: ShortenerRepository = mockk()
    val validationUtils: ValidationUtils = mockk()

    val validUrl = "http://test.com"
    val invalidUrl = "http://"
    @Before
    fun setup() {
        viewModel = ShortenerViewModel(repository, validationUtils)
    }

    @Test
    fun whenShortenCalled_mustEmitResultUrl() {
        every { validationUtils.isValidUrl(any()) } returns true
        coEvery { repository.shortenUrl(any()) } returns ShortLink(alias = "http://short.com", originalUrl = OriginalUrl(validUrl))

        viewModel.urlInput.set(validUrl)
        viewModel.shortenUrl()
        assertThat(viewModel.resultUrl.get()).isEqualTo("http://short.com")
    }

    @Test
    fun whenShortenCalled_andInputIsInvalid_mustEmitError() {
        every { validationUtils.isValidUrl(any()) } returns false
        viewModel.urlInput.set(invalidUrl)
        viewModel.shortenUrl()
        assertThat(viewModel.errorMessage.get()).isEqualTo("URL inválida")
    }

}