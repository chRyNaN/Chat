import groovy.util.XmlParser
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

open class LicenseReporterTask : DefaultTask() {

    private val xmlParser = XmlParser(false, false)

    @TaskAction
    fun execute() {
        Dependencies.values().forEach {
            project.configurations.getByName("poms").dependencies.add(
                project.dependencies.add("poms", it.pom)
            )
        }

        project.configurations
            .getByName("poms")
            .resolvedConfiguration
            .lenientConfiguration
            .artifacts
            .forEach {
                val pomFile = it.file

                val node = xmlParser.parse(pomFile)
            }
    }
}