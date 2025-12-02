plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)
}

android {
    namespace = "com.rudra.ledgerly"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.rudra.ledgerly"
        minSdk = 28
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {


    // ---------------------------------------------------------
    // Core & Compose (from version catalog)
    // ---------------------------------------------------------
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)

    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // ---------------------------------------------------------
    // Navigation
    // ---------------------------------------------------------
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.material.icons.extended)

    // ---------------------------------------------------------
    // Lifecycle + ViewModel
    // ---------------------------------------------------------
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.lifecycle.runtime.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)

    // ---------------------------------------------------------
    // Hilt DI (Using KSP)
    // ---------------------------------------------------------
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    // ---------------------------------------------------------
    // Room Database (Using KSP)
    // ---------------------------------------------------------
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    implementation(libs.androidx.room.paging)

    // ---------------------------------------------------------
    // Kotlin Coroutines
    // ---------------------------------------------------------
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // ---------------------------------------------------------
    // Kotlin Serialization
    // ---------------------------------------------------------
    implementation(libs.kotlinx.serialization.json)

    // ---------------------------------------------------------
    // Kotlin DateTime
    // ---------------------------------------------------------
    implementation(libs.kotlinx.datetime)

    // ---------------------------------------------------------
    // CSV Parsing
    // ---------------------------------------------------------
    implementation(libs.univocity.parsers)

    // ---------------------------------------------------------
    // Excel (.xlsx) support — Apache POI (with KSP compatible exclusions)
    // ---------------------------------------------------------
    implementation(libs.apache.poi) {
        exclude(group = "commons-logging", module = "commons-logging")
        exclude(group = "org.apache.commons", module = "commons-collections4")
    }
    implementation(libs.apache.poi.ooxml) {
        exclude(group = "org.apache.xmlbeans", module = "xmlbeans")
        exclude(group = "commons-logging", module = "commons-logging")
        exclude(group = "org.apache.commons", module = "commons-compress")
    }
    implementation(libs.apache.xmlbeans)
    implementation(libs.apache.commons.collections4)
    implementation(libs.apache.commons.compress)
    implementation(libs.commons.logging)

    // ---------------------------------------------------------
    // Encrypted local storage (updated for Kotlin 2.0)
    // ---------------------------------------------------------
    implementation(libs.androidx.security.crypto)
    implementation(libs.androidx.biometric)

    // ---------------------------------------------------------
    // Coil (updated version)
    // ---------------------------------------------------------
    implementation(libs.coil.compose)

    // ---------------------------------------------------------
    // Logging
    // ---------------------------------------------------------
    implementation(libs.timber)

    // ---------------------------------------------------------
    // Paging (for large datasets in ledger)
    // ---------------------------------------------------------
    implementation(libs.androidx.paging.runtime.ktx)
    implementation(libs.androidx.paging.compose)

    // ---------------------------------------------------------
    // Testing (from version catalog + additional)
    // ---------------------------------------------------------
    testImplementation(libs.junit)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.mockk)
    testImplementation(libs.turbine)
    testImplementation(libs.androidx.room.testing)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.hilt.android.testing)
    kspAndroidTest(libs.hilt.android.compiler)

    // For better Android testing
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.androidx.test.rules)
    androidTestImplementation(libs.androidx.test.core.ktx)
}