package me.josecoelho.adventofcode2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day6Part1Test {

    @Test
    void testCase1() {
        final int expectedResult = 7;
        final int result = Day6Part1.solve("inputs/day6_1.txt");
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void testCase2() {
        final int expectedResult = 5;
        final int result = Day6Part1.solve("inputs/day6_2.txt");
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void testCase3() {
        final int expectedResult = 6;
        final int result = Day6Part1.solve("inputs/day6_3.txt");
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void testCase4() {
        final int expectedResult = 10;
        final int result = Day6Part1.solve("inputs/day6_4.txt");
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void testCase5() {
        final int expectedResult = 11;
        final int result = Day6Part1.solve("inputs/day6_5.txt");
        Assertions.assertEquals(expectedResult, result);
    }
}