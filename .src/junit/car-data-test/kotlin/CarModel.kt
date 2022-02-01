import io.cucumber.java.en.Then;

import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;

import example.model.Car;
import example.service.*

class CarModel {
  @InjectMocks
  val service: CarService = CarServiceImpl();

  @Then("Car model should be test")
  fun checkModel() {
    val car = service.createCar();
    Assertions.assertEquals(car.model, "test");
  }
}
