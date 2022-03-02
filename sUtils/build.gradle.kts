plugins {
    java
    `maven-publish`
}

group = "ru.sal4i"
version = "2.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(fileTree("lib"))
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.github.Sal4iDev"
            artifactId = "sUtils"
            version = "1.2"

            from(components["java"])
        }
    }
}