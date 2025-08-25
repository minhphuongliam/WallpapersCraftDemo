package com.demo.wallpaperscraft.ui.views

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.card.MaterialCardView

class ShadowLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = com.google.android.material.R.attr.materialCardViewStyle
) : MaterialCardView(context, attrs, defStyleAttr) {

    // Có thể đọc các thuộc tính sl_* từ attrs ở đây nếu muốn tùy chỉnh thêm
    // Nhưng các giá trị mặc định của MaterialCardView thường đã đủ tốt.
    // Ví dụ: cardElevation, radius...
}