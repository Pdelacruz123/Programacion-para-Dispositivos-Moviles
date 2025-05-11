// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
}

buildscript {
    dependencies {
        // Declaramos la dependencia del plugin Safe Args con la versión adecuada
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.6.0")
    }
}

