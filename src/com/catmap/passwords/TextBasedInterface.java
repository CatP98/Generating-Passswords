package com.catmap.passwords;

import java.util.Scanner;

public class TextBasedInterface implements UserInterface {

    private Scanner scanner;

    public TextBasedInterface(){
       this.scanner = new Scanner(System.in);
   }
    @Override
    public int getPasswordLength() {
        System.out.println("Please enter the Password length: ");
        return scanner.nextInt();
    }

    @Override
    public boolean useLowerCase() {
        System.out.println("Would you like the password to have lower case characters? (Y/N)");
        return scanner.next().equalsIgnoreCase("y");
    }

    @Override
    public boolean useUpperCase() {
        System.out.println("Would you like the password to have upper case characters? (Y/N)");
        return scanner.next().equalsIgnoreCase("y");
    }


    @Override
    public boolean useNumbers() {
        System.out.println("Would you like the password to have numerical characters? (Y/N)");
        return scanner.next().equalsIgnoreCase("y");
    }


    @Override
    public boolean useSymbols() {
        System.out.println("Would you like the password to have special characters? (Y/N)");
        return scanner.next().equalsIgnoreCase("y");
    }


    @Override
    public void displayPassword(String password) {
        System.out.println("Here is your password: " + password.toString());
    }
}
