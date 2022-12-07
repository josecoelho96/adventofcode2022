package me.josecoelho.adventofcode2022;

import me.josecoelho.adventofcode2022.utils.FileUtils;

import java.util.List;

public class Day1Part1 {

    public static void main(String[] args) {
        int result = solve("inputs/day1.txt");
        System.out.printf("Day 1 Part 1 Answer: %d%n", result);
    }

    protected static int solve(final String fileInput) {
        final List<String> lines = FileUtils.getFileAsStringList(fileInput);

        int totalCalories = 0;
        int maxCalories = 0;

        for (final String line : lines) {
            if (line.equals("")) {
                if (totalCalories > maxCalories) {
                    maxCalories = totalCalories;
                }
                totalCalories = 0;
            }
            else {
                totalCalories += Integer.parseInt(line);
            }
        }
        return maxCalories;
    }
}
