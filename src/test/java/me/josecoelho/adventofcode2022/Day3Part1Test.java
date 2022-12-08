package me.josecoelho.adventofcode2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day3Part1Test {

    @Test
    void test() {
        final int expectedResult = 157;
        int result = Day3Part1.solve("inputs/day3.txt");
        Assertions.assertEquals(expectedResult, result);
    }
}