package com.catmap.passwords;

import java.util.Random;

public class PasswordGenerator {

    String generatePassword(int length, boolean useLowerCase, boolean useUpperCase,
                            boolean useNumbers, boolean useSpecialChars) {

        String lowercase = "abcdefghijkmlnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUWVYZ";
        String digits = "0123456789";
        String symbols = "!@#$%^&*()_-[]{}";

        Random rand = new Random();
        StringBuilder charOptions = new StringBuilder();

        if (useLowerCase) {
            charOptions.append(lowercase);
        }

        if (useUpperCase) {
            charOptions.append(upperCase);
        }

        if (useNumbers) {
            charOptions.append(digits);
        }

        if (useSpecialChars) {
            charOptions.append(symbols);
        }

        String allChars = charOptions.toString();

        boolean passwordIsValid = false;

        while (true) {

            StringBuilder password = new StringBuilder();
            for (int i = 0; i < length; i++) {
                char nextLetter = allChars.charAt(rand.nextInt(allChars.length()));
                password.append(nextLetter);
            }
            String pass = password.toString();

            passwordIsValid = true;

            if(useLowerCase && !hasOverlap(pass, lowercase)){
                passwordIsValid = false;
            }

            if(useUpperCase && !hasOverlap(pass, upperCase)){
                passwordIsValid = false;
            }

            if(useSpecialChars && !hasOverlap(pass, symbols)){
                passwordIsValid = false;
            }

            if(useNumbers && !hasOverlap(pass, digits)){
                passwordIsValid = false;
            }

            if(useLowerCase && !hasOverlap(pass, lowercase)){
                passwordIsValid = false;
            }
            if(passwordIsValid){
                return pass;
            }

            System.out.println("Password failed, pass: " + pass);
        }
    }

    private boolean hasOverlap(String s1, String s2){
        for(char c : s1.toCharArray()){
            if(s2.contains(String.valueOf(c))){
                return true;
            }
        }
        return false;
    }
}
