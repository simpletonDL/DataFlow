import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    application
    antlr
}

group = "me.user"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    antlr("org.antlr:antlr4:4.9.3")
    testImplementation(kotlin("test"))
    implementation("org.apache.commons:commons-csv:1.5")
    implementation("org.apache.commons:commons-io:1.3.2")
    implementation("org.apache.commons:commons-lang3:3.0")
    implementation("guru.nidi:graphviz-kotlin:0.18.0")
}

tasks.test {
    useJUnit()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

tasks.generateGrammarSource {
    arguments = listOf("-lib", "src/main/antlr")
    outputDirectory = File("src/main/java/ru/itmo/mse/dataflow/lang")
}