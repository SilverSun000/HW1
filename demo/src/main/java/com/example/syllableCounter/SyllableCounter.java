package com.example.syllableCounter;

public class SyllableCounter {

    public static int findSyllableCount(String string) {
        String str = string.toLowerCase();
        int syllCount = 0;
        int index = 0;
        boolean prevWasVowel = false;

        while (index < str.length()) {
            char letter = str.charAt(index);

            if (isVowel(letter, index, str)) {
                if (!prevWasVowel) {
                    syllCount++;
                    prevWasVowel = true;
                }
            } else {
                prevWasVowel = false;
            }
            index++;
        }

        // Silent 'e' handling: subtract syllable if last char is 'e' AND
        // previous char is NOT a vowel AND NOT "le" ending preceded by consonant
        if (str.endsWith("e") && str.length() > 2) {
            char beforeE = str.charAt(str.length() - 2);
            if (!isVowel(beforeE, str.length() - 2, str)) {
                // Check for "le" ending preceded by consonant to avoid subtracting syllable
                if (!(str.endsWith("le") && !isVowel(str.charAt(str.length() - 3), str.length() - 3, str))) {
                    syllCount--;
                }
            }
        }

        // Handle "le" ending preceded by consonant (e.g., "apple")
        if (str.length() > 2 && str.endsWith("le")) {
            char thirdLast = str.charAt(str.length() - 3);
            if (!isVowel(thirdLast, str.length() - 3, str)) {
                syllCount++;
            }
        }

        return Math.max(1, syllCount);
    }

    private static boolean isVowel(char letter, int index, String word) {
        if ("aeiou".indexOf(letter) >= 0) {
            return true;
        }

        // 'y' is a vowel only if not first char and surrounded by consonants
        if (letter == 'y') {
            if (index == 0) return false;
            char before = word.charAt(index - 1);
            char after = (index + 1 < word.length()) ? word.charAt(index + 1) : ' ';
            return !isVowel(before, index - 1, word) && !isVowel(after, index + 1, word);
        }

        return false;
    }
}
