plugins {
    kotlin("jvm") version "1.9.20"
    id("java")
}

group = "com.jwk"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${property("kotlin_version")}")

    implementation("io.ktor:ktor-server-core:${property("ktor_version")}")
    implementation("io.ktor:ktor-server-netty:${property("ktor_version")}")

    implementation("ch.qos.logback:logback-classic:${property("logback_version")}")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
