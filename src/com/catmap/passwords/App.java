package com.catmap.passwords;

public class App {
    public static void main(String[] args) {
        UserInterface ui = new TextBasedInterface();

        int length = ui.getPasswordLength();
        boolean useLowerCase = ui.useLowerCase();
        boolean useUpperCase = ui.useUpperCase();
        boolean useNumers = ui.useNumbers();
        boolean useSymbols = ui.useSymbols();

        PasswordGenerator gen = new PasswordGenerator();
        String password = gen.generatePassword(length, useLowerCase, useUpperCase, useNumers, useSymbols);
        ui.displayPassword(password);
    }
}
