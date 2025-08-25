package com.demo.wallpaperscraft.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.view.isVisible
import com.demo.wallpaperscraft.databinding.ViewPriceBinding

// Kế thừa từ LinearLayout
class CoinPrice @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    // Sử dụng ViewBinding để truy cập các view con
    private val binding: ViewPriceBinding

    init {

        binding = ViewPriceBinding.inflate(LayoutInflater.from(context), this)
        // Mặc định là ẩn
        isVisible = false
    }

    // Hàm public đơn giản để hiển thị giá
    fun setPrice(price: Int) {
        if (price > 0) {
            binding.priceValue.text = price.toString()
            isVisible = true
        } else {
            isVisible = false
        }
    }
}