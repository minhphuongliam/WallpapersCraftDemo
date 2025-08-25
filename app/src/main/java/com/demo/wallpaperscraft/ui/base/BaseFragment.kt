package com.demo.wallpaperscraft.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/**
 * @param VB Loại ViewBinding của Fragment con.
 * @param inflate Hàm lambda để khởi tạo ViewBinding, ví dụ: FragmentHomeContainerBinding::inflate
 */
abstract class BaseFragment<VB : ViewBinding>(
    private val inflate : (LayoutInflater, ViewGroup?, Boolean) -> VB
) : Fragment(){

    private var _binding: VB? = null
    protected val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}