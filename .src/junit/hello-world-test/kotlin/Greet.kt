import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.mockito.InjectMocks;
import org.junit.jupiter.api.Assertions;

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
    Assertions.assertEquals(res, greeting);
  }
}
