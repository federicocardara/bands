/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("buildlogic.java-library-conventions")
}

dependencies {
    implementation(project(":domain"))

    implementation("com.mysql:mysql-connector-j:8.3.0")
}
