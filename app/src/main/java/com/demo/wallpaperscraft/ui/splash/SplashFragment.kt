package com.demo.wallpaperscraft.ui.splash

import android.os.Bundle
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.demo.wallpaperscraft.databinding.FragmentSplashBinding
import com.demo.wallpaperscraft.ui.base.BaseFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.demo.wallpaperscraft.R

class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            delay(2000)

            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        }
    }
}