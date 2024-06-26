application {
  mainClass.set("com.dd.App")
}

dependencies {
  implementation("org.flywaydb:flyway-core:10.15.0")
  implementation("org.flywaydb:flyway-database-postgresql:10.15.0")
  implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:3.0.3")
  implementation("org.postgresql:postgresql:42.6.0")
  implementation("org.springframework.boot:spring-boot-starter-web:3.2.5")
  testImplementation("org.springframework.boot:spring-boot-starter-test:3.3.0")
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
