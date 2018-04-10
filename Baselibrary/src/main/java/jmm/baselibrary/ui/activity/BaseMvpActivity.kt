package jmm.baselibrary.ui.activity

import android.os.Bundle
import jmm.baselibrary.common.BaseApplication
import jmm.baselibrary.injection.component.ActivityComponent
import jmm.baselibrary.injection.component.DaggerActivityComponent
import jmm.baselibrary.injection.module.ActivityModule
import jmm.baselibrary.injection.module.LifecycleProviderModule
import jmm.baselibrary.persenter.BasePresenter
import jmm.baselibrary.persenter.view.BaseView
import jmm.baselibrary.widgets.ProgressLoading
import org.jetbrains.anko.toast
import javax.inject.Inject

/**
 * user:Administrator
 * time:2018 04 09 9:57
 * package_name:jmm.baselibrary.ui.activity
 */
abstract class BaseMvpActivity<T : BasePresenter<*>> : BaseActivity(), BaseView {

    @Inject
    lateinit var mPresenter: T

    lateinit var activityComponent: ActivityComponent

    private lateinit var mLoadingDialog: ProgressLoading

    abstract fun injectComponent()

    override fun showLoading() {
        mLoadingDialog.showLoading()
    }

    override fun hideLoading() {
        mLoadingDialog.dismissLoading()
    }

    override fun onError(text: String) {
        toast(text)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inintActivityInjection()
        injectComponent()
        mLoadingDialog = ProgressLoading.create(this)
    }

    private fun inintActivityInjection() {
        activityComponent = DaggerActivityComponent.builder().appComponent((application as BaseApplication).appComponent).activityModule(ActivityModule(this))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()
    }

}