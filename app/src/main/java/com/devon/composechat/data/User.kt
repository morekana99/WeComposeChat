package com.devon.composechat.data

import androidx.annotation.DrawableRes
import com.devon.composechat.R

class User(
    val id: String,
    val name: String,
    @DrawableRes val avatar: Int
) {
    companion object{
        val Me: User = User("devonwong72","我也不想水啊", R.drawable.avatar_devon)
    }

}