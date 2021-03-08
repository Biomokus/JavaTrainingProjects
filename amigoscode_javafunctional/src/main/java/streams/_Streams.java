package streams;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

import static streams._Streams.Gender.*;

public class _Streams {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE),
                new Person("Bob", PREFER_NOT_TO_SAY)
        );

        people.stream()
                .map(person -> person.gender)
                .collect(Collectors.toSet())
                .forEach(System.out::println);

        System.out.println();

        Function<Person, String> personStringFunction = person -> person.name;
        ToIntFunction<String> length = s -> s.length();
        IntConsumer println = x -> System.out.println(x);

        people.stream()
                .map(personStringFunction)
                .mapToInt(length)
                .forEach(println);

        boolean containsOnlyFemales = people.stream().allMatch(person -> FEMALE.equals(person.gender));
        System.out.println(containsOnlyFemales);
    }

    static class Person{
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender{
        MALE,FEMALE, PREFER_NOT_TO_SAY
    }

}
