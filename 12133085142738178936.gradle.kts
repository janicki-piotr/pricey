plugins {
    kotlin("jvm") version "1.6.10"
    kotlin("plugin.allopen") version "1.6.10"
    id("io.quarkus")
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-rest-client-jackson")
    implementation("io.quarkus:quarkus-rest-client")
    implementation("io.quarkus:quarkus-qute")
    implementation("io.quarkus:quarkus-smallrye-openapi")
    implementation("io.quarkus:quarkus-kotlin")
    implementation("io.quarkus:quarkus-config-yaml")
    implementation("io.quarkus:quarkus-resteasy")
    implementation("io.quarkus:quarkus-resteasy-jackson")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("io.quarkus:quarkus-arc")

    // arrow Kt
    implementation(platform("io.arrow-kt:arrow-stack:1.0.1"))
    implementation("io.arrow-kt:arrow-core")

    // cqrs-kt
    implementation("pl.redny:cqrs-kt")

    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.rest-assured:rest-assured")
}

group = "pl.redny"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

allOpen {
    annotation("javax.ws.rs.Path")
    annotation("javax.enterprise.context.ApplicationScoped")
    annotation("io.quarkus.test.junit.QuarkusTest")
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_11.toString()
    kotlinOptions.javaParameters = true
}

repositories {
    maven {
        url = uri("https://maven.pkg.github.com/OWNER/REPOSITORY")
        credentials {
            username = project.findProperty("gpr.user") as String? ?: System.getenv("USERNAME")
            password = project.findProperty("gpr.key") as String? ?: System.getenv("TOKEN")
        }
    }
}

val quarkusDeployment by configurations.creating
dependencies {
quarkusDeployment("io.quarkus:quarkus-rest-client-jackson-deployment:2.6.1.Final")
quarkusDeployment("io.quarkus:quarkus-swagger-ui-deployment:2.6.1.Final")
quarkusDeployment("io.quarkus:quarkus-apache-httpclient-deployment:2.6.1.Final")
quarkusDeployment("io.quarkus:quarkus-jackson-deployment:2.6.1.Final")
quarkusDeployment("io.quarkus:quarkus-resteasy-jackson-deployment:2.6.1.Final")
quarkusDeployment("io.quarkus:quarkus-resteasy-server-common-deployment:2.6.1.Final")
quarkusDeployment("io.quarkus:quarkus-vertx-http-deployment:2.6.1.Final")
quarkusDeployment("io.quarkus:quarkus-vertx-deployment:2.6.1.Final")
quarkusDeployment("io.quarkus:quarkus-resteasy-deployment:2.6.1.Final")
quarkusDeployment("io.quarkus:quarkus-mutiny-deployment:2.6.1.Final")
quarkusDeployment("io.quarkus:quarkus-rest-client-deployment:2.6.1.Final")
quarkusDeployment("io.quarkus:quarkus-kotlin-deployment:2.6.1.Final")
quarkusDeployment("io.quarkus:quarkus-smallrye-context-propagation-deployment:2.6.1.Final")
quarkusDeployment("io.quarkus:quarkus-netty-deployment:2.6.1.Final")
quarkusDeployment("io.quarkus:quarkus-smallrye-openapi-deployment:2.6.1.Final")
quarkusDeployment("io.quarkus:quarkus-arc-deployment:2.6.1.Final")
quarkusDeployment("io.quarkus:quarkus-rest-client-config-deployment:2.6.1.Final")
quarkusDeployment("io.quarkus:quarkus-config-yaml-deployment:2.6.1.Final")
quarkusDeployment("io.quarkus:quarkus-qute-deployment:2.6.1.Final")
quarkusDeployment("io.quarkus:quarkus-resteasy-common-deployment:2.6.1.Final")
}
typealias PrintWriter = java.io.PrintWriter
typealias FileWriter = java.io.FileWriter
tasks.register("listQuarkusDependencies") {
    val writer = PrintWriter(FileWriter("C:\\Users\\pcpio\\AppData\\Local\\Temp\\1029467600710220810.txt"))
    quarkusDeployment.files.forEach { it -> writer.println(it) }
    val componentIds = quarkusDeployment.incoming.resolutionResult.allDependencies.map { (it as ResolvedDependencyResult).selected.id }
    val result = dependencies.createArtifactResolutionQuery()
        .forComponents(componentIds)
        .withArtifacts(JvmLibrary::class, SourcesArtifact::class)
        .execute()
    result.resolvedComponents.forEach { component ->
        val sources = component.getArtifacts(SourcesArtifact::class)
        sources.forEach { ar ->
            if (ar is ResolvedArtifactResult) {
                writer.println(ar.file)
            }
        }
    }
    writer.close()
}