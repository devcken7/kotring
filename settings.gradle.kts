pluginManagement {
    repositories {
        gradlePluginPortal()
    }
    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace != null) {
                if (requested.id.namespace!!.startsWith("org.jetbrains.kotlin")) { // Kotlin
                    useVersion("1.3.31")
                }
                if (requested.id.namespace!!.startsWith("org.springframework")) { // Spring
                    useVersion("2.1.4.RELEASE")
                }
                if (requested.id.namespace!!.startsWith("io.spring")) {
                    useVersion("1.0.7.RELEASE")
                }
            }
        }
    }
}
rootProject.name = "kotring"
