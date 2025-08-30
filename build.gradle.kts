plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.4.9"
    id("io.spring.dependency-management") version "1.1.7"
    kotlin("plugin.jpa") version "1.9.25"
}

group = "kr.co"
version = "0.0.1-SNAPSHOT"
description = "spring-ai-test-rs"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

extra["springAiVersion"] = "1.0.0-M6"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Kotlin 지원
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    // 코루틴 의존성
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    // Spring AI 의존성
//    implementation 'org.springframework.ai:spring-ai-huggingface-spring-boot-
//    출처: https://bcuts.tistory.com/422 [Back to the Basics:티스토리]
    // Spring AI OpenAI 스타터
    implementation("org.springframework.ai:spring-ai-openai-spring-boot-starter")

    // Spring AI Hugging Face 스타터 (1.0.0-M6 버전 지정)
    implementation("org.springframework.ai:spring-ai-huggingface-spring-boot-starter:1.0.0-M6")
//    implementation("org.springframework.ai:spring-ai-starter-model-openai")

    // PDF 처리 라이브러리
    implementation("org.apache.pdfbox:pdfbox:2.0.27")

    // Swagger/OpenAPI 의존성
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

    // 로깅 라이브러리
    implementation("io.github.oshai:kotlin-logging:6.0.3")

    // 테스트 의존성
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

}

dependencyManagement {
    imports {
        mavenBom("org.springframework.ai:spring-ai-bom:${property("springAiVersion")}")
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
