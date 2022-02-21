package com.devon.wecomposechat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.devon.wecomposechat.ui.BottomNavigator
import com.devon.wecomposechat.ui.ChatList
import com.devon.wecomposechat.ui.ChatPage
import com.devon.wecomposechat.ui.Home
import com.devon.wecomposechat.ui.theme.WeComposeChatTheme
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager


class MainActivity : ComponentActivity() {
    private val viewModel:WeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeComposeChatTheme(viewModel.theme) {
                Box{
                    Home(viewModel)
                    ChatPage()
                }
            }
        }
    }

    override fun onBackPressed() {
        if(!viewModel.endChat()) {
            super.onBackPressed()
        }
    }
}



