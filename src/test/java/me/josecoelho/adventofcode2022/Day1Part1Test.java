package me.josecoelho.adventofcode2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day1Part1Test {

    @Test
    void test() {
        final int expectedResult = 24000;
        int result = Day1Part1.solve("inputs/day1.txt");
        Assertions.assertEquals(expectedResult, result);
    }
}