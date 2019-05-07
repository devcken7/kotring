import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val spockVersion = "1.3-groovy-2.5"
val spekVersion = "2.0.3"

plugins {
    kotlin("jvm")
    kotlin("kapt")
    kotlin("plugin.noarg")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
    id("groovy")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    id("org.asciidoctor.convert") version "1.5.3"
    id("org.flywaydb.flyway") version "5.2.4"
    id("org.hibernate.gradle.tools") version "1.2.5"
}

group = "io.devcken"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))

    implementation("org.springframework.boot:spring-boot-starter-web")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.data:spring-data-envers:2.1.7.RELEASE")
    implementation("com.querydsl:querydsl-jpa")
    kapt("com.querydsl:querydsl-apt:4.2.1:jpa")
    runtime("mysql:mysql-connector-java")

    implementation("org.springframework.boot:spring-boot-starter-security")

    implementation("org.springframework.security.oauth.boot:spring-security-oauth2-autoconfigure:2.0.0.RELEASE")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    testImplementation("org.spekframework.spek2:spek-dsl-jvm:$spekVersion")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:$spekVersion")
    testImplementation("com.nhaarman.mockitokotlin2:mockito-kotlin:2.1.0")
    testImplementation("io.strikt:strikt-core:0.20.0")

    testImplementation("org.spockframework:spock-core:$spockVersion")
    testImplementation("org.spockframework:spock-spring:$spockVersion")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.security:spring-security-test")
    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
    testImplementation("org.flywaydb:flyway-core")
    testImplementation("com.h2database:h2")
    testRuntime("org.codehaus.groovy:groovy")
}

val snippetsDir = file("build/generated-snippets")

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }

    test {
        outputs.dir(snippetsDir)

        useJUnit {
            excludeCategories("io.devcken.kotring.spock.IntegrationSpec")
        }

//        useJUnitPlatform {
//            includeEngines("spek2")
//        }
    }

    val integrationTest by creating(Test::class) {
        group = "verification"
        useJUnit {
            includeCategories("io.devcken.kotring.spock.IntegrationSpec")
        }
    }

    asciidoctor {
        inputs.dir(snippetsDir)
        dependsOn(test)
    }

    flyway {
        val flywayUrl: String? by project
        val flywayUsername: String? by project
        val flywayPassword: String? by project

        driver = "com.mysql.cj.jdbc.Driver"
        url = flywayUrl ?: "jdbc:mysql://localhost:3306/kotring?serverTimezone=UTC"
        user = flywayUsername ?: "kotring"
        password = flywayPassword ?: "kotring"
        locations = arrayOf("classpath:db/migration", "classpath:db/data")
    }

    wrapper {
        gradleVersion = "5.2.1"
        distributionType = Wrapper.DistributionType.ALL
    }
}