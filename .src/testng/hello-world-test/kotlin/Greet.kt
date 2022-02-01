import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.testng.Assert;

import org.mockito.InjectMocks;
import example.service.*

class Greet {

  @InjectMocks
  val service: GreetService = GreetServiceImpl()

  @When("say")
  fun createGreeting() {
    println("say something")
  }

  @Then("^greeting should be (.*)$")
  fun checkGreeting(greeting: String) {
    val res = service.say();
    Assert.assertEquals(res, greeting);
  }
}
