package me.josecoelho.adventofcode2022;

import me.josecoelho.adventofcode2022.utils.FileUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1Part2 {

    public static void main(String[] args) {
        int result = solve("inputs/day1.txt");
        System.out.printf("Day 1 Part 2 Answer: %d%n", result);
    }

    protected static int solve(final String fileInput) {
        final List<String> lines = FileUtils.getFileAsStringList(fileInput);

        int totalCalories = 0;
        final List<Integer> maxCalories = new ArrayList<>() {{
            add(0);
            add(0);
            add(0);
        }};

        for (final String line : lines) {
            if (line.equals("")) {
                if (totalCalories > maxCalories.get(0)) {
                    maxCalories.set(0, totalCalories);
                    Collections.sort(maxCalories);
                }
                totalCalories = 0;
            }
            else {
                totalCalories += Integer.parseInt(line);
            }
        }

        if (totalCalories > maxCalories.get(0)) {
            maxCalories.set(0, totalCalories);
        }

        return maxCalories.stream().reduce(0, Integer::sum);
    }
}
