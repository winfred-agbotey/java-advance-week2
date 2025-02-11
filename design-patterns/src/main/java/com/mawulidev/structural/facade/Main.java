package com.mawulidev.structural.facade;

import com.mawulidev.structural.facade.example1.ShoppingCartFacade;
import com.mawulidev.structural.facade.example2.EmailFacade;

public class Main {
    public static void main(String[] args) {
        //Example 1
        ShoppingCartFacade cartFacade = new ShoppingCartFacade();
        cartFacade.addItem("Laptop", 1000);
        cartFacade.addItem("Mouse", 50);
        cartFacade.addItem("Keyboard", 80);
        cartFacade.addItem("Monitor", 300);
        cartFacade.checkout();

        //Example 2
        EmailFacade emailFacade = new EmailFacade();
        emailFacade.sendEmail("test@example.com", "Hello", "This is a test email.");
    }
}
