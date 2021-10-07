package example.micronaut

import io.micronaut.core.annotation.Introspected
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import net.logstash.logback.argument.StructuredArguments
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@Controller("/conferences") // <1>
class ConferenceController(private val conferenceService: ConferenceService) { // <2>

    private val logger: Logger = LoggerFactory.getLogger(ConferenceController::class.java)

    @Get("/random") // <3>
    fun randomConf(): Conference {
        logger.info("test", StructuredArguments.kv("foo", LogData("Test", "path", "test", "uri.host")))
        return conferenceService.randomConf() // <4>
    }
}

@Introspected
data class LogData(
    val userAgent: String?,
    val uri: String?,
    val args: String?,
    val host: String?
)
