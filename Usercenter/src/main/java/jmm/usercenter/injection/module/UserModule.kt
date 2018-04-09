package jmm.usercenter.injection.module

import dagger.Module
import dagger.Provides
import jmm.usercenter.service.UserService
import jmm.usercenter.service.impl.UserServiceImpl

/**
 * user:Administrator
 * time:2018 04 09 15:40
 * package_name:jmm.usercenter.injection.module
 */

@Module
class UserModule {

    @Provides
    fun providesUserService(service: UserServiceImpl): UserService {
        return service
    }
}