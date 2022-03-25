package java8;

import java.util.stream.Stream;

/**
 * @create 2022-03-19 3:26
 */
public class Main {
    public static void main(String[] args) {
        streamTest();
    }

    private static void streamTest() {
        //use stream.of mathod
        Stream<String> streamOfStrings =  Stream.of("Sunday", "Monday", "Wednesday", "Friday");


        Stream<Integer> StreamOfInteger = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9);


        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Stream<Integer> streamOfArrayOfIntegers = Stream.of(array);

    }
}
