package com.demo.wallpaperscraft.ui.main

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.demo.wallpaperscraft.databinding.ActivityMainBinding
import com.demo.wallpaperscraft.ui.base.BaseActivity
import com.demo.wallpaperscraft.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.CraftTheme)
        super.onCreate(savedInstanceState)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

        //Home là cấp cao nhất trong DrawerLayout, có thể thêm các Fragment khác sau
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.homeFragment), // thêm frag khác làm top vào đây
            binding.drawerLayout
        )

    }

    /**
     * Các fragment con (như HomeFragment) sẽ gọi hàm này để
     * kết nối Toolbar của chúng với NavController và DrawerLayout.
     */
    fun setupToolbarForNavigation(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
        toolbar.setupWithNavController(navController, appBarConfiguration)
    }

}