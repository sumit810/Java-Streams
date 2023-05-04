package Grouping;

import beans.Car;
import beans.Person;
import mockdata.MockData;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByDemo {
    public static void main(String[] args) throws IOException {
        List<Person> people = MockData.getPeople();
        Map<String, Long> females = people.stream()
                .filter(sex -> sex.getGender().equalsIgnoreCase("Female"))
                .collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));
        System.out.println("Total Number of Females are as ::" +females);

        Map<String, Long> males = people.stream()
                .filter(sex -> sex.getGender().equalsIgnoreCase("Male"))
                .collect(Collectors.groupingBy(Person::getGender, Collectors.counting()));
        System.out.println("Total Number of males are as ::" +males);

        Integer count =  people.stream()
                .filter(e -> e.getAge() < 50)
                .collect(Collectors.toList()).size();
        System.out.println("Total Number of people whose age is  less than 50 years old ::" +count);



    }



}
