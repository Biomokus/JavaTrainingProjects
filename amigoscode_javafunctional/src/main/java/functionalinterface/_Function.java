package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {

        // Function (takes 1 argument and gives 1 result):
        int increment = incrementByOne(0);
        System.out.println(increment);

        int increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        int multiply = multiplyBy10Function.apply(increment2);
        System.out.println(multiply);

        Function<Integer, Integer> addByOneThenMultiplyBy10 = incrementByOneFunction.andThen(multiplyBy10Function);
        System.out.println(addByOneThenMultiplyBy10.apply(7));

        // BiFunction (takes 2 arguments and gives 1 result):
        System.out.println(incrementByOneAndMultiply(4, 100));
        System.out.println(incrementByOneAndMultiplyBiFunction.apply(4, 100));

    }

    static int incrementByOne(int number){
        return number + 1;
    }

    static int incrementByOneAndMultiply(int number, int numMultiplyBy){
        return (number + 1) * numMultiplyBy;
    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;
    static Function<Integer, Integer> multiplyBy10Function = number -> number * 10;

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) -> (numberToIncrementByOne + 1) * numberToMultiplyBy;


}
