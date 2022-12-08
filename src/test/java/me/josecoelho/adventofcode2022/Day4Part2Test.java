package me.josecoelho.adventofcode2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day4Part2Test {

    @Test
    void test() {
        final int expectedResult = 4;
        int result = Day4Part2.solve("inputs/day4.txt");
        Assertions.assertEquals(expectedResult, result);
    }
}