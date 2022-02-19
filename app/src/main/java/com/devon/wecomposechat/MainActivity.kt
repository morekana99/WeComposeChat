package com.devon.wecomposechat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.devon.wecomposechat.ui.theme.WeComposeChatTheme
import com.devon.wecomposechat.ui.theme.black
import com.devon.wecomposechat.ui.theme.green3

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WeComposeChatTheme {
                Column {
//                    BottomNavigator()
                }
            }
        }
    }
}

@Composable
private fun BottomNavigator(selected: Int) {
    Row(Modifier.background(WeComposeChatTheme.colors.bottomBar)) {
        TabItem(
            if (selected == 0) R.drawable.ic_chat_filled else R.drawable.ic_chat_outlined, "聊天",
            if (selected == 0) WeComposeChatTheme.colors.iconCurrent else WeComposeChatTheme.colors.icon,
            Modifier.weight(1f)
        )
        TabItem(
            if (selected ==1) R.drawable.ic_contacts_filled else R.drawable.ic_contacts_outlined, "通讯录",
            if (selected == 1)  WeComposeChatTheme.colors.iconCurrent else WeComposeChatTheme.colors.icon,
            Modifier.weight(1f)
        )
        TabItem(
            if (selected ==2) R.drawable.ic_discovery_filled else R.drawable.ic_discovery_outlined, "发现",
            if (selected == 2)  WeComposeChatTheme.colors.iconCurrent else WeComposeChatTheme.colors.icon,
            Modifier.weight(1f)
        )
        TabItem(
            if (selected ==3) R.drawable.ic_me_filled else R.drawable.ic_me_outlined, "我",
            if (selected == 3)  WeComposeChatTheme.colors.iconCurrent else WeComposeChatTheme.colors.icon,
            Modifier.weight(1f)
        )
    }
}

@Composable
private fun TabItem(@DrawableRes iconId:Int, title: String, tint:Color, modifier: Modifier = Modifier) {
    Column ( modifier.padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally){
        Icon(painterResource(iconId), title, Modifier.size(24.dp), tint = tint)
        Text(title, fontSize = 11.sp, color = tint)
    }
}

@Preview(showBackground = true)
@Composable
fun  BottomNavigatorPreview() {
    BottomNavigator(selected = 0 )

}

@Preview(showBackground = true)
@Composable
fun TabItemPreview() {
    TabItem(iconId = R.drawable.ic_chat_outlined, title = "聊天 ", tint = WeComposeChatTheme.colors.iconCurrent)
}
