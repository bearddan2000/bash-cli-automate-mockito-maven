import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.mockito.InjectMocks;

import example.model.Car;
import example.service.*

class CarYear {
  @InjectMocks
  val service: CarService = CarServiceImpl();

  @Then("Car year should be 0")
  fun checkYear() {
    val car = service.createCar();
    Assertions.assertEquals(car.year, 0);
  }
}
