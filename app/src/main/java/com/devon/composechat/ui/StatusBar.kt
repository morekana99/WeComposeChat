package com.devon.composechat.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.devon.composechat.WeViewModel
import com.devon.composechat.ui.theme.WeComposeChatTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController



@Composable
fun ChangeStatusBarColor(color: Color){
  val viewModel: WeViewModel = viewModel()
  val darkIcons: Boolean = when(viewModel.theme){
    WeComposeChatTheme.Theme.Light -> true
    WeComposeChatTheme.Theme.Dark -> false
    WeComposeChatTheme.Theme.NewYear -> false
  }
  OnChange(color,darkIcons)
}

@Composable
private fun OnChange(color: Color, darkIcons: Boolean = false) {
  val systemUiController = rememberSystemUiController()
  systemUiController.setStatusBarColor(color, darkIcons)
}