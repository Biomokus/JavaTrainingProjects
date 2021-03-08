package combinatorpattern;

import java.time.LocalDate;

public class Customer {

    private final String name;
    private final String email;
    private final String phoneNUmber;
    private final LocalDate dob;

    public Customer(String name, String email, String phoneNUmber, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.phoneNUmber = phoneNUmber;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNUmber() {
        return phoneNUmber;
    }

    public LocalDate getDob() {
        return dob;
    }
}
