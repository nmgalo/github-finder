buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.3")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.0")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.40.4")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.5")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
