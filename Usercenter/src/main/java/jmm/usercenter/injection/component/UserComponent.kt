package jmm.usercenter.injection.component

import dagger.Component
import jmm.baselibrary.injection.PerComponentScope
import jmm.baselibrary.injection.component.ActivityComponent
import jmm.usercenter.injection.module.UserModule
import jmm.usercenter.ui.activity.RegisterActivity

/**
 * user:Administrator
 * time:2018 04 09 15:48
 * package_name:jmm.usercenter.injection.component
 */
@PerComponentScope
@Component(dependencies = arrayOf(ActivityComponent::class),modules = arrayOf(UserModule::class))
interface UserComponent {
        fun inject(activity: RegisterActivity)
}