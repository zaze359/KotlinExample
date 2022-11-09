import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.21"
}

group = "me.35963"
version = "1.0-SNAPSHOT"

repositories {
    maven(uri("https://maven.aliyun.com/repository/public"))
    maven(uri("https://maven.aliyun.com/repository/jcenter"))
    maven(uri("https://maven.aliyun.com/repository/google"))
    maven {
        url = uri("https://jitpack.io")
    }
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("com.google.code.gson:gson:2.8.6")
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-stdlib", version = "1.5.21")
    implementation(group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-core", version = "1.4.2")
    implementation(group = "org.apache.commons", name = "commons-compress", version = "1.20")
//    implementation(group = "org.tukaani", name = "xz", version = "1.9")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}