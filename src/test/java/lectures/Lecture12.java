package lectures;

import beans.Employee;

import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture12 {
  @Test
  public void understandingCollect() throws Exception {
    List<String> emails = MockData.getEmployee()
        .stream()
        .map(Employee::getEmail)
        .collect(Collectors.toList());

    emails.forEach(System.out::println);
  }
}
