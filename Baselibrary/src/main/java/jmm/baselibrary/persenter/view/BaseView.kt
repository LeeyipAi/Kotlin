package jmm.baselibrary.persenter.view

/**
 * user:Administrator
 * time:2018 04 09 9:54
 * package_name:jmm.baselibrary.persenter.view
 */
interface BaseView {
    fun showLoading()

    fun hideLoading()

    fun onError()
}