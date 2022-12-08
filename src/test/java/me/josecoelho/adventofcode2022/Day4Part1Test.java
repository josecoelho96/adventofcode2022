package me.josecoelho.adventofcode2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day4Part1Test {

    @Test
    void test() {
        final int expectedResult = 2;
        int result = Day4Part1.solve("inputs/day4.txt");
        Assertions.assertEquals(expectedResult, result);
    }
}