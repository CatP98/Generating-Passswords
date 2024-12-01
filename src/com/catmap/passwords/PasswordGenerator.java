package com.catmap.passwords;

import java.util.Random;

public class PasswordGenerator {

    String generatePassword(int length, boolean useLowerCase, boolean useUpperCase,
                            boolean useNumbers, boolean useSpecialChars) {

        final String LOWERCASE = "abcdefghijkmlnopqrstuvwxyz";
        final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUWVYZ";
        final String DIGITS = "0123456789";
        final String SYMBOLS = "!@#$%^&*()_-[]{}";

        Random rand = new Random();
        StringBuilder charOptions = new StringBuilder();

        // Build the character pool based on user preferences
        if (useLowerCase) charOptions.append(LOWERCASE);
        if (useUpperCase) charOptions.append(UPPERCASE);
        if (useNumbers) charOptions.append(DIGITS);
        if (useSpecialChars) charOptions.append(SYMBOLS);


        String allChars = charOptions.toString();

        while (true) {

            StringBuilder password = new StringBuilder();
            for (int i = 0; i < length; i++) {
                char nextLetter = allChars.charAt(rand.nextInt(allChars.length()));
                password.append(nextLetter);
            }
            String generatedPassword = password.toString();

            // Validate the password against the user’s specifications
            boolean isValid = true;
            if (useLowerCase && !hasCharOf(LOWERCASE, generatedPassword)) isValid = false;
            if (useUpperCase && !hasCharOf(UPPERCASE, generatedPassword)) isValid = false;
            if (useNumbers && !hasCharOf(DIGITS, generatedPassword)) isValid = false;
            if (useSpecialChars && !hasCharOf(SYMBOLS, generatedPassword)) isValid = false;

            if (isValid) return generatedPassword; // Return the password if valid
    }}

    private boolean hasOverlap(String s1, String s2){
        for(char c : s1.toCharArray()){
            if(s2.contains(String.valueOf(c))){
                return true;
            }
        }
        return false;
    }

    // Check if a string contains at least one character from a given set
    private boolean hasCharOf(String charSet, String password) {
        for (char c : charSet.toCharArray()) {
            if (password.indexOf(c) >= 0) { // Check if the password contains the character
                return true;
            }
        }
        return false;
    }
}

