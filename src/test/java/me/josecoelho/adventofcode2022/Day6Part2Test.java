package me.josecoelho.adventofcode2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day6Part2Test {

    @Test
    void testCase1() {
        final int expectedResult = 19;
        final int result = Day6Part2.solve("inputs/day6_1.txt");
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void testCase2() {
        final int expectedResult = 23;
        final int result = Day6Part2.solve("inputs/day6_2.txt");
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void testCase3() {
        final int expectedResult = 23;
        final int result = Day6Part2.solve("inputs/day6_3.txt");
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void testCase4() {
        final int expectedResult = 29;
        final int result = Day6Part2.solve("inputs/day6_4.txt");
        Assertions.assertEquals(expectedResult, result);
    }

    @Test
    void testCase5() {
        final int expectedResult = 26;
        final int result = Day6Part2.solve("inputs/day6_5.txt");
        Assertions.assertEquals(expectedResult, result);
    }
}