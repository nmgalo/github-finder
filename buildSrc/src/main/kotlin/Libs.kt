object Libs {

    object Kotlin {
        const val kotlinxSerialization =
            "org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.0-RC2"
    }

    object Androidx {
        const val core = "androidx.core:core-ktx:1.7.0"
        const val appcompat = "androidx.appcompat:appcompat:1.4.0"
        const val material = "com.google.android.material:material:1.4.0"
        const val constraint_layout = "androidx.constraintlayout:constraintlayout:2.1.2"

        object Navigation {
            private const val nav_version = "2.3.5"
            const val fragment = "androidx.navigation:navigation-fragment-ktx:$nav_version"
            const val ui = "androidx.navigation:navigation-ui-ktx:$nav_version"
            const val dynamicFeatures =
                "androidx.navigation:navigation-dynamic-features-fragment:$nav_version"
            const val navigationKotlin = "androidx.fragment:fragment-ktx:1.3.0-alpha04"
        }
    }

    object Di {
        private const val hiltVersion = "2.40.4"
        const val hilt = "com.google.dagger:hilt-android:$hiltVersion"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$hiltVersion"
    }

    object Network {
        private const val retrofitVersion = "2.9.0"
        const val retrofit = "com.squareup.retrofit2:retrofit:${retrofitVersion}"
        const val kotlinx_serialization =
            "com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.7.0"
        const val okhttp_logging_interceptor = "com.squareup.okhttp3:logging-interceptor:4.9.0"
    }

    object Test {
        const val junit = "junit:junit:4.+"
        const val AndroidxJUnit = "androidx.test.ext:junit:1.1.3"
        const val espresso_core = "androidx.test.espresso:espresso-core:3.4.0"
    }
}
