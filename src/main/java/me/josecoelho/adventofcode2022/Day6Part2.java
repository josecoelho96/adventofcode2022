package me.josecoelho.adventofcode2022;

import me.josecoelho.adventofcode2022.utils.FileUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Day6Part2 {

    public static void main(String[] args) {
        final int result = solve("inputs/day6.txt");
        System.out.printf("Day 6 Part 2 Answer: %d%n", result);
    }

    protected static int solve(final String fileInput) {

        final List<String> lines = FileUtils.getFileAsStringList(fileInput);
        final char[] chars = lines.get(0).toCharArray();

        final Set<Character> characters = new HashSet<>();
        int result = 0;
        for (int i = 13; i < chars.length; i++) {
            characters.clear();
            for (int j = 0; j < 14; j++) {
                characters.add(chars[i - j]);
            }
            if (characters.size() == 14) {
                result = i + 1;
                break;
            }
        }

        return result;
    }
}
