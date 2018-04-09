package jmm.baselibrary.injection.module

import android.app.Activity
import dagger.Module
import dagger.Provides

/**
 * user:Administrator
 * time:2018 04 09 16:50
 * package_name:jmm.baselibrary.injection.module
 */

@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    fun providerActivity():Activity{
        return activity
    }
}