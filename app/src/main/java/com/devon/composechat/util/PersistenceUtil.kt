package com.devon.composechat.util

import android.content.Context
import android.content.SharedPreferences
import com.devon.composechat.ui.theme.WeComposeChatTheme

/**
 * Note No.1
 * @Date 2022-02-22-00-38
 *
 * object是kotlin提供的一个修饰符，可以类比class修饰符，旨在快速创建单例对象。
 * object修饰符有两个作用，对象表达式（object expressions）和对象声明（object declarations），
 * 此处的object为后者，有自己的属性和方法，可以继承类或实现接口，
 * 但声明后会直接创建一个由kotlin严格维护的单例对象，可直接由对象名获取属性或调用方法。
 * 此为线程安全的饿汉式单例模式。
 */
object PersistenceUtil {
  private var sps: SharedPreferences?=null
  private fun getSps(context: Context):SharedPreferences{
    if(sps==null){
      sps=context.getSharedPreferences("default",Context.MODE_PRIVATE)
    }
    return sps!!
  }

  fun putInt(key:String,value:Int =0,context:Context){
    if(key.isNotBlank()){
      val editor:SharedPreferences.Editor=getSps(context).edit()
      editor.putInt(key,value)
      editor.apply()
    }
  }
  fun getInt(key:String,context:Context): Int {
    if(key.isNotBlank()){
      val sps:SharedPreferences=getSps(context)
      return sps.getInt(key,0)
    }
    return 0
  }

  fun getThemeFromSharedPreferences(context:Context): WeComposeChatTheme.Theme {
    when(getInt("theme",context)) {
      0 -> return WeComposeChatTheme.Theme.Light
      1 -> return WeComposeChatTheme.Theme.Dark
      2 -> return WeComposeChatTheme.Theme.NewYear
    }
    return WeComposeChatTheme.Theme.Light
  }
}