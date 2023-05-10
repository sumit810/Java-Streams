package lectures;

import beans.Employee;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    List<Employee> people = MockData.getEmployee();
    // 1. Find people aged less or equal 18
    // 2. Then change implementation to find first 10 people
    List<Employee> youngPeople = Lists.newArrayList();
    int limit = 10;
    int counter = 0;
    for(Employee person : people){
      if(person.getAge() <= 18){
        counter++;
        if(counter == limit){
          break;
        }
        youngPeople.add(person);
      }
    }
    for(Employee young: youngPeople){
      System.out.println(young.getAge());
    }
  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Employee> people = MockData.getEmployee();
    people.stream()
            .filter(young -> young.getAge() <= 18)
            .limit(10)
            .collect(Collectors.toList())
            .forEach(System.out::println);
  }
}
