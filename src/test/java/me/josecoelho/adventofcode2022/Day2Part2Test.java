package me.josecoelho.adventofcode2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day2Part2Test {

    @Test
    void test() {
        final int expectedResult = 12;
        int result = Day2Part2.solve("inputs/day2.txt");
        Assertions.assertEquals(expectedResult, result);
    }
}