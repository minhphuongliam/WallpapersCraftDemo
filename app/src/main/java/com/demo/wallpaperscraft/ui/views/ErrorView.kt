package com.demo.wallpaperscraft.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.demo.wallpaperscraft.R
import com.demo.wallpaperscraft.databinding.LayoutErrorBinding

class ErrorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding = LayoutErrorBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        orientation = VERTICAL
        gravity = android.view.Gravity.CENTER

        // Logic đọc attrs có thể được thêm vào đây nếu cần
    }

    // Hàm để gán sự kiện click từ Fragment/Activity
    fun onRetry(listener: () -> Unit) {
        binding.buttonErrorRetry.setOnClickListener { listener() }
    }
}