package me.josecoelho.adventofcode2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day1Part2Test {

    @Test
    void test() {
        final int expectedResult = 45000;
        int result = Day1Part2.solve("inputs/day1.txt");
        Assertions.assertEquals(expectedResult, result);
    }
}