plugins {
    `java-library`
    `maven-publish`
}

group = "net.adriantodt"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.kohlschutter.junixsocket:junixsocket-common:2.0.4")
    implementation("com.kohlschutter.junixsocket:junixsocket-native-common:2.0.4")
}

publishing {
    publications {
        create<MavenPublication>("myLibrary") {
            from(components["java"])
        }
    }

    repositories {
        mavenLocal()
    }
}
