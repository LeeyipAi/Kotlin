package jmm.baselibrary.ext

import jmm.baselibrary.rx.BaseSubscriber
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 * user:Administrator
 * time:2018 04 09 10:59
 * package_name:jmm.baselibrary.ext
 */

fun <T> Observable<T>.excute(subscriber: BaseSubscriber<T>) {
    this.observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(subscriber)

}