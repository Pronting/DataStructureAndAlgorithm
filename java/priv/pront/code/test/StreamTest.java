package priv.pront.code.test;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        String[] array = {"a", "b", "c"};
        List<List<String>> nestedList = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("c", "d"));
//        nestedList.stream().flatMap(Collection::stream).forEach(System.out::print);
        List<Person> people = Arrays.asList(
                new Person("Alice", 30, "New York"),
                new Person("Bob", 25, "London"),
                new Person("Charlie", 30, "New York"),
                new Person("David", 35, "London"),
                new Person("Eve", 25, "Paris")
        );
//        Map<Integer, Long> collect = people.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.counting()));
//        people.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.toSet()));
//        people.stream().collect(Collectors.groupingBy(Person::getAge, Collectors.averagingInt(Person::getAge)));
        Map<String, Map<Integer, List<Person>>> collect = people.stream().collect(Collectors.groupingBy(Person::getCity, Collectors.groupingBy(Person::getAge)));

    }
}
