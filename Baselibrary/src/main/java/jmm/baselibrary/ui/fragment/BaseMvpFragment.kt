package jmm.baselibrary.ui.fragment

import android.app.Activity
import android.os.Bundle
import jmm.baselibrary.common.BaseApplication
import jmm.baselibrary.injection.component.ActivityComponent
import jmm.baselibrary.injection.component.DaggerActivityComponent
import jmm.baselibrary.injection.module.ActivityModule
import jmm.baselibrary.injection.module.LifecycleProviderModule
import jmm.baselibrary.persenter.BasePresenter
import jmm.baselibrary.persenter.view.BaseView
import org.jetbrains.anko.support.v4.toast
import javax.inject.Inject

/**
 * user:Administrator
 * time:2018 04 09 9:57
 * package_name:jmm.baselibrary.ui.activity
 */
abstract class BaseMvpFragment<T : BasePresenter<*>> : BaseFragment(), BaseView {

    lateinit var activityComponent: ActivityComponent
    @Inject
    lateinit var mPresenter: T

    abstract fun injectComponent()

    override fun showLoading() {
    }

    override fun hideLoading() {
    }

    override fun onError(text: String) {
       toast(text)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inintActivityInjection()
        injectComponent()
    }

    private fun inintActivityInjection() {
        activityComponent = DaggerActivityComponent.builder().appComponent((activity?.application as BaseApplication).appComponent).activityModule(ActivityModule(activity as Activity))
                .lifecycleProviderModule(LifecycleProviderModule(this))
                .build()
    }
}