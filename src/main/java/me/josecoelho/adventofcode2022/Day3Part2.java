package me.josecoelho.adventofcode2022;

import me.josecoelho.adventofcode2022.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Day3Part2 {

    public static void main(String[] args) {
        int result = solve("inputs/day3.txt");
        System.out.printf("Day 3 Part 2 Answer: %d%n", result);
    }

    protected static int solve(final String fileInput) {

        final List<String> rucksacks = FileUtils.getFileAsStringList(fileInput);

        int priority = 0;

        for (int i = 0; i < rucksacks.size() - 2; i+=3) {
            priority += findRucksacksBadge(rucksacks.get(i), rucksacks.get(i + 1), rucksacks.get(i + 2));
        }

        return priority;
    }

    private static int findRucksacksBadge(final String rucksack1, final String rucksack2, final String rucksack3) {

        final Set<Character> firstRucksack = rucksack1
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        final Set<Character> secondRucksack = rucksack2
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        final Set<Character> thirdRucksack = rucksack3
                .chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.toSet());

        firstRucksack.retainAll(secondRucksack);
        firstRucksack.retainAll(thirdRucksack);

        final ArrayList<Character> commonItems = new ArrayList<>(firstRucksack);

        if (commonItems.size() != 1) {
            throw new RuntimeException("more than 1 common item");
        }
        final int itemPriority = (int) commonItems.get(0);

        if (itemPriority > 97) {
            return itemPriority - 96;
        }
        else {
            return itemPriority - 38;
        }
    }
}
