package com.devon.composechat

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.devon.composechat.ui.ChangeStatusBarColor
import com.devon.composechat.ui.ChatPage
import com.devon.composechat.ui.Home
import com.devon.composechat.ui.theme.WeComposeChatTheme
import com.devon.composechat.util.PersistenceUtil


class MainActivity : ComponentActivity() {
    private val viewModel:WeViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        viewModel.theme = PersistenceUtil.getThemeFromSharedPreferences(this)
        setContent {
            ChangeStatusBarColor(Color.Transparent)
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





