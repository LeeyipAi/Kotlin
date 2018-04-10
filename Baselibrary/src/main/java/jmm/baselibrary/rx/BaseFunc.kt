package jmm.baselibrary.rx

import jmm.baselibrary.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1

/**
 * user:Administrator
 * time:2018 04 10 10:41
 * package_name:jmm.baselibrary.rx
 */
class BaseFunc<T> : Func1<BaseResp<T>, Observable<T>> {

    override fun call(t: BaseResp<T>): Observable<T> {
        if (t.status != 0) {
            return Observable.error(BaseException(t.status, t.message))
        }
        return Observable.just(t.data)
    }

}