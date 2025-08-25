package com.demo.wallpaperscraft.ui.home

import android.os.Bundle
import android.view.View
import com.demo.wallpaperscraft.databinding.FragmentCategoryBinding
import com.demo.wallpaperscraft.databinding.FragmentHomeBinding
import com.demo.wallpaperscraft.ui.base.BaseFragment
import com.demo.wallpaperscraft.ui.main.MainActivity

/** Fix lại Fragment này */
class HomeFragment : BaseFragment<FragmentCategoryBinding>(FragmentCategoryBinding::inflate) {

    // Tạm thời chưa cần ViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Kết nối Toolbar của Fragment này với MainActivity
        (activity as? MainActivity)?.setupToolbarForNavigation(binding.toolbar)

        // TODO: Thiết lập ViewPager2 và TabLayout ở đây
        // 1. Tạo một FragmentStateAdapter
        // 2. Gán adapter cho ViewPager2 (binding.pager)
        // 3. Dùng TabLayoutMediator để kết nối binding.tabs và binding.pager
    }
}
