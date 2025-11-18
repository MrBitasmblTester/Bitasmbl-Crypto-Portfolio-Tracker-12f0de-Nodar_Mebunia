plugins { kotlin("jvm") version "1.8.0"; application }
repositories { mavenCentral() }
dependencies {
  implementation("io.ktor:ktor-server-core:2.3.0")
  implementation("io.ktor:ktor-server-netty:2.3.0")
  implementation("io.ktor:ktor-client-core:2.3.0")
  implementation("org.jetbrains.exposed:exposed-core:0.41.1")
}
application { mainClass.set("io.crypto.ApplicationKt") }