package project.poifinder.common.base

import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import project.poifinder.common.permission.PermissionsCheckHelper

open class BaseActivity : AppCompatActivity() {

    protected val permissionsCheckHelper = PermissionsCheckHelper(this)

    protected inline fun <reified T : ViewDataBinding> binding(@LayoutRes resId: Int): Lazy<T> =
        lazy { DataBindingUtil.setContentView<T>(this, resId) }

}