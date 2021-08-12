package com.udacity.shoestore

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.navigation.LoginFragment
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        val navController = this.findNavController(R.id.myNavHostFragment)

        binding.toolbar.setOnMenuItemClickListener {
            if (it.itemId == R.id.logout) {
                if (getForegroundFragment() !is LoginFragment) {
                    navController.popBackStack(R.id.loginFragment, false)
                }
                return@setOnMenuItemClickListener true
            }
            false
        }
        NavigationUI.setupWithNavController(binding.toolbar, navController)

        Timber.plant(Timber.DebugTree())
    }

    private fun getForegroundFragment(): Fragment? {
        val navHostFragment: Fragment? =
            supportFragmentManager.findFragmentById(R.id.myNavHostFragment)
        return navHostFragment?.childFragmentManager?.fragments?.get(0)
    }

}
