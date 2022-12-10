package me.josecoelho.adventofcode2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day5Part1Test {

    @Test
    void test() {
        final String expectedResult = "CMZ";
        final String result = Day5Part1.solve("inputs/day5.txt");
        Assertions.assertEquals(expectedResult, result);
    }
}