package com.devon.wecomposechat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import com.devon.wecomposechat.ui.BottomNavigator
import com.devon.wecomposechat.ui.theme.WeComposeChatTheme



class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeComposeChatTheme {
                Column {
                    val viewModel:WeViewModel = viewModel()
                    BottomNavigator(viewModel.selectedTab){
                        viewModel.selectedTab = it
                    }
                }
            }
        }
    }
}

