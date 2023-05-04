package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.internal.bind.util.ISO8601Utils;
import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    // 1. Find people aged less or equal 18
    // 2. Then change implementation to find first 10 people
    List<Person> youngPeople = Lists.newArrayList();
    int limit = 10;
    int counter = 0;
    for(Person person : people){
      if(person.getAge() <= 18){
        counter++;
        if(counter == limit){
          break;
        }
        youngPeople.add(person);
      }
    }
    for(Person young: youngPeople){
      System.out.println(young.getAge());
    }
  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();
    people.stream()
            .filter(young -> young.getAge() <= 18)
            .limit(10)
            .collect(Collectors.toList())
            .forEach(System.out::println);
  }
}
