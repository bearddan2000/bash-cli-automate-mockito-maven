import io.cucumber.java.en.Then;

import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;

import example.model.Car;
import example.service.*

class CarMake {
  @InjectMocks
  val service: CarService = CarServiceImpl();

  @Then("Car make should be test")
  fun checkMake() {
    val car = service.createCar();
    Assertions.assertEquals(car.make, "test");
  }
}
