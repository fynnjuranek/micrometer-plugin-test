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
    add("adoc", "io.micrometer:micrometer-docs-generator:0.1.0-SNAPSHOT")
//    add("adoc", "io.micrometer:micrometer-docs-generator:1.0.0")
//    implementation("io.micrometer:micrometer-docs-generator:1.0.0")
    implementation("io.micrometer:micrometer-docs-generator:0.1.0-SNAPSHOT")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

//
val generateObservabilityDocs by tasks.registering(JavaExec::class) {
//    mainClass.set("com.example.CustomDocsGeneratorCommand")
    mainClass.set("io.micrometer.docs.DocsGeneratorCommand")
    classpath = configurations.getByName("adoc") + sourceSets.main.get().runtimeClasspath
//    classpath = configurations.getByName("adoc")
    val conventionsTemplateFile = file("src/main/resources/conventions.adoc.hbs")
    val metricsTemplateFile = file("src/main/resources/metrics.adoc.hbs")
    val spansTemplateFile = file("src/main/resources/spans.adoc.hbs")
    args(
        project.layout.projectDirectory.asFile.absolutePath, // Input folder
        ".*",                         // Inclusion pattern
        project.layout.buildDirectory.get().asFile.absolutePath, // Output folder
//        "--conventions-template=${conventionsTemplateFile.path}",
//        "--metrics-template=${metricsTemplateFile.path}",
//        "--spans-template=${spansTemplateFile.path}",
    )
}

tasks.test {
    useJUnitPlatform()
}