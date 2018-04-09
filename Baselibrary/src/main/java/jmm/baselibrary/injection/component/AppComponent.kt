package jmm.baselibrary.injection.component

import android.content.Context
import dagger.Component
import jmm.baselibrary.injection.module.AppModule
import javax.inject.Singleton

/**
 * user:Administrator
 * time:2018 04 09 16:40
 * package_name:jmm.baselibrary.injection.module.component
 */

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun context(): Context
}
