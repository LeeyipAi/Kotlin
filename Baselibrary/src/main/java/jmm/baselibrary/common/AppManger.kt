package jmm.baselibrary.common

import android.app.Activity
import android.app.ActivityManager
import android.content.Context
import java.util.*

/**
 * user:Administrator
 * time:2018 04 10 11:45
 * package_name:jmm.baselibrary.common
 */
open class AppManger private constructor() {

    private val activityStack: Stack<Activity> = Stack()

    companion object {
        val instance: AppManger by lazy { AppManger() }
    }

    /*
        入栈
     */
    fun addActivity(activity: Activity) {
        activityStack.add(activity)
    }

    /*
        出栈
     */
    fun finishActivity(activity: Activity) {
        activity.finish()
        activityStack.remove(activity)
    }

    /*
        获取栈顶部
     */
    fun currentActivity(): Activity {
        return activityStack.lastElement()
    }

    /*
        清理栈
     */
    fun finishAllActivity(){
        for (activity in activityStack) {
            activity.finish()
        }
        activityStack.clear()
    }

    /*
        退出App
     */
    fun exitApp(context: Context){
        finishAllActivity()
        val activityManager = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activityManager.killBackgroundProcesses(context.packageName)
        System.exit(0)
    }

}