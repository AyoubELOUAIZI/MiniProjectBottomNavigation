plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.miniprojectbottomnavigation"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.miniprojectbottomnavigation"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    //this one to avoid having an error when building the app may be we donot need it
    //but just keep it here for now //this is help to avoid the app to stop
    buildFeatures{
        dataBinding=true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation ("com.github.qamarelsafadi:CurvedBottomNavigation:0.1.3") //this is the dependency of the bottom navigation
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
//    also these dependencys to avoid some errors
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("androidx.activity:activity-ktx:1.8.1")
//    implementation ("androidx.fragment:fragment-ktx:1.6.2")

    implementation("androidx.core:core-splashscreen:1.0.1")  //this google dependency is for the splach screen
}