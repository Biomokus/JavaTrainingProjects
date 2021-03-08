package finalsection;

import java.util.function.Function;

public class Lambdas {

    public static void main(String[] args) {

        Function<String, String> nameUpperCase = name -> name.toUpperCase();

        Function<String, String> nameUpperCase2 = name -> {
            if(name.isBlank()) throw  new IllegalArgumentException("");
            return name.toUpperCase();
        };

        String upperCasedName = nameUpperCase2.apply("David");
        System.out.println(upperCasedName);
    }
}
