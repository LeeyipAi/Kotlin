package jmm.baselibrary.ui.activity

import android.os.Bundle
import com.trello.rxlifecycle.components.support.RxAppCompatActivity
import jmm.baselibrary.common.AppManger

/**
 * user:Administrator
 * time:2018 04 09 9:56
 * package_name:jmm.baselibrary.ui.activity
 */
open class BaseActivity: RxAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppManger.instance.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        AppManger.instance.finishActivity(this)
    }
}