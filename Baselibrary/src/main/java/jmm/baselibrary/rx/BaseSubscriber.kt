package jmm.baselibrary.rx

import rx.Subscriber

/**
 * user:Administrator
 * time:2018 04 09 10:46
 * package_name:jmm.baselibrary.rx
 */
open class BaseSubscriber<T>:Subscriber<T>() {
    override fun onNext(t: T) {
    }

    override fun onCompleted() {
    }

    override fun onError(e: Throwable?) {
    }
}