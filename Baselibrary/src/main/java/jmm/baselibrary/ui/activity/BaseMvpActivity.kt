package jmm.baselibrary.ui.activity

import android.os.Bundle
import jmm.baselibrary.common.BaseApplication
import jmm.baselibrary.injection.component.ActivityComponent
import jmm.baselibrary.injection.component.DaggerActivityComponent
import jmm.baselibrary.injection.module.ActivityModule
import jmm.baselibrary.persenter.BasePresenter
import jmm.baselibrary.persenter.view.BaseView
import javax.inject.Inject

/**
 * user:Administrator
 * time:2018 04 09 9:57
 * package_name:jmm.baselibrary.ui.activity
 */
open class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    lateinit var activityComponent : ActivityComponent
    @Inject
    lateinit var mPresenter: T

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError() {
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inintActivityInjection()
    }

    private fun inintActivityInjection() {
        activityComponent = DaggerActivityComponent.builder().appComponent((application as BaseApplication).appComponent).activityModule(ActivityModule(this)).build()
    }
}