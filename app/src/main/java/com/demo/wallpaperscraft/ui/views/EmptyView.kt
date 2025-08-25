package com.demo.wallpaperscraft.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.demo.wallpaperscraft.R
import com.demo.wallpaperscraft.databinding.LayoutEmptyBinding

class EmptyView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding = LayoutEmptyBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        orientation = VERTICAL
        gravity = android.view.Gravity.CENTER

        // Đọc các thuộc tính tùy chỉnh từ XML
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.EmptyView, 0, 0)

            val text = typedArray.getString(R.styleable.EmptyView_e_text)
            binding.emptyText.text = text

            val imageResId = typedArray.getResourceId(R.styleable.EmptyView_e_image, 0)
            if (imageResId != 0) {
                binding.emptyImage.setImageResource(imageResId)
            }

            typedArray.recycle()
        }
    }
}