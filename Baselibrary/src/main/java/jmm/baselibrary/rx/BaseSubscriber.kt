package jmm.baselibrary.rx

import jmm.baselibrary.persenter.view.BaseView
import rx.Subscriber

/**
 * user:Administrator
 * time:2018 04 09 10:46
 * package_name:jmm.baselibrary.rx
 */
open class BaseSubscriber<T>(val baseView: BaseView) : Subscriber<T>() {
    override fun onNext(t: T) {
    }

    override fun onCompleted() {
        baseView.hideLoading()
    }

    override fun onError(e: Throwable?) {
        baseView.hideLoading()
    }
}