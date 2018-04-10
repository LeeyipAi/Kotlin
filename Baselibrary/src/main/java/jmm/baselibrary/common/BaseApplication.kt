package jmm.baselibrary.common

import android.app.Application
import android.content.Context
import jmm.baselibrary.injection.component.AppComponent
import jmm.baselibrary.injection.component.DaggerAppComponent
import jmm.baselibrary.injection.module.AppModule

/**
 * user:Administrator
 * time:2018 04 09 16:43
 * package_name:jmm.baselibrary.common
 */
class BaseApplication:Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initAppInjection()
        context = this
    }

    private fun initAppInjection() {
        appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    }

    companion object {
        lateinit var context: Context
    }
}