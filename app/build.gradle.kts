plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "be.hcpl.android.qwik"
    compileSdk = 35

    defaultConfig {
        applicationId = "be.hcpl.android.qwik"
        minSdk = 26
        targetSdk = 35
        versionCode = 3
        versionName = "0.1.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
    //    sourceCompatibility = JavaVersion.VERSION_1_8
    //    targetCompatibility = JavaVersion.VERSION_1_8
        sourceCompatibility = JavaVersion.VERSION_20
        targetCompatibility = JavaVersion.VERSION_20
    }
    kotlinOptions {
        // > Inconsistent JVM-target compatibility detected for tasks 'compileDebugJavaWithJavac' (1.8) and 'compileDebugKotlin' (21).
        //jvmTarget = "1.8"
        jvmTarget = "20"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        // only needed for kotlin < 2.0.0
        //kotlinCompilerExtensionVersion = "1.5.15"
    }
}

dependencies {
    implementation(libs.androidx.compose)
    implementation(libs.compose.material3)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.ui.text.google.fonts)
    implementation(libs.koin.android)

    implementation(libs.linkify.text)

    // tools
    implementation(libs.androidx.ui.tooling.preview.android)
    debugImplementation(libs.androidx.ui.tooling)

    // test dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}