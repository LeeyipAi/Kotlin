package jmm.usercenter.data.api

import jmm.baselibrary.data.protocol.BaseResp
import jmm.usercenter.data.procotol.RegisterReq
import retrofit2.http.Body
import retrofit2.http.POST
import rx.Observable

/**
 * user:Administrator
 * time:2018 04 09 11:41
 * package_name:jmm.usercenter.data.api
 */
interface UserApi {
    /**
     * 註冊
     */

    @POST("userCenter/register")
    fun register(@Body req: RegisterReq): Observable<BaseResp<String>>
}