package com.savchuk.booklistapptask.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import com.savchuk.booklistapptask.R
import com.savchuk.booklistapptask.presentation.navigation.BookNavHost
import com.savchuk.booklistapptask.ui.theme.BookListAppTaskTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookListAppTaskTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(topBar = {
                        CenterAlignedTopAppBar(colors = TopAppBarDefaults.mediumTopAppBarColors(

                        ),
                            title = {
                                Text(
                                    getString(R.string.book_app),
                                )
                            }
                        )
                    }) {
                        BookNavHost(modifier = Modifier.padding(it))
                    }

                }
            }
        }
    }
}
