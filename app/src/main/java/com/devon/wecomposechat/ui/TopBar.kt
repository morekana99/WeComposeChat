package com.devon.wecomposechat.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.devon.wecomposechat.R
import com.devon.wecomposechat.WeViewModel
import com.devon.wecomposechat.ui.theme.WeComposeChatTheme

@Composable
fun TopBar(title: String, onBack: (() -> Unit)? = null) {
	Box(
		Modifier
			.background(WeComposeChatTheme.colors.background)
			.fillMaxWidth()
	) {
		Row(
			Modifier
				.height(48.dp)
		) {
			if (onBack != null) {
				Icon(
					painterResource(R.drawable.ic_back),
					null,
					Modifier
						.clickable(onClick = onBack)
						.align(Alignment.CenterVertically)
						.size(36.dp)
						.padding(8.dp),
					tint = WeComposeChatTheme.colors.icon
				)
			}
			Spacer(Modifier.weight(1f))
			val viewModel: WeViewModel = viewModel()
			Icon(
				painterResource(R.drawable.ic_palette),
				"切换主题",
				Modifier
					.clickable {
						viewModel.theme = when (viewModel.theme) {
							WeComposeChatTheme.Theme.Light -> WeComposeChatTheme.Theme.Dark
							WeComposeChatTheme.Theme.Dark -> WeComposeChatTheme.Theme.NewYear
							WeComposeChatTheme.Theme.NewYear -> WeComposeChatTheme.Theme.Light
						}
					}
					.align(Alignment.CenterVertically)
					.size(36.dp)
					.padding(8.dp),
				tint = WeComposeChatTheme.colors.icon
			)
		}
		Text(title, Modifier.align(Alignment.Center), color = WeComposeChatTheme.colors.textPrimary)
	}
}