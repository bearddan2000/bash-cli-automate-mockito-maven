import io.cucumber.java.en.Then;

import org.mockito.InjectMocks;
import org.testng.Assert;

import example.model.Car;
import example.service.*

class CarModel {

  @InjectMocks
  val service: CarService = CarServiceImpl();

  @Then("Car model should be test")
  fun checkModel() {
    val car = service.createCar();
     Assert.assertEquals(car.model, "test");
  }
}
