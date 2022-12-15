val activityComposeVersion by extra("1.6.1")
val roomVersion by extra("2.4.3")
val composeVersion by extra("1.3.1")
val daggerHiltVersion by extra("2.44.2")
val coreKtxVersion by extra("1.9.0")
val espressoCoreVersion by extra("3.5.0")
val lifecycleRuntimeKtxVersion by extra("2.5.1")
val kotlinxCoroutinesTestVersion by extra("1.6.4")
val junitVersion by extra("4.13.2")
val hiltVersion by extra("1.0.0")
val hiltLifecycleViewmodelVersion by extra("1.0.0-alpha03")
val junitJupiterVersion by extra("5.9.1")
val kotestAssertionsCoreVersion by extra("5.5.4")
val mockitoKotlinVersion by extra("4.1.0")
val navigationComposeVersion by extra("2.5.3")

buildscript {
    dependencies {
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.40.5")
    }
}

plugins {
    id ("com.android.application") version "7.3.1" apply false
    id ("com.android.library") version "7.3.1" apply false
    id ("org.jetbrains.kotlin.android") version "1.6.10" apply false
}