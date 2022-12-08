package me.josecoelho.adventofcode2022;

import me.josecoelho.adventofcode2022.utils.FileUtils;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Day4Part2 {

    public static void main(String[] args) {
        int result = solve("inputs/day4.txt");
        System.out.printf("Day 4 Part 2 Answer: %d%n", result);
    }

    protected static int solve(final String fileInput) {

        final List<String> sectionAssignments = FileUtils.getFileAsStringList(fileInput);

        int count = 0;
        for (String sectionAssignment : sectionAssignments) {
            final String[] elfAssignments = sectionAssignment.split(",");
            final String[] firstElfZoneLimits = elfAssignments[0].split("-");
            final String[] secondElfZoneLimits = elfAssignments[1].split("-");

            final Set<Integer> firstElfZones = IntStream
                    .rangeClosed(Integer.parseInt(firstElfZoneLimits[0]), Integer.parseInt(firstElfZoneLimits[1]))
                    .boxed()
                    .collect(Collectors.toSet());

            final Set<Integer> secondElfZones = IntStream
                    .rangeClosed(Integer.parseInt(secondElfZoneLimits[0]), Integer.parseInt(secondElfZoneLimits[1]))
                    .boxed()
                    .collect(Collectors.toSet());

            if (firstElfZones.stream().anyMatch(secondElfZones::contains) || secondElfZones.stream().anyMatch(firstElfZones::contains)) {
                count++;
            }
        }

        return count;
    }
}
