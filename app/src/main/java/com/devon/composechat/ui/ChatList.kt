package com.devon.composechat.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.devon.composechat.WeViewModel
import com.devon.composechat.data.Chat
import com.devon.composechat.ui.theme.WeComposeChatTheme


@Composable
fun ChatList(chats: List<Chat>) {
    Column(
        Modifier
            .background(WeComposeChatTheme.colors.listItem)
            .fillMaxSize()
    ) {
        TopBar(title = "微信")
        LazyColumn(Modifier.background(WeComposeChatTheme.colors.listItem)){
            itemsIndexed(chats){ index, chat ->
                ChatListItem(chat)
                Divider(
                        startIndent = 68.dp,
                color = WeComposeChatTheme.colors.chatListDivider,
                thickness = 0.5f.dp
                )
            }
        }
    }
}

@Composable
private fun ChatListItem(chat: Chat) {
    val viewModel: WeViewModel = viewModel()
    Row(
        Modifier
            .padding(10.dp)
            .clickable {
                viewModel.startChat(chat)
            }
            .fillMaxWidth()
    ) {
        Image(
            painterResource(chat.friend.avatar), chat.friend.name,
            Modifier

                .padding(4.dp)
                .size(48.dp)
                .unread(!chat.msgs.last().read, WeComposeChatTheme.colors.badge)
                .clip(RoundedCornerShape(4.dp))
        )
        Column(
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(chat.friend.name, fontSize = 17.sp, color = WeComposeChatTheme.colors.textPrimary)
            Text(
                chat.msgs.last().text,
                fontSize = 14.sp,
                color = WeComposeChatTheme.colors.textSecondary
            )
        }
        Text(
            chat.msgs.last().time,
            Modifier.padding(8.dp, 8.dp, 12.dp, 8.dp),
            fontSize = 11.sp, color = WeComposeChatTheme.colors.textSecondary
        )
    }
}

fun Modifier.unread(show: Boolean, color:Color): Modifier = this.drawWithContent {
    drawContent()
    if(show){
        drawCircle(
            color,
            5.dp.toPx(),
            Offset(size.width - 1.dp.toPx(), 1.dp.toPx())
        )
    }
}

@Preview
@Composable
fun ChatListDefault() {
    val viewModel: WeViewModel = viewModel()
    ChatList(viewModel.chats)
}
