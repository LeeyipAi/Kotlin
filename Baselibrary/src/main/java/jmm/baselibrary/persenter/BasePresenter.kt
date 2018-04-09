package jmm.baselibrary.persenter

import jmm.baselibrary.persenter.view.BaseView

/**
 * user:Administrator
 * time:2018 04 09 9:53
 * package_name:jmm.baselibrary.persenter
 */
open class BasePresenter<T: BaseView> {
    lateinit var mView:T
}