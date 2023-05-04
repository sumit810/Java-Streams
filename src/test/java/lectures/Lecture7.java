package lectures;


import beans.Car;
import beans.Person;
import mockdata.MockData;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.DoubleSummaryStatistics;
import java.util.List;

public class Lecture7 {

  @Test
  public void count() throws Exception {
    //counting number of females in our mockdata
    List<Person> people = MockData.getPeople();
    long count =  people.stream()
            .filter(person -> person.getGender().equals("Female"))
            .count();
    System.out.println("Total Number of female Person:: " +count);

  }

  @Test
  public void min() throws Exception {
    List<Car> cars = MockData.getCars();
    //find the minimum price of all the yellow cars
    double minPriceOfYellowCar = cars.stream()
            .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
            .mapToDouble(Car::getPrice)
            .min()
            .getAsDouble();
    System.out.println(minPriceOfYellowCar);

  }

  @Test
  public void max() throws Exception {
    List<Car> cars = MockData.getCars();
    //find the maximum price of all the yellow cars
    double maxPriceOfYellowCar = cars.stream()
            .filter(car -> car.getColor().equalsIgnoreCase("yellow"))
            .mapToDouble(Car::getPrice)
            .max()
            .getAsDouble();
    System.out.println(maxPriceOfYellowCar);

  }


  @Test
  public void average() throws Exception {
    List<Car> cars = MockData.getCars();
    double averagePrice = cars.stream()
            .mapToDouble(Car::getPrice)
            .average()
            .orElse(0);
    System.out.println(averagePrice);

  }

  @Test
  public void sum() throws Exception {
    List<Car> cars = MockData.getCars();
    double sum = cars.stream()
        .mapToDouble(Car::getPrice)
        .sum();
    BigDecimal bigDecimalSum = BigDecimal.valueOf(sum);
    System.out.println(sum);
    System.out.println(bigDecimalSum);

  }

  @Test
  public void statistics() throws Exception {
    List<Car> cars = MockData.getCars();
    DoubleSummaryStatistics statistics = cars.stream()
        .mapToDouble(Car::getPrice)
        .summaryStatistics();
    System.out.println(statistics);
    System.out.println(statistics.getAverage());
    System.out.println(statistics.getCount());
    System.out.println(statistics.getMax());
    System.out.println(statistics.getMin());
    System.out.println(statistics.getSum());
  }

}