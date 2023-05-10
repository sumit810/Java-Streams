package Grouping;

import beans.Employee;
import mockdata.MockData;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupingByDemo {
    public static void main(String[] args) throws IOException {
        List<Employee> employee = MockData.getEmployee();
        Map<String, Long> females = employee.stream()
                .filter(sex -> sex.getGender().equalsIgnoreCase("Female"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Total Number of Females are as ::" +females);

        Map<String, Long> males = employee.stream()
                .filter(sex -> sex.getGender().equalsIgnoreCase("Male"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Total Number of males are as ::" +males);

        Integer count =  employee.stream()
                .filter(e -> e.getAge() < 50)
                .collect(Collectors.toList()).size();
        System.out.println("Total Number of people whose age is  less than 50 years old ::" +count);

        //Real Time Queries on People data
        /*
        Q1. How many male and female employees are there is the organization?
         */
        Map<String, Long> noOfMaleAndFemaleEmployees = employee.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("Males and females employees in the Organization" + noOfMaleAndFemaleEmployees);

        /*
        Q2. Print the name of all departments in the organization?
         */
        System.out.println("Name of all the departments in the Organization");
        employee.stream()
                .map(Employee::getDepartment)
                .distinct()
                .forEach(System.out::println);

        /*
        Q3. What is the average age of male and female employees?
         */
        Map<String, Double> avgAgeOfMaleAndFemaleEmployees = employee.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        System.out.println("Average age of male and female employees" +avgAgeOfMaleAndFemaleEmployees);

        /*
        Q4. Get the details of highest paid employee in the organization?
         */
        Optional<Employee> highestPaidEmployee = employee.stream()
                .collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        System.out.println("Highest Paid employee:: " +highestPaidEmployee);

        /*
        Q5. Get the names of all employees who have joined after 2015?
         */
        System.out.println("Get the names of all employees who have joined after 2015");
        employee.stream()
                .filter(element -> element.getYearOfJoining() > 2015)
                .map(Employee::getFirstName)
                .forEach(System.out::println);

        /*
        Q6. Count the number of employees in each department?
         */
        Map<String, Long> noOfEmployees = employee.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Number of employees in each department:: " +noOfEmployees);

        /*
        Q7. What is the average salary of each department?
         */
        Map<String, Double> averSalaryDepartment = employee.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("Average salary of each department" +averSalaryDepartment);

    }



}
