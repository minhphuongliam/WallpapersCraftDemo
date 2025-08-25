package com.demo.wallpaperscraft.ui.views

import android.content.Context
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.demo.wallpaperscraft.R
import com.google.android.material.progressindicator.CircularProgressIndicator

/**
 * Đây là một phiên bản "giả lập" (mock) của ProgressWheel từ app gốc.
 * Chúng ta sử dụng CircularProgressIndicator của Material Design để thay thế,
 * vì nó có chức năng tương tự và dễ sử dụng hơn.
 */
class ProgressWheel @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
) : CircularProgressIndicator(context, attrs) {

    init {
        // Thiết lập các thuộc tính mặc định để nó trông giống app gốc

        // Kích thước của vòng quay (tính bằng dp, cần chuyển đổi sang px)
        val density = resources.displayMetrics.density
        val strokeWidthInPixels = (4 * density).toInt()
        val indicatorSizeInPixels = (40 * density).toInt()

        // Áp dụng các thuộc tính trực tiếp
        this.indicatorSize = indicatorSizeInPixels  // Kích thước tổng thể của view
        this.trackThickness = strokeWidthInPixels   // Độ dày của vạch quay

        // Màu sắc - chúng ta sẽ dùng màu vàng đặc trưng
        // Dùng ContextCompat để an toàn hơn khi lấy màu
        // Bạn cần định nghĩa @color/main_yellow trong file colors.xml
        val indicatorColor = ContextCompat.getColor(context, R.color.main_yellow)
        this.setIndicatorColor(indicatorColor)

        // Đảm bảo nó là loại không xác định (xoay tròn liên tục)
        this.isIndeterminate = true

        // Ẩn cái track nền đi để chỉ còn lại vòng quay
        this.trackCornerRadius = 0 // Tùy chọn, để đảm bảo track nền biến mất hoàn toàn
        this.trackThickness = 0    // Cách chắc chắn nhất để ẩn track nền
        // CẬP NHẬT: Cách đúng hơn để chỉ có vòng quay là set track color thành transparent
        this.trackColor = ContextCompat.getColor(context, android.R.color.transparent)

        // Khôi phục lại trackThickness cho vòng quay chính
        this.trackThickness = strokeWidthInPixels
    }
}