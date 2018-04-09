package jmm.baselibrary.injection.component

import android.app.Activity
import dagger.Component
import jmm.baselibrary.injection.ActivityScope
import jmm.baselibrary.injection.module.ActivityModule

/**
 * user:Administrator
 * time:2018 04 09 16:50
 * package_name:jmm.baselibrary.injection.component
 */

@ActivityScope
@Component(dependencies = arrayOf(AppComponent::class),modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun activity():Activity
}