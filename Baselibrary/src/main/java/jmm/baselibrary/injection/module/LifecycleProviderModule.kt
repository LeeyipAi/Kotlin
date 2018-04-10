package jmm.baselibrary.injection.module

import com.trello.rxlifecycle.LifecycleProvider
import dagger.Module
import dagger.Provides

/**
 * user:Administrator
 * time:2018 04 09 16:50
 * package_name:jmm.baselibrary.injection.module
 */

@Module
class LifecycleProviderModule(private val lifecycleProvider: LifecycleProvider<*>) {

    @Provides
    fun providerLifecycleProvider():LifecycleProvider<*>{
        return lifecycleProvider
    }
}