dependencies {
  testImplementation("org.junit.jupiter:junit-jupiter:5.10.1")
  testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(21))
  }
}

plugins {
  application
}

repositories {
  mavenCentral()
}

tasks.named<Test>("test") {
  useJUnitPlatform()
}
