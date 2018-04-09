package jmm.usercenter.data.repository

import jmm.baselibrary.data.net.RetrofitFactory
import jmm.baselibrary.data.protocol.BaseResp
import jmm.usercenter.data.api.UserApi
import jmm.usercenter.data.procotol.RegisterReq
import rx.Observable
import javax.inject.Inject

/**
 * user:Administrator
 * time:2018 04 09 14:31
 * package_name:jmm.usercenter.data.repository
 */
class UserRepository @Inject constructor(){
    fun register(moblie: String,verifyCode : String, pwd: String): Observable<BaseResp<String>>{
        return RetrofitFactory.instance.create(UserApi::class.java)
                .register(RegisterReq( moblie,verifyCode,pwd))

    }
}