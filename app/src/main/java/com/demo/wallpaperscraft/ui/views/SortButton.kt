// ui/views/SortButton.kt
package com.demo.wallpaperscraft.ui.views // Thay bằng package của bạn

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.StringRes
import androidx.core.view.isVisible
import com.demo.wallpaperscraft.R // Thay bằng package của bạn
import com.demo.wallpaperscraft.databinding.SortButtonBinding

/**
 * Custom View để hiển thị nút chọn sắp xếp, bao gồm cả chỉ báo "mới" và bộ đếm.
 */
class SortButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    // Sử dụng ViewBinding để truy cập các View con một cách an toàn và hiệu quả
    private val binding: SortButtonBinding

    init {
        // "Thổi phồng" layout XML và gắn nó vào Custom View này
        binding = SortButtonBinding.inflate(LayoutInflater.from(context), this, true)
    }

    /**
     * Cập nhật văn bản chính của nút.
     * @param textResId ID của tài nguyên string (ví dụ: R.string.sort_popular)
     */
    fun setText(@StringRes textResId: Int) {
        binding.sortButtonText.setText(textResId)
    }

    /**
     * Hiển thị số lượng ảnh mới.
     * Nếu số lượng bằng 0, bộ đếm sẽ bị ẩn.
     * @param count Số lượng ảnh mới.
     */
    fun setCounter(count: Int) {
        binding.sortNewCounter.isVisible = count > 0
        if (count > 0) {
            binding.sortNewCounter.text = context.getString(R.string.sort_counter_placeholder, count)
        }
    }

    /**
     * Hiển thị hoặc ẩn chấm vàng báo hiệu có tùy chọn sort mới.
     * @param isVisible true để hiển thị, false để ẩn.
     */
    fun showNewSortIndicator(isVisible: Boolean) {
        binding.sortIsNew.isVisible = isVisible
    }

    /**
     * Đặt lại trạng thái của nút về mặc định (ẩn bộ đếm và chấm vàng).
     */
    fun clearIndicators() {
        setCounter(0)
        showNewSortIndicator(false)
    }
}