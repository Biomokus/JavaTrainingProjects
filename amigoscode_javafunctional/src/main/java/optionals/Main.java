package optionals;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Object value = Optional.ofNullable("Value")
                .orElseGet(() -> "default value");

        Object value2 = Optional.ofNullable("Hello")
                .orElseThrow(() -> new IllegalStateException("exception"));

        Optional.ofNullable("john@gmail.com")
                .ifPresent(email -> System.out.println("Sending email to " + email + "."));

        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("Sending email to " + email + "."),
                        ()-> System.out.println("Cannot send email."));

        System.out.println(value);
        System.out.println(value2);
    }
}
