package jmm.baselibrary.rx

import jmm.baselibrary.data.protocol.BaseResp
import rx.Observable
import rx.functions.Func1

/**
 * user:Administrator
 * time:2018 04 10 10:41
 * package_name:jmm.baselibrary.rx
 */
class BaseFuncBoolean<T> : Func1<BaseResp<T>, Observable<Boolean>> {

    override fun call(t: BaseResp<T>): Observable<Boolean> {
        if (t.status != 0) {
            return Observable.error(BaseException(t.status, t.message))
        }
        return Observable.just(true)
    }

}