package me.josecoelho.adventofcode2022;

import me.josecoelho.adventofcode2022.utils.FileUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6Part1 {

    public static void main(String[] args) {
        final int result = solve("inputs/day6.txt");
        System.out.printf("Day 6 Part 1 Answer: %d%n", result);
    }

    protected static int solve(final String fileInput) {

        final List<String> lines = FileUtils.getFileAsStringList(fileInput);
        final char[] chars = lines.get(0).toCharArray();

        final Set<Character> characters = new HashSet<>();
        int result = 0;
        for (int i = 3; i < chars.length; i++) {
            characters.clear();
            characters.add(chars[i]);
            characters.add(chars[i - 1]);
            characters.add(chars[i - 2]);
            characters.add(chars[i - 3]);
            if (characters.size() == 4) {
                result = i + 1;
                break;
            }
        }

        return result;
    }
}
