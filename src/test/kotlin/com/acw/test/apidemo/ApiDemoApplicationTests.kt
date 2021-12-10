package com.acw.test.apidemo

import com.acw.test.apidemo.model.Todo
import com.acw.test.apidemo.service.TodoService
import org.apache.commons.io.FileUtils
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.web.server.LocalServerPort
import org.springframework.test.context.ActiveProfiles
import java.io.File
import com.intuit.karate.Logger
import com.intuit.karate.Results
import com.intuit.karate.Runner
import net.masterthought.cucumber.Configuration
import net.masterthought.cucumber.ReportBuilder
import org.junit.jupiter.api.Assertions


@ActiveProfiles("test")
@SpringBootTest( webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiDemoApplicationTests {

	companion object {

		fun generateReport(karateOutputPath: String) {
			val jsonPaths = FileUtils.listFiles(File(karateOutputPath), arrayOf("json"), true).map(File::getAbsolutePath)
			val config = Configuration(File("build"),"Api Gateway unit Tests ")
			val reportBuilder = ReportBuilder(jsonPaths, config)
			reportBuilder.generateReports()
		}
	}

	private val logger: Logger = Logger()

	@LocalServerPort
	var port : Int = 0

	@Test
	fun runKarateTest() {
		logger.info("start karate tests")

		logger.info( port.toString())
		val results: Results = Runner
			.path("classpath:features")
			.outputCucumberJson(true)
			.debugMode(true)
			.tags("~@ignore")
			.karateEnv("unit")
			.systemProperty("local.server.port", port.toString())
			.parallel(1)
		generateReport(results.reportDir)
		Assertions.assertEquals(0, results.failCount, results.errorMessages)
	}

}