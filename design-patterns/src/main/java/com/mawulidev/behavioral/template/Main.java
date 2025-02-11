package com.mawulidev.behavioral.template;

import com.mawulidev.behavioral.template.example1.DomesticOrder;
import com.mawulidev.behavioral.template.example1.InternationalOrder;
import com.mawulidev.behavioral.template.example1.OrderProcessor;
import com.mawulidev.behavioral.template.example2.DataValidator;
import com.mawulidev.behavioral.template.example2.EmailValidator;
import com.mawulidev.behavioral.template.example2.PhoneNumberValidator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Processing Domestic Order:");
        OrderProcessor domesticOrder = new DomesticOrder();
        domesticOrder.processOrder();

        System.out.println("\nProcessing International Order:");
        OrderProcessor internationalOrder = new InternationalOrder();
        internationalOrder.processOrder();


        //Example 2
        DataValidator emailValidator = new EmailValidator();
        emailValidator.validate("test@example.com");
        emailValidator.validate("invalid-email");

        DataValidator phoneValidator = new PhoneNumberValidator();
        phoneValidator.validate("+1234567890");
        phoneValidator.validate("invalid-phone");
    }
}
