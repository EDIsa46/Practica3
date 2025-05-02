package Cucumber;

import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.platform.suite.api.Suite;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.SelectPackages;

@Suite
@Cucumber
@SelectClasspathResource("Features")
@SelectPackages({"Prestamo.Cucumber"}) // Asegúrate de que coincida con tu paquete
class RunCucumberTestTDD {
}