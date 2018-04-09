package jmm.usercenter.service.impl

import jmm.baselibrary.data.protocol.BaseResp
import jmm.baselibrary.rx.BaseException
import jmm.usercenter.data.repository.UserRepository
import jmm.usercenter.service.UserService
import rx.Observable
import rx.functions.Func1
import javax.inject.Inject

/**
 * user:Administrator
 * time:2018 04 09 10:28
 * package_name:jmm.usercenter.service.impl
 */
class UserServiceImpl @Inject constructor() : UserService {
    @Inject
    lateinit var userRepository: UserRepository

    override fun register(moblie: String, verifyCode: String, pwd: String): Observable<Boolean> {
        return userRepository.register(moblie, verifyCode, pwd)
                .flatMap(object : Func1<BaseResp<String>, Observable<Boolean>> {
                    override fun call(t: BaseResp<String>): Observable<Boolean> {
                        if (t.status != 0) {
                            return Observable.error(BaseException(t.status, t.message))
                        }
                        return Observable.just(true)
                    }

                })
    }
}