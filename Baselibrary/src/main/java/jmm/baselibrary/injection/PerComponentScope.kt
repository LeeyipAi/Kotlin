package jmm.baselibrary.injection

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.RUNTIME
import javax.inject.Scope

/**
 * user:Administrator
 * time:2018 04 09 17:01
 * package_name:jmm.baselibrary.injection
 */


@Scope
@Documented
@Retention(RUNTIME)
annotation class PerComponentScope
