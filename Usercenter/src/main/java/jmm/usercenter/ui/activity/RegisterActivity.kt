package jmm.usercenter.ui.activity

import android.os.Bundle
import android.view.View
import com.kotlin.base.widgets.VerifyButton
import jmm.baselibrary.common.AppManger
import jmm.baselibrary.ext.onClick
import jmm.baselibrary.ui.activity.BaseMvpActivity
import jmm.usercenter.R
import jmm.usercenter.injection.component.DaggerUserComponent
import jmm.usercenter.injection.module.UserModule
import jmm.usercenter.presenter.RegisterPresenter
import jmm.usercenter.presenter.view.RegisterView
import kotlinx.android.synthetic.main.activity_register.*
import org.jetbrains.anko.toast

class RegisterActivity : BaseMvpActivity<RegisterPresenter>(), RegisterView, View.OnClickListener {

    private var pressTime: Long = 0

    override fun onRegisterResult(result: String) {
        toast(result)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        mRegisterBtn.onClick(this)
        mGetVerifyBtn.onClick(this)
        mGetVerifyBtn.setOnVerifyBtnClick(object:VerifyButton.OnVerifyBtnClick{
            override fun onClick() {
                toast("验证码已经发送")
            }
        })
    }

    override fun injectComponent() {
        DaggerUserComponent.builder().activityComponent(activityComponent).userModule(UserModule()).build().inject(this)
        mPresenter.mView = this
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.mRegisterBtn -> mPresenter.register(mMobileEt.text.toString(), mVerifyEt.text.toString(), mPwdEt.text.toString())
            R.id.mGetVerifyBtn -> mGetVerifyBtn.requestSendVerifyNumber()
        }
    }

    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000) {
            pressTime = time
            toast("再按一次退出程序")
        } else {
            AppManger.instance.finishAllActivity()
        }
    }
}
