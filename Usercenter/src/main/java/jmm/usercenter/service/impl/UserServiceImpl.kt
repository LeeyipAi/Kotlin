package jmm.usercenter.service.impl

import jmm.baselibrary.ext.convertBoolean
import jmm.usercenter.data.repository.UserRepository
import jmm.usercenter.service.UserService
import rx.Observable
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
                .convertBoolean()
    }
}