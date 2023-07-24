plugins {
    id("java")
}

group = "ru.sal4i"
version = "1.0"

dependencies {
    implementation(fileTree("lib"))
}

val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Main-Class"] = "ru.sal4i.scombinedjava.SCombinedJava"
    }
}