package com.devon.composechat.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devon.composechat.WeViewModel
import com.devon.composechat.data.User
import com.devon.composechat.ui.theme.WeComposeChatTheme
import com.devon.composechat.R
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun ContactListTopBar() {
	TopBar(title = "通讯录")
}
@Composable
fun ContactListItem(
	contact: User,
) {
	Row(
		Modifier
			.fillMaxWidth()
	) {
		Image(
			painterResource(contact.avatar), "avatar", Modifier
				.padding(12.dp, 8.dp, 8.dp, 8.dp)
				.size(36.dp)
				.clip(RoundedCornerShape(4.dp))
		)
		Text(
			contact.name,
			Modifier
				.weight(1f)
				.align(Alignment.CenterVertically),
			fontSize = 17.sp,
			color = WeComposeChatTheme.colors.textPrimary
		)
	}
}

@Composable
fun ContactList(viewModel: WeViewModel = viewModel()) {
	Column(Modifier.fillMaxSize()) {
		ContactListTopBar()
		Box(
			Modifier
				.background(WeComposeChatTheme.colors.background)
				.fillMaxSize()
		) {
			ContactList(viewModel.contacts)
		}
	}
}

@Composable
fun ContactList(contacts: List<User>) {
	LazyColumn(
		Modifier
			.background(WeComposeChatTheme.colors.listItem)
			.fillMaxWidth()
	) {
		val buttons = listOf(
			User("contact_add", "新的朋友", R.drawable.ic_contact_add),
			User("contact_chat", "仅聊天", R.drawable.ic_contact_chat),
			User("contact_group", "群聊", R.drawable.ic_contact_group),
			User("contact_tag", "标签", R.drawable.ic_contact_tag),
			User("contact_official", "公众号", R.drawable.ic_contact_official),
		)
		itemsIndexed(buttons) { index, contact ->
			ContactListItem(contact)
			if (index < buttons.size - 1) {
				Divider(
					startIndent = 56.dp,
					color = WeComposeChatTheme.colors.chatListDivider,
					thickness = 0.8f.dp
				)
			}
		}
		item {
			Text(
				"朋友",
				Modifier
					.background(WeComposeChatTheme.colors.background)
					.fillMaxWidth()
					.padding(12.dp, 8.dp),
				fontSize = 14.sp,
				color = WeComposeChatTheme.colors.onBackground
			)
		}
		itemsIndexed(contacts) { index, contact ->
			ContactListItem(contact)
			if (index < contacts.size - 1) {
				Divider(
					startIndent = 56.dp,
					color = WeComposeChatTheme.colors.chatListDivider,
					thickness = 0.8f.dp
				)
			}
		}
	}
}

