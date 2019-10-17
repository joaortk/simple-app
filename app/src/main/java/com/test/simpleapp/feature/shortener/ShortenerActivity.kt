package com.test.simpleapp.feature.shortener

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.test.simpleapp.R
import com.test.simpleapp.SimpleApplication
import com.test.simpleapp.common.ViewModelFactory
import com.test.simpleapp.databinding.ActivityShortenerBinding
import javax.inject.Inject

class ShortenerActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    init {
        SimpleApplication.appComponent.inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataBindingUtil
            .setContentView<ActivityShortenerBinding>(this, R.layout.activity_shortener)
            .apply {
                viewModel = ViewModelProviders.of(this@ShortenerActivity, viewModelFactory)[ShortenerViewModel::class.java]
            }
    }
}
