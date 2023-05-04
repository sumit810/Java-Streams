package lectures;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String joiningStrings = "";
    for(String name: names){
      joiningStrings += name + ", ";
    }
    System.out.println(joiningStrings.substring(0, joiningStrings.length()-2));

  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    String joining = names.stream()
            .collect(Collectors.joining(","));
    System.out.println(joining);

  }
}
