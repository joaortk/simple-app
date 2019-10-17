package com.test.simpleapp.common

import android.webkit.URLUtil

class ValidationUtilsImpl : ValidationUtils {
    override fun isValidUrl(text: String) = URLUtil.isValidUrl(text)
}