package lectures;


import beans.Car;
import beans.Employee;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    List<Car> carList = cars.stream()
            .filter(car -> car.getPrice() < 20000)
            .collect(Collectors.toList());
    carList.forEach(System.out::println);
    System.out.println(carList.size());

  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Employee> people = MockData.getEmployee();

  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    ImmutableList<Car> cars = MockData.getCars();
    double averagePrice = cars.stream()
            .mapToDouble(Car :: getPrice)
            .average()
            .orElse(0);
    System.out.println(averagePrice);

  }

  @Test
  public void test() throws Exception {

  }
}



