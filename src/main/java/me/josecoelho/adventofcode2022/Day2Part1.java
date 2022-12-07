package me.josecoelho.adventofcode2022;

import me.josecoelho.adventofcode2022.utils.FileUtils;

import java.util.List;

public class Day2Part1 {

    public static void main(String[] args) {
        int result = solve("inputs/day2.txt");
        System.out.printf("Day 2 Part 1 Answer: %d%n", result);
    }

    protected static int solve(final String fileInput) {

        final List<String> lines = FileUtils.getFileAsStringList(fileInput);

        int score = 0;

        for (final String line : lines) {
            score += findRoundScore(line);
        }
        return score;
    }

    private static int findRoundScore(String line) {
        final char opponentOption = line.charAt(0);
        final char myOption = line.charAt(2);

        int score = 0;
        if (myOption == 'X') { // Rock
            score += 1;
            if (opponentOption == 'C') { // Scissors
                score += 6;
            }
            else if (opponentOption == 'A') { // Rock
                score += 3;
            }
        }
        else if (myOption == 'Y') { // Paper
            score += 2;
            if (opponentOption == 'A') { // Rock
                score += 6;
            }
            else if (opponentOption == 'B') { // Paper
                score += 3;
            }
        }
        else if (myOption == 'Z') { // Scissors
            score += 3;
            if (opponentOption == 'B') { // Paper
                score += 6;
            }
            else if (opponentOption == 'C') { // Scissors
                score += 3;
            }
        }

        return score;
    }
}
