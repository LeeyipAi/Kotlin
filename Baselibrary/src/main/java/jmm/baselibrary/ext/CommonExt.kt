package jmm.baselibrary.ext

import android.view.View
import com.trello.rxlifecycle.LifecycleProvider
import jmm.baselibrary.data.protocol.BaseResp
import jmm.baselibrary.rx.BaseFunc
import jmm.baselibrary.rx.BaseFuncBoolean
import jmm.baselibrary.rx.BaseSubscriber
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


/**
 * user:Administrator
 * time:2018 04 09 10:59
 * package_name:jmm.baselibrary.ext
 */

fun <T> Observable<T>.excute(subscriber: BaseSubscriber<T>, lifecycleProvider: LifecycleProvider<*>) {
    this.observeOn(AndroidSchedulers.mainThread())
            .compose(lifecycleProvider.bindToLifecycle())
            .subscribeOn(Schedulers.io())
            .subscribe(subscriber)
}

fun <T> Observable<BaseResp<T>>.convert(): Observable<T> {
        return this.flatMap(BaseFunc())
}

fun <T> Observable<BaseResp<T>>.convertBoolean(): Observable<Boolean> {
    return this.flatMap(BaseFuncBoolean())
}

fun View.onClick(listener: View.OnClickListener) {
    this.setOnClickListener(listener)
}

fun View.onClick(method: () -> Unit) {
    this.setOnClickListener { method() }
}