package me.josecoelho.adventofcode2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day7Part1Test {

    @Test
    void test() {
        final long expectedResult = 95437;
        final long result = Day7Part1.solve("inputs/day7.txt");
        Assertions.assertEquals(expectedResult, result);
    }
}