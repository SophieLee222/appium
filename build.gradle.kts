plugins {
    id("java")
}

group = "ru.netology"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.appium:java-client:8.5.1")
    testImplementation("org.seleniumhq.selenium:selenium-java:4.12.1")
}

tasks.test {
    useJUnitPlatform()
}