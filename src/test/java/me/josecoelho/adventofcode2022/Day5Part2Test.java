package me.josecoelho.adventofcode2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day5Part2Test {

    @Test
    void test() {
        final String expectedResult = "MCD";
        final String result = Day5Part2.solve("inputs/day5.txt");
        Assertions.assertEquals(expectedResult, result);
    }
}