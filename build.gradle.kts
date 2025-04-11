plugins {
    id("java")
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

configurations {
    create("adoc")
}

dependencies {
    add("adoc", "io.micrometer:micrometer-docs-generator:latest.integration")
    implementation("io.micrometer:micrometer-docs-generator:latest.integration")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

//
val generateObservabilityDocs by tasks.registering(JavaExec::class) {
    mainClass.set("com.example.CustomDocsGeneratorCommand")
    classpath = configurations.getByName("adoc") + sourceSets.main.get().runtimeClasspath
    val conventionsTemplateFile = file("src/main/resources/conventions.adoc.hbs")
    val metricsTemplateFile = file("src/main/resources/metrics.adoc.hbs")
    val spansTemplateFile = file("src/main/resources/spans.adoc.hbs")
    args(
        project.layout.projectDirectory.asFile.absolutePath, // Input folder
        ".*",                         // Inclusion pattern
        project.layout.buildDirectory.get().asFile.absolutePath, // Output folder
        "--conventions-template=${conventionsTemplateFile.path}",
        "--metrics-template=${metricsTemplateFile.path}",
        "--spans-template=${spansTemplateFile.path}",
    )
}

tasks.test {
    useJUnitPlatform()
}