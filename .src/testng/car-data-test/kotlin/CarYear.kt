import org.mockito.InjectMocks;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import example.model.Car;
import example.service.*

class CarYear {
  @InjectMocks
  val service: CarService = CarServiceImpl();

  @Then("Car year should be 0")
  fun checkYear() {
    val car = service.createCar();
     Assert.assertEquals(car.year, 0);
  }
}
