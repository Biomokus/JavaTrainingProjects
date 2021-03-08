package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        System.out.println("Without Predicate:");
        System.out.println(isPhoneNumberValid("07000000000"));
        System.out.println(isPhoneNumberValid("0700000000"));
        System.out.println(isPhoneNumberValid("09003570000"));

        System.out.println("With Predicate:");
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("0700000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09003570000"));

        System.out.println("Is phone number valid and contains 3: " +
                isPhoneNumberValidPredicate.and(containsNumber3).test("07003570000"));

    }

    static boolean isPhoneNumberValid(String phoneNumber){
        return phoneNumber.startsWith("07") && phoneNumber.length() == 11;
    }

    static Predicate<String> isPhoneNumberValidPredicate = phoneNumber ->
            phoneNumber.startsWith("07") && phoneNumber.length() == 11;

    static Predicate<String> containsNumber3 = phoneNumber ->
            phoneNumber.contains("3");
}
