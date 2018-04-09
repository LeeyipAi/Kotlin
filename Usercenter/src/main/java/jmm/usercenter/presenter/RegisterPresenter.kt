package jmm.usercenter.presenter

import jmm.baselibrary.ext.excute
import jmm.baselibrary.persenter.BasePresenter
import jmm.baselibrary.rx.BaseSubscriber
import jmm.usercenter.presenter.view.RegisterView
import jmm.usercenter.service.UserService
import javax.inject.Inject

/**
 * user:Administrator
 * time:2018 04 09 10:03
 * package_name:jmm.usercenter.presenter
 */
class RegisterPresenter @Inject constructor() : BasePresenter<RegisterView>() {

    @Inject
    lateinit var userService: UserService
    /**
     * 注册
     */
    fun register(mobile: String, verifyCode: String, pwd: String) {
        userService.register(mobile, verifyCode, pwd)
                .excute(object : BaseSubscriber<Boolean>() {
                    override fun onNext(t: Boolean) {
                        mView.onRegisterResult(true)
                    }
                })
    }

}