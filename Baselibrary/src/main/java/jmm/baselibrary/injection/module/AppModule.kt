package jmm.baselibrary.injection.module

import android.content.Context
import dagger.Module
import dagger.Provides
import jmm.baselibrary.common.BaseApplication
import javax.inject.Singleton

/**
 * user:Administrator
 * time:2018 04 09 16:42
 * package_name:jmm.baselibrary.injection.module
 */

@Module
class AppModule(private val context:BaseApplication) {

    @Provides
    @Singleton
    fun providesContext(): Context {
        return context
    }
}