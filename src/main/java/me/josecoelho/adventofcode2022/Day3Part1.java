package me.josecoelho.adventofcode2022;

import me.josecoelho.adventofcode2022.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day3Part1 {

    public static void main(String[] args) {
        int result = solve("inputs/day3.txt");
        System.out.printf("Day 3 Part 1 Answer: %d%n", result);
    }

    protected static int solve(final String fileInput) {

        final List<String> rucksacks = FileUtils.getFileAsStringList(fileInput);

        int priority = 0;

        for (final String rucksack : rucksacks) {
            priority += findRucksackPriority(rucksack);
        }
        return priority;
    }

    private static int findRucksackPriority(String line) {
        if (line.length() % 2 == 1) {
            throw new RuntimeException("odd sized line found");
        }

        final Set<Character> firstCompartment = line
                .substring(0, line.length() / 2)
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        final Set<Character> secondCompartment = line
                .substring(line.length() / 2)
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());
        
        firstCompartment.retainAll(secondCompartment);
        final ArrayList<Character> commonItemsInBothCompartments = new ArrayList<>(firstCompartment);

        if (commonItemsInBothCompartments.size() != 1) {
            throw new RuntimeException("more than 1 common item");
        }
        final int itemPriority = (int) commonItemsInBothCompartments.get(0);

        if (itemPriority > 97) {
            return itemPriority - 96;
        }
        else {
            return itemPriority - 38;
        }
    }
}
