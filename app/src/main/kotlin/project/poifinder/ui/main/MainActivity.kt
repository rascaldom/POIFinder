package project.poifinder.project.poifinder.ui.main

import android.os.Bundle
import org.koin.androidx.viewmodel.ext.android.viewModel
import project.poifinder.R
import project.poifinder.common.base.BaseActivity
import project.poifinder.databinding.ActivityMainBinding
import project.poifinder.project.poifinder.common.permission.PermissionsCheckHelper

class MainActivity : BaseActivity() {

    private val viewModel: MainViewModel by viewModel()
    private val binding: ActivityMainBinding by binding(R.layout.activity_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            lifecycleOwner = this@MainActivity
        }

        if (permissionsCheckHelper.checkPermissions()) {
            initializeView()
        }
    }

    private fun initializeView() {
        viewModel.sampleList.observe(this, {
            println("[rascaldom] it : ${it}")
        })
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            PermissionsCheckHelper.PERMISSIONS_REQUEST_CODE -> {
                if (permissionsCheckHelper.processPermissionsResult(requestCode, permissions, grantResults)) {
                    initializeView()
                } else {
                    finish()
                }

                return
            }
        }
    }

}