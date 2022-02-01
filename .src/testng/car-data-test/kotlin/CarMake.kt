import io.cucumber.java.en.Then;

import org.mockito.InjectMocks;
import org.testng.Assert;

import example.model.Car;
import example.service.*

class CarMake {
  @InjectMocks
  val service: CarService = CarServiceImpl();

  @Then("Car make should be test")
  fun checkMake() {
    val car = service.createCar();
    Assert.assertEquals(car.make, "test");
  }
}
