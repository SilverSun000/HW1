package com.syllableCounterTest;

import com.example.syllableCounter.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SyllableCounterTest {

    @Test
    public void testSimpleWords() {
        assertEquals(1, SyllableCounter.findSyllableCount("Sky"));
        assertEquals(1, SyllableCounter.findSyllableCount("Rhythm"));
        assertEquals(1, SyllableCounter.findSyllableCount("Book"));
        assertEquals(2, SyllableCounter.findSyllableCount("Apple"));
        assertEquals(2, SyllableCounter.findSyllableCount("Happy"));
    }

    @Test
    public void testMediumWords() {
        assertEquals(2, SyllableCounter.findSyllableCount("Open"));
        assertEquals(3, SyllableCounter.findSyllableCount("Animal"));
        assertEquals(3, SyllableCounter.findSyllableCount("Chocolate"));
        assertEquals(3, SyllableCounter.findSyllableCount("Computer"));
        assertEquals(4, SyllableCounter.findSyllableCount("Celebration"));
    }

    @Test
    public void testFourSyllableWords() {
        assertEquals(4, SyllableCounter.findSyllableCount("Voluntary"));
        assertEquals(4, SyllableCounter.findSyllableCount("California"));
    }

    @Test
    public void testFiveSyllableWords() {
        assertEquals(5, SyllableCounter.findSyllableCount("Incomparable"));
        assertEquals(5, SyllableCounter.findSyllableCount("Opportunity"));
        assertEquals(5, SyllableCounter.findSyllableCount("Misunderstanding"));
    }

    @Test
    public void testSixOrMoreSyllables() {
        assertEquals(6, SyllableCounter.findSyllableCount("Unintentionally"));
        assertEquals(6, SyllableCounter.findSyllableCount("Misinterpretation"));
        assertEquals(6, SyllableCounter.findSyllableCount("Incomprehensible"));
        assertEquals(6, SyllableCounter.findSyllableCount("Disproportionately"));
        assertEquals(7, SyllableCounter.findSyllableCount("Unconstitutionalities"));
        assertEquals(7, SyllableCounter.findSyllableCount("Incomprehensibility"));
        assertEquals(7, SyllableCounter.findSyllableCount("Internationalization"));
        assertEquals(11, SyllableCounter.findSyllableCount("Antidisestablishmentarianism"));
    }
}
