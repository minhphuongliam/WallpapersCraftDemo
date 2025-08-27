# IN PROGRESS PROJECT
# WallCraft Clone - Android Wallpaper App

Một ứng dụng hình nền Android được xây dựng bằng Kotlin, lấy cảm hứng từ ứng dụng Wallcraft. Dự án này là một sản phẩm thực hành nhằm áp dụng các công nghệ và kiến trúc phát triển Android hiện đại.

## Tính năng

*   **Duyệt ảnh:** Màn hình chính với các tab và lưới ảnh cuộn vô hạn.
*   **Tương tác:** Vuốt để làm mới, xem chi tiết, và đặt hình nền.
*   **Cá nhân hóa:** Hệ thống Yêu thích và Lịch sử (sử dụng Room DB).
*   **Tự động hóa (Đang phát triển):** Tính năng tự động thay đổi hình nền với WorkManager.
*   **Kiến trúc Single-Activity:** Sử dụng Navigation Component để quản lý luồng màn hình.

## Phân tích và Thu thập Dữ liệu (API)

Do đây là một dự án clone, không có API công khai nào được cung cấp. Để xây dựng lớp Data, một quy trình phân tích kỹ thuật đã được thực hiện:

1.  **Phân tích Lưu lượng mạng:** Sử dụng **HTTP Toolkit** để chặn và kiểm tra các gói tin HTTP/HTTPS từ ứng dụng gốc đang chạy trên Android Emulator. Quá trình này giúp xác định các API endpoint, phương thức request, tham số (phân trang, sắp xếp), và cấu trúc của các response JSON.

2.  **Dịch ngược Ứng dụng:** Sử dụng **JADX-GUI** để dịch ngược file APK gốc. Việc này cung cấp các thông tin quan trọng để tái tạo lại giao diện và logic:
    *   **Trích xuất Tài nguyên:** Thu thập các tài nguyên từ thư mục `res` như drawables (icons), layouts (cấu trúc XML), và values (màu sắc, kích thước, styles).
    *   **Phân tích Cấu trúc:** Nghiên cứu tên các class, method và custom view để hiểu rõ hơn về kiến trúc và luồng hoạt động bên trong của ứng dụng.

*Lưu ý: Quá trình này được thực hiện hoàn toàn cho mục đích học tập và nghiên cứu kiến trúc client-server. Toàn bộ tài sản trí tuệ và dữ liệu thuộc về nhà phát triển ứng dụng gốc.*

## Công nghệ & Kiến trúc

*   **Ngôn ngữ:** Kotlin
*   **Kiến trúc:** MVVM, Repository Pattern, Clean Architecture Principles.
*   **Công nghệ chính:**
    *   **UI:** Android XML & Material Design
    *   **Asynchronous:** Kotlin Coroutines & Flow
    *   **Dependency Injection:** Hilt
    *   **Database:** Room
    *   **Data Storage:** Jetpack DataStore
    *   **Networking:** Retrofit
    *   **Image Loading:** Glide
    *   **Background Tasks:** WorkManager

## Cấu trúc Dự án

Dự án được tổ chức theo kiến trúc phân lớp và theo tính năng (feature-based) để dễ dàng quản lý và mở rộng.
