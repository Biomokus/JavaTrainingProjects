package combinatorpattern;

import java.time.LocalDate;

import static combinatorpattern.CustomerRegistrationValidator.*;

public class Main {

    public static void main(String[] args) {

        Customer customer = new Customer(
                    "Alice",
                    "alice@gmail.com",
                    "+36304579965",
                LocalDate.of(2019, 1,1)
        );

        //Without combinator pattern:
        CustomerValidatorService validatorService = new CustomerValidatorService();
        System.out.println(validatorService.isValid(customer));
        System.out.println();

        // Using combinator pattern:
        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAnAdult())
                .apply(customer);

        System.out.println(result);

        if(result != ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
}
