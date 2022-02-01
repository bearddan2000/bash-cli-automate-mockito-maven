import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

class RunCucumberTest : AbstractTestNGCucumberTests() {

  @DataProvider(parallel = true)
  override fun scenarios(): Array<Array<Any>> = super.scenarios();
}
