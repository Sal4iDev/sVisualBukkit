plugins {
    java
}

group = "ru.sal4i"
version = "1.2"

repositories {
    mavenCentral()
}

dependencies {
    implementation(files("C:/Users/1/Desktop/IDEA Projects/sVisualBukkit-Projects/lib/VisualBukkit-5.1.1.jar"))
}

val jar by tasks.getting(Jar::class) {
    manifest {
        attributes["Main-Class"] = "ru.sal4i.supdatechecker.SUpdateChecker"
    }
}