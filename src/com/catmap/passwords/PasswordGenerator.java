package com.catmap.passwords;

import java.util.Random;

public class PasswordGenerator {

    String generatePassword(int length, boolean useLowerCase, boolean useUpperCase,
                            boolean useNumbers, boolean useSpecialChars){

        String lowercase = "abcdefghijkmlnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUWVYZ";
        String digits = "0123456789";
        String symbols = "!@#$%^&*()_-[]{}";

        StringBuilder charOptions = new StringBuilder();
        StringBuilder password = new StringBuilder();
        Random rand = new Random();

        if(useLowerCase){
            charOptions.append(lowercase);
        }

        if( useUpperCase){
            charOptions.append(upperCase);
        }

        if (useNumbers) {
            charOptions.append(digits);
        }

        if (useSpecialChars) {
            charOptions.append(symbols);
        }

        String allChars = charOptions.toString();

        for(int i = 0; i < length; i++){
            char nextLetter = allChars.charAt(rand.nextInt(allChars.length()));
            password.append(nextLetter);
        }
        return password.toString();
    }
}
