package me.josecoelho.adventofcode2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day3Part2Test {

    @Test
    void test() {
        final int expectedResult = 70;
        int result = Day3Part2.solve("inputs/day3.txt");
        Assertions.assertEquals(expectedResult, result);
    }
}