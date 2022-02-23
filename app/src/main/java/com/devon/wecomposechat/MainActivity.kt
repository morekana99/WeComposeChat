package com.devon.wecomposechat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.devon.wecomposechat.ui.ChangeStatusBarColor
import com.devon.wecomposechat.ui.ChatPage
import com.devon.wecomposechat.ui.Home
import com.devon.wecomposechat.ui.theme.WeComposeChatTheme
import com.devon.wecomposechat.util.PersistenceUtil


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





