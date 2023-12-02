pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
//        this line is for the process of adding the dependency
        maven (url ="https://jitpack.io")
    }
}

rootProject.name = "MiniProjectBottomNavigation"
include(":app")
 