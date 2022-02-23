package com.devon.composechat

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.devon.composechat.data.Chat
import com.devon.composechat.data.Msg
import com.devon.composechat.data.User
import com.devon.composechat.ui.theme.WeComposeChatTheme

class WeViewModel: ViewModel() {
    var chats by mutableStateOf(
        listOf( // List<Chat>
            Chat(
                friend = User("pony", "Pony马", R.drawable.avatar_pony),
                mutableStateListOf(
                    Msg(User("pony", "Pony马", R.drawable.avatar_pony), "马上到我办公室", "11:28"),
                )
            ),
            Chat(
                friend = User("allen", "AllenZhang", R.drawable.avatar_allen),
                mutableStateListOf(
                    Msg(User("allen", "AllenZhang", R.drawable.avatar_allen), "新项目怎么样了", "13:48"),
                )
            ),
            Chat(
                friend = User("dbws", "东北往事群", R.drawable.avatar_dbws),
                mutableStateListOf(
                    Msg(User("hu", "废物虎", R.drawable.avatar_duli), "全体目光向我看齐！！！", "21:20"),
                    Msg(User("hu", "废物虎", R.drawable.avatar_duli), "向我看齐啊！！！", "21:20"),
                    Msg(User("dao", "废物刀", R.drawable.avatar_dao), "\uD83D\uDC40", "21:20"),
                    Msg(User("hu", "废物虎", R.drawable.avatar_duli), "我宣布个事儿！！！", "21:20"),
                    Msg(User("hu", "废物虎", R.drawable.avatar_duli), "我是个烧鸡！！！", "21:20"),
                    Msg(User("dao", "废物刀", R.drawable.avatar_dao), "\uD83D\uDC4F", "21:20"),
                    Msg(User("hu", "废物虎", R.drawable.avatar_duli), "这位更是重量级", "21:20"),
                    Msg(User("dao", "废物刀", R.drawable.avatar_dao), "我告诉你啊杀马特团长", "21:20"),
                    Msg(User("dao", "废物刀", R.drawable.avatar_dao), "你到沈阳俩", "21:20"),
                    Msg(User("dao", "废物刀", R.drawable.avatar_dao), "指腚没你好果汁吃", "21:20"),
                    Msg(User.Me, "笑死我了\uD83D\uDE02", "21:20"),

                )
            ),
        )
    )
    var theme by mutableStateOf(WeComposeChatTheme.Theme.Light)
    var currentChat: Chat? by mutableStateOf(null)
    var chatting by mutableStateOf(false)

    fun startChat(chat: Chat){
        chatting = true
        currentChat = chat
    }
    fun endChat(): Boolean{
        if(chatting){
            chatting = false
            return true
        }
        return false
    }

    fun boom(chat: Chat) {
        chat.msgs.add(Msg(User.Me, "\uD83D\uDCA3", "22:22").apply { read = true })
    }

    val contacts by mutableStateOf(
        listOf(
            User("allen", "AllenZhang", R.drawable.avatar_allen),
            User("pony", "Pony马", R.drawable.avatar_pony),
            User("dao", "废物刀", R.drawable.avatar_dao),
            User("hu", "废物虎", R.drawable.avatar_duli),

        )
    )
    val datas = mutableListOf(
        "发起群聊",
        "添加朋友",
        "扫一扫",
        "主题"
    )
}