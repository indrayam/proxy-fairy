plugins {
    id("org.springframework.boot") version "2.4.0"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    java
}

group = "me.anandsharma"
version = "1.0"
java.sourceCompatibility = JavaVersion.VERSION_11

val theMain by extra("${group}.SpringBootMain")

repositories {
    jcenter()
}

dependencies {
    // Bootiful stuff...
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.aspectj:aspectjweaver:1.9.6")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // Infra...
    implementation("ch.qos.logback:logback-classic:1.2.3")
    compileOnly("org.projectlombok:lombok:1.18.16")
    annotationProcessor("org.projectlombok:lombok:1.18.16")
    testCompileOnly("org.projectlombok:lombok:1.18.16")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.16")

    // Unit Tests...
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.getByName<org.springframework.boot.gradle.tasks.run.BootRun>("bootRun") {
    main = theMain
    args = listOf("foo", "bar")
    // isOptimizedLaunch = false
}