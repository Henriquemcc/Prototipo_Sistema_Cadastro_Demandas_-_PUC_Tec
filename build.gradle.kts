plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.3.4"
	id("io.spring.dependency-management") version "1.1.6"
	kotlin("plugin.noarg") version "2.0.20"
	kotlin("plugin.jpa") version "2.0.20"
}

group = "br.pucminas.puctec"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-maven-noarg:2.0.20")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa:3.4.0")
	implementation("org.springframework.boot:spring-boot-docker-compose:3.3.4")
	implementation("com.mysql:mysql-connector-j:9.0.0")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.flywaydb:flyway-core:11.1.0")
	implementation("org.flywaydb:flyway-mysql:11.1.0")
	implementation("org.springframework.boot:spring-boot-starter-cache:3.4.1")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.testcontainers:mysql:1.20.4")
	testImplementation("org.springframework.boot:spring-boot-testcontainers:3.3.4")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
