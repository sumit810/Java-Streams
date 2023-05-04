package exercises;

import Utilities.Utility;

import java.util.List;

public class StringQuestions {
    public static void main(String[] args) {

        List<String> courses = Utility.listOfCourses();
        System.out.println("Courses with named as 'Spring");
        findCourseWithSpring(courses);
        System.out.println("Courses with named more than four letters");
        findCoursesWithAtleastFourLetters(courses);
        System.out.println("Length of each course");
        printLengthOfEachCourseName(courses);
    }

    private static void printLengthOfEachCourseName(List<String> courses) {
        courses.stream()
                .map(course -> course + " -> " +course.length())
                .forEach(System.out::println);

    }

    private static void findCoursesWithAtleastFourLetters(List<String> courses) {
        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

    private static void findCourseWithSpring(List<String> courses) {
        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);
    }
}
