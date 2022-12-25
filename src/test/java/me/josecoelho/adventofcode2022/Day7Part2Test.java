package me.josecoelho.adventofcode2022;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Day7Part2Test {

    @Test
    void test() {
        final long expectedResult = 24933642;
        final long result = Day7Part2.solve("inputs/day7.txt");
        Assertions.assertEquals(expectedResult, result);
    }
}