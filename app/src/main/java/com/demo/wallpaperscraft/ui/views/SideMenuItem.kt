package com.demo.wallpaperscraft.ui.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.demo.wallpaperscraft.R
import com.demo.wallpaperscraft.databinding.ItemSidemenuBinding

/**
 * Custom View cho một mục trong menu trượt.
 * Đóng gói icon, text, bộ đếm và trạng thái được chọn/không được chọn.
 */
class SideMenuItem @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding: ItemSidemenuBinding

    init {
        // Inflate layout và thiết lập ban đầu
        binding = ItemSidemenuBinding.inflate(LayoutInflater.from(context), this, true)
        orientation = HORIZONTAL
        gravity = android.view.Gravity.CENTER_VERTICAL

        // Đọc các thuộc tính tùy chỉnh từ file XML layout
        attrs?.let {
            val typedArray = context.obtainStyledAttributes(it, R.styleable.SideMenuItem, 0, 0)

            // Lấy và set icon
            val imageResId = typedArray.getResourceId(R.styleable.SideMenuItem_image, 0)
            if (imageResId != 0) {
                binding.imageIcon.setImageResource(imageResId)
            }

            // Lấy và set text
            val text = typedArray.getString(R.styleable.SideMenuItem_text)
            binding.textTitle.text = text

            typedArray.recycle()
        }

        // Đặt trạng thái ban đầu là không được chọn
        isSelected = false
    }

    override fun setSelected(selected: Boolean) {
        super.setSelected(selected)
        if (selected) {
            // Trạng thái được chọn
            binding.layoutItem.setBackgroundColor(ContextCompat.getColor(context, R.color.main_back_lite))
            val selectedColor = ContextCompat.getColor(context, R.color.main_yellow)
            binding.imageIcon.setColorFilter(selectedColor)
            binding.textTitle.setTextColor(selectedColor)
        } else {
            // Trạng thái không được chọn
            binding.layoutItem.setBackgroundColor(ContextCompat.getColor(context, android.R.color.transparent))
            val defaultColor = ContextCompat.getColor(context, R.color.main_white)
            binding.imageIcon.setColorFilter(defaultColor)
            binding.textTitle.setTextColor(defaultColor)
        }
    }

    /**
     * Hiển thị số lượng đếm bên cạnh mục menu.
     * @param count Số lượng. Nếu count <= 0, bộ đếm sẽ bị ẩn.
     */
    fun setCount(count: Int) {
        binding.counterTextView.isVisible = count > 0
        if (count > 0) {
            binding.counterTextView.text = count.toString()
        }
    }

    /**
     * Cập nhật lại text của mục menu.
     */
    fun setText(text: String) {
        binding.textTitle.text = text
    }
}