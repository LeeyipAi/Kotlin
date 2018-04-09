package jmm.usercenter.service

import rx.Observable

/**
 * user:Administrator
 * time:2018 04 09 10:26
 * package_name:jmm.usercenter.service
 */
interface UserService {
    fun register(moblie: String, verifyCode: String, pwd: String): Observable<Boolean>
}