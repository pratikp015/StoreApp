package com.abcshopapp.main;

import java.time.LocalDate;
import java.time.Period;
import java.time.LocalDateTime;
import java.time.Month;

public class DateTimeDemo {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println("Today's Date: " + today);

        LocalDate dob = LocalDate.of(2001, Month.OCTOBER, 30);
        System.out.println("DOB: " + dob);

        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + dateTime);

        // Calculate the age
        Period age = Period.between(dob, today);
        System.out.println("Age: " + age.getYears() + " years, " + age.getMonths() + " months, " + age.getDays() + " days");

        // Additional Date Manipulation
        LocalDate afterDays = today.plusDays(35);
        System.out.println("Date after 35 days: " + afterDays);
    }
}
