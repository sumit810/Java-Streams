package exercises;

import java.util.List;

import static Utilities.Utility.listOfNumbers;

public class IntegerQuestions {
    public static void main(String[] args) {

        List<Integer> numberList = listOfNumbers();
        System.out.println("Printing Cubes of All Odd Numbers");
        printCubesOfOddNumbers(numberList);
        System.out.println("Printing Square and Sum of All Numbers");
        printSquareAndSumOfEveryNumber(numberList);

    }

    private static void printSquareAndSumOfEveryNumber(List<Integer> numberList) {
        Integer reduce = numberList.stream()
                .map(element -> element * element)
                .reduce(0, Integer::sum);
        System.out.println(reduce);
    }

    private static void printCubesOfOddNumbers(List<Integer> numberList) {
        numberList.stream()
                .filter(odd -> odd %2 != 0)
                .map(x -> x * x * x)
                .forEach(System.out::println);

    }
}
