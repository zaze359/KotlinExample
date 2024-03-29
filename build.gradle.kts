
plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "me.35963"
version = "1.0-SNAPSHOT"

repositories {
//    maven{
//        isAllowInsecureProtocol = true
//        url = uri("http://localhost:8081/repository/maven-public")
//    }
    if (extra.has("useLocalMaven") && (extra["useLocalMaven"] as String).toBoolean()) {
        maven {
            isAllowInsecureProtocol = true
            url = uri("http://localhost:8081/repository/maven-public")
        }
    }
    mavenLocal()
    maven(uri("https://maven.aliyun.com/repository/public"))
    maven(uri("https://maven.aliyun.com/repository/jcenter"))
    maven(uri("https://maven.aliyun.com/repository/google"))
    maven {
        url = uri("https://jitpack.io")
    }
    mavenCentral()
}

dependencies {
//    testImplementation(libs.junit4)
    testImplementation(kotlin("test"))
//    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
//    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.8.2")
//    testImplementation("org.jetbrains.kotlin:kotlin-test")
    implementation(group = "com.google.code.gson", name = "gson", version = "2.8.6")
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-stdlib", version = "1.8.0")
    implementation(group = "org.jetbrains.kotlinx", name = "kotlinx-coroutines-core", version = "1.4.2")
    implementation(group = "org.apache.commons", name = "commons-compress", version = "1.20")
    implementation(group = "org.jetbrains.kotlin", name = "kotlin-reflect", version = "1.3.61")
//    implementation(group = "org.tukaani", name = "xz", version = "1.9")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

//tasks.withType<KotlinCompile>() {
//    kotlinOptions.jvmTarget = "1.8"
//}

application {
    mainClass.set("MainKt")
}