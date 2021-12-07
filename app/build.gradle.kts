plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization") version Versions.kotlin
    id("dagger.hilt.android.plugin")
}


android {
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.appId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        viewBinding = true
    }

    kotlinOptions {
        jvmTarget = Versions.jvmTarget
    }
}

dependencies {

    implementation(Libs.Androidx.core)
    implementation(Libs.Androidx.appcompat)
    implementation(Libs.Androidx.material)
    implementation(Libs.Androidx.constraint_layout)

    implementation(Libs.Di.hilt)
    kapt(Libs.Di.hiltCompiler)

    implementation(Libs.Network.retrofit)
    implementation(Libs.Kotlin.kotlinxSerialization)
    implementation(Libs.Network.kotlinx_serialization)
    implementation(Libs.Network.okhttp_logging_interceptor)

    implementation(Libs.Androidx.Navigation.fragment)
    implementation(Libs.Androidx.Navigation.ui)
    implementation(Libs.Androidx.Navigation.dynamicFeatures)
    implementation(Libs.Androidx.Navigation.navigationKotlin)

    implementation(Libs.Extras.glide)

    testImplementation(Libs.Test.junit)
    androidTestImplementation(Libs.Test.AndroidxJUnit)
    androidTestImplementation(Libs.Test.espresso_core)
}