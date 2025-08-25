package com.demo.wallpaperscraft.data.model

data class ImageVersion(
    val qualityLabel: String, // Ví dụ: "Full HD", "4K UHD", "Original"
    val resolutionLabel: String, // Ví dụ: "1080x1920"
    val sizeLabel: String, // Ví dụ: "1.2 MB"
    val url: String, // URL để tải phiên bản này
    val width: Int,
    val height: Int
)