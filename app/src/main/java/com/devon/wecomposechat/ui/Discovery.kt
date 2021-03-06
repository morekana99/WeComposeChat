package com.devon.wecomposechat.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devon.wecomposechat.ui.theme.WeComposeChatTheme
import com.devon.wecomposechat.R


@Composable
fun DiscoveryListTopBar() {
	TopBar(title = "发现")
}

@Preview(showBackground = true)
@Composable
fun DiscoveryListTopBarPreview() {
	DiscoveryListTopBar()
}

@Composable
fun DiscoveryListItem(
	@DrawableRes icon: Int,
	title: String,
	modifier: Modifier = Modifier,
	badge: @Composable (() -> Unit)? = null,
	endBadge: @Composable (() -> Unit)? = null
) {
	Row(
		Modifier
			.fillMaxWidth(),
		verticalAlignment = Alignment.CenterVertically
	) {
		Image(
			painterResource(icon), "title", Modifier
				.padding(12.dp, 8.dp, 8.dp, 8.dp)
				.size(36.dp)
				.padding(8.dp)
		)
		Text(
			title,
			fontSize = 17.sp,
			color = WeComposeChatTheme.colors.textPrimary
		)
		badge?.invoke()
		Spacer(Modifier.weight(1f))
		endBadge?.invoke()
		Icon(
			painterResource(R.drawable.ic_arrow_more), contentDescription = "更多",
			Modifier
				.padding(0.dp, 0.dp, 12.dp, 0.dp)
				.size(16.dp),
			tint = WeComposeChatTheme.colors.more
		)
	}
}

@Composable
fun DiscoveryList() {
	Column(Modifier.fillMaxSize()) {
		DiscoveryListTopBar()
		Box(
			Modifier
				.background(WeComposeChatTheme.colors.background)
				.fillMaxSize()
		) {
			Column(
				Modifier
					.background(WeComposeChatTheme.colors.listItem)
					.fillMaxWidth()
			) {
				DiscoveryListItem(R.drawable.ic_moments, "朋友圈", badge = {
					Box(
						Modifier
							.padding(8.dp)
							.clip(RoundedCornerShape(50))
							.size(18.dp)
							.background(WeComposeChatTheme.colors.badge)
					) {
						Text(
							"3",
							Modifier.align(Alignment.Center),
							fontSize = 12.sp,
							color = WeComposeChatTheme.colors.onBadge
						)
					}
				}, endBadge = {
					Image(
						painterResource(R.drawable.avatar_pony), "avatar", Modifier
							.padding(8.dp, 0.dp)
							.size(32.dp)
							.unread(false, WeComposeChatTheme.colors.badge)
							.clip(RoundedCornerShape(4.dp))
					)
				})
				Spacer(
					Modifier
						.background(WeComposeChatTheme.colors.background)
						.fillMaxWidth()
						.height(8.dp)
				)
				DiscoveryListItem(R.drawable.ic_channels, "视频号", endBadge = {
					Image(
						painterResource(R.drawable.avatar_gyh), "avatar", Modifier
							.padding(8.dp, 0.dp)
							.size(32.dp)
							.unread(false, WeComposeChatTheme.colors.badge)
							.clip(RoundedCornerShape(4.dp))
					)
					Text(
						"赞过", Modifier.padding(0.dp, 0.dp, 4.dp, 0.dp),
						fontSize = 14.sp, color = WeComposeChatTheme.colors.textSecondary
					)
				})
				Spacer(
					Modifier
						.background(WeComposeChatTheme.colors.background)
						.fillMaxWidth()
						.height(8.dp)
				)
				DiscoveryListItem(R.drawable.ic_ilook, "看一看")
				Divider(
					startIndent = 56.dp,
					color = WeComposeChatTheme.colors.chatListDivider,
					thickness = 0.8f.dp
				)
				DiscoveryListItem(R.drawable.ic_isearch, "搜一搜")
				Spacer(
					Modifier
						.background(WeComposeChatTheme.colors.background)
						.fillMaxWidth()
						.height(8.dp)
				)
				DiscoveryListItem(R.drawable.ic_nearby, "直播和附近")
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DiscoveryListPreview() {
	WeComposeChatTheme {
		DiscoveryList()
	}
}