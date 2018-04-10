package jmm.baselibrary.widgets

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.view.Gravity
import android.widget.ImageView
import jmm.baselibrary.R
import org.jetbrains.anko.find

/**
 * user:Administrator
 * time:2018 04 10 15:40
 * package_name:jmm.baselibrary.widgets
 */
class ProgressLoading private constructor(context: Context, themeResId: Int) : Dialog(context, themeResId) {

    companion object {
        private lateinit var mDialog: ProgressLoading

        private var animationDrawable: AnimationDrawable? = null

        fun create(context: Context): ProgressLoading {
            mDialog = ProgressLoading(context, R.style.LightProgressDialog)
            mDialog.setContentView(R.layout.progress_dialog)
            mDialog.setCancelable(true)
            mDialog.setCanceledOnTouchOutside(false)
            mDialog.window.attributes.gravity = Gravity.CENTER

            val lp = mDialog.window.attributes
            lp.dimAmount = 0.2f
            mDialog.window.attributes = lp

            var mIvLoading = mDialog.find<ImageView>(R.id.iv_loading)

            animationDrawable = mIvLoading.background as AnimationDrawable

            return mDialog
        }
    }

    fun showLoading() {
        super.show()
        animationDrawable?.start()
    }

    fun dismissLoading() {
        super.dismiss()
        animationDrawable?.stop()
    }

}