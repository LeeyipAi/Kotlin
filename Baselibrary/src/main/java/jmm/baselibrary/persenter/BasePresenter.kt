package jmm.baselibrary.persenter

import android.content.Context
import com.kotlin.base.utils.NetWorkUtils
import com.trello.rxlifecycle.LifecycleProvider
import jmm.baselibrary.persenter.view.BaseView
import javax.inject.Inject

/**
 * user:Administrator
 * time:2018 04 09 9:53
 * package_name:jmm.baselibrary.persenter
 */
open class BasePresenter<T : BaseView> {

    lateinit var mView: T

    @Inject
    lateinit var mLifecycleProvider: LifecycleProvider<*>

    @Inject
    lateinit var context: Context

    fun checkNetWork(): Boolean {
        if (NetWorkUtils.isNetWorkAvailable(context)) {
            return true
        }
        mView.onError("网络不可用")
        return false
    }
}