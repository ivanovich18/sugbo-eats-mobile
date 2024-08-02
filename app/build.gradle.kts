plugins {
    alias(libs.plugins.androidApplication)
    id("com.google.gms.google-services")
}

android {
    namespace = "com.bscpe3g.sugboeats"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.bscpe3g.sugboeats"
        minSdk = 24
        targetSdk = 34
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

    // Custom task to replace tokens in google-services-template.json
    task replaceGoogleServicesJson {
        doLast {
            def templateFile = file('google-services-template.json')
            def outputFile = file('google-services.json')

            ant.filterset(id: 'tokens', tokens: [
                'FIREBASE_PROJECT_NUMBER': System.getenv("FIREBASE_PROJECT_NUMBER"),
                'FIREBASE_PROJECT_ID': System.getenv("FIREBASE_PROJECT_ID"),
                'FIREBASE_STORAGE_BUCKET': System.getenv("FIREBASE_STORAGE_BUCKET"),
                'FIREBASE_APP_ID': System.getenv("FIREBASE_APP_ID"),
                'FIREBASE_CLIENT_ID': System.getenv("FIREBASE_CLIENT_ID"),
                'FIREBASE_API_KEY': System.getenv("FIREBASE_API_KEY")
            ])

            ant.copy(file: templateFile, tofile: outputFile) {
                filterchain {
                    filterset(refid: 'tokens')
                }
            }
        }
    }

    preBuild.dependsOn replaceGoogleServicesJson
}

dependencies {
    implementation 'io.github.cdimascio:java-dotenv:5.2.2'
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.firebase.auth)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
