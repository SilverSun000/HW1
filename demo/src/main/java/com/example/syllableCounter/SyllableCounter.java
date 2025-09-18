package com.example.syllableCounter;

public class SyllableCounter {

    public static int findSyllableCount(String word) {
        word = word.toLowerCase();
        int syllables = 0;
        boolean lastCharWasVowel = false;
        String vowels = "aeiouy";

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (vowels.indexOf(c) != -1) { // If current char is a vowel
                if (!lastCharWasVowel) { // And the previous char was not a vowel
                    syllables++;
                }
                lastCharWasVowel = true;
            } else {
                lastCharWasVowel = false;
            }
        }
        //Bunch of rules for the more uncommon word syllables combos
        // Adjust for silent 'e' at the end of the word
        if (word.endsWith("e") && !word.endsWith("le") && syllables > 1) {
            syllables--;
        }
        // Handle words with no vowels (e.g., "rhythm")
        if (syllables == 0 && word.length() > 0) {
            syllables = 1;
        }
        // Ignore terminal 'ely' and count as 1 syllable
        if (word.endsWith("ely") && syllables > 1) {
            syllables--;
        }
        // Adjust for "-ities" suffix which can overcount syllables
        if (word.endsWith("ities") && syllables > 1) {
            syllables--;
        }
        // Adjust for "-ility" suffix which can overcount syllables
        if (word.endsWith("ility") && syllables > 1) {
        syllables--;
        }
        // Adjust for "-ization" suffix
        if (word.endsWith("ization") && syllables > 1) {
            syllables--;
        }
        
        return syllables;
    }
}
