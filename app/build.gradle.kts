plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.google.services)
}


android {
    namespace = "com.demo.wallpaperscraft"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.demo.wallpaperscraft"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        vectorDrawables{
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    // --- UI & Material Design ---
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.google.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.swiperefreshlayout)
    implementation(libs.androidx.viewpager2)

    // --- Lifecycle & ViewModel (Kiến trúc MVVM) ---
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.activity.ktx)

    // --- Coroutines (Xử lý bất đồng bộ) ---
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // --- Networking (Gọi API Firebase) ---
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.converter.gson)
    implementation(libs.okhttp.core)

    // --- Image Loading (Tải và hiển thị ảnh) ---
    implementation(libs.glide)
    ksp(libs.glide.ksp) // Sử dụng KSP cho Glide

    // --- Database (Lưu Favorites, History, Collections) ---
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler) // Sử dụng KSP cho Room
    implementation(libs.androidx.room.ktx)

    // --- DataStore (Lưu Settings cho Wallpaper Changer) ---
    implementation(libs.androidx.datastore.preferences)

    // --- Background Tasks (Tự động đổi hình nền) ---
    implementation(libs.androidx.work.runtime.ktx)

    // --- Dependency Injection (Hilt) ---
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler) // Sử dụng KSP cho Hilt

    // Navigation Component
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)

    // --- Firebase (Remote Config & Analytics) ---
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.config)
    implementation(libs.firebase.analytics)
}