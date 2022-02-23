package com.devon.composechat.ui

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.devon.composechat.WeViewModel
import com.devon.composechat.ui.theme.WeComposeChatTheme
import com.devon.composechat.R
import com.devon.composechat.util.PersistenceUtil

@Composable
fun TopBar(title: String, onBack: (() -> Unit)? = null) {
	val context = LocalContext.current
	Column(
		Modifier
			.background(WeComposeChatTheme.colors.background)
			.fillMaxWidth()
	) {
		Spacer(
			Modifier
				.height(48.dp)
				.fillMaxWidth()
				.background(WeComposeChatTheme.colors.background)
				)
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
					painterResource(R.drawable.ic_add),
					"切换主题",
					Modifier
						.clickable {
							viewModel.theme = when (viewModel.theme) {
								WeComposeChatTheme.Theme.Light -> {
									PersistenceUtil.putInt("theme", 1, context)
									WeComposeChatTheme.Theme.Dark
								}
								WeComposeChatTheme.Theme.Dark -> {
									PersistenceUtil.putInt("theme", 2, context)
									WeComposeChatTheme.Theme.NewYear
								}
								WeComposeChatTheme.Theme.NewYear -> {
									PersistenceUtil.putInt("theme", 0, context)
									WeComposeChatTheme.Theme.Light
								}
							}
						}
						.align(Alignment.CenterVertically)
						.size(36.dp)
						.padding(8.dp),
					tint = WeComposeChatTheme.colors.icon
				)
			}
			Text(title, Modifier.align(Alignment.Center), fontSize = 18.sp, color = WeComposeChatTheme.colors.textPrimary)
		}
	}

}

@Composable
fun Menu(){
	val viewModel: WeViewModel = viewModel()
	DropdownMenu(expanded = true, onDismissRequest = {
	}, modifier = Modifier.width(100.dp)) {
		viewModel.datas.forEach {
			DropdownMenuItem(onClick = {
			}) {
				Icon(imageVector = Icons.Default.Favorite, contentDescription = "")
				Text(text = it, modifier = Modifier.padding(start = 10.dp))
			}
		}
	}
}


@Preview
@Composable
fun TopBarDefault() {
	TopBar("test")
}