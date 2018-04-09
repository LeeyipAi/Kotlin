package jmm.usercenter.ui.activity

import android.os.Bundle
import jmm.baselibrary.ui.activity.BaseMvpActivity
import jmm.usercenter.R
import jmm.usercenter.injection.component.DaggerUserComponent
import jmm.usercenter.injection.module.UserModule
import jmm.usercenter.presenter.RegisterPresenter
import jmm.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(),RegisterView {

    override fun onRegisterResult(result: Boolean) {
        toast("注册成功")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initInjection()
        mRegisterBtn.setOnClickListener() {
            mPresenter.register(mMobileEt.text.toString(),mVerifyEt.text.toString(),mPwdEt.text.toString())
        }

    }

    private fun initInjection() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)

        mPresenter.mView = this
    }
}
