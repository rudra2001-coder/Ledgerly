plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.rudra.ledgerly"
    compileSdk {
        version = release(36)
    }

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
    implementation("androidx.navigation:navigation-compose:2.8.7")
    implementation("androidx.compose.material:material-icons-extended:1.6.7")

    // ---------------------------------------------------------
    // Lifecycle + ViewModel
    // ---------------------------------------------------------
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.3")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.3")

    // ---------------------------------------------------------
    // Hilt DI (Using KSP)
    // ---------------------------------------------------------
    implementation("com.google.dagger:hilt-android:2.51")
    ksp("com.google.dagger:hilt-android-compiler:2.51")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // ---------------------------------------------------------
    // Room Database (Using KSP)
    // ---------------------------------------------------------
    implementation("androidx.room:room-runtime:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    implementation("androidx.room:room-paging:2.6.1")

    // ---------------------------------------------------------
    // Kotlin Coroutines
    // ---------------------------------------------------------
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.2")

    // ---------------------------------------------------------
    // Kotlin Serialization
    // ---------------------------------------------------------
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.0")

    // ---------------------------------------------------------
    // Kotlin DateTime
    // ---------------------------------------------------------
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.6.0")

    // ---------------------------------------------------------
    // CSV Parsing
    // ---------------------------------------------------------
    implementation("com.univocity:univocity-parsers:2.9.1")

    // ---------------------------------------------------------
    // Excel (.xlsx) support — Apache POI (with KSP compatible exclusions)
    // ---------------------------------------------------------
    implementation("org.apache.poi:poi:5.3.0") {
        exclude(group = "commons-logging", module = "commons-logging")
        exclude(group = "org.apache.commons", module = "commons-collections4")
    }
    implementation("org.apache.poi:poi-ooxml:5.3.0") {
        exclude(group = "org.apache.xmlbeans", module = "xmlbeans")
        exclude(group = "commons-logging", module = "commons-logging")
        exclude(group = "org.apache.commons", module = "commons-compress")
    }
    implementation("org.apache.xmlbeans:xmlbeans:5.2.0")
    implementation("org.apache.commons:commons-collections4:4.4")
    implementation("org.apache.commons:commons-compress:1.26.0")
    implementation("commons-logging:commons-logging:1.3.0")

    // ---------------------------------------------------------
    // Encrypted local storage (updated for Kotlin 2.0)
    // ---------------------------------------------------------
    implementation("androidx.security:security-crypto:1.1.0")
    implementation("androidx.biometric:biometric-ktx:1.2.0-alpha05")

    // ---------------------------------------------------------
    // Coil (updated version)
    // ---------------------------------------------------------
    implementation("io.coil-kt:coil-compose:2.6.0")

    // ---------------------------------------------------------
    // Logging
    // ---------------------------------------------------------
    implementation("com.jakewharton.timber:timber:5.0.1")

    // ---------------------------------------------------------
    // Paging (for large datasets in ledger)
    // ---------------------------------------------------------
    implementation("androidx.paging:paging-runtime-ktx:3.3.0")
    implementation("androidx.paging:paging-compose:3.3.0")

    // ---------------------------------------------------------
    // Testing (from version catalog + additional)
    // ---------------------------------------------------------
    testImplementation(libs.junit)
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.2")
    testImplementation("io.mockk:mockk:1.13.11")
    testImplementation("app.cash.turbine:turbine:1.1.0")
    testImplementation("androidx.room:room-testing:2.6.1")

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation("com.google.dagger:hilt-android-testing:2.51")
    kspAndroidTest("com.google.dagger:hilt-android-compiler:2.51")

    // For better Android testing
    androidTestImplementation("androidx.test:runner:1.5.2")
    androidTestImplementation("androidx.test:rules:1.5.0")
    androidTestImplementation("androidx.test:core-ktx:1.5.0")

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
}