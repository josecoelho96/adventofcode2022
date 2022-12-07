package me.josecoelho.adventofcode2022;

import me.josecoelho.adventofcode2022.utils.FileUtils;

import java.util.List;

public class Day2Part2 {

    public static void main(String[] args) {
        int result = solve("inputs/day2.txt");
        System.out.printf("Day 2 Part 2 Answer: %d%n", result);
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
        final char objective = line.charAt(2);

        int score = 0;
        if (opponentOption == 'A') { // Rock
            if (objective == 'Z') { // I must Win
                score += 6; // 6 pts for victory
                score += 2; // 2 pts for playing Paper
            }
            else if (objective == 'Y') { // I must Draw
                score += 3; // 3 pts for draw
                score += 1; // 1 pts for playing Rock
            }
            else if (objective == 'X') { // I must Lose
                score += 3; // 3 pts for playing Scissors
            }
        }
        else if (opponentOption == 'B') { // Paper
            if (objective == 'Z') { // I must Win
                score += 6; // 6 pts for victory
                score += 3; // 3 pts for playing Scissors
            }
            else if (objective == 'Y') { // I must Draw
                score += 3; // 3 pts for draw
                score += 2; // 2 pts for playing Paper
            }
            else if (objective == 'X') { // I must Lose
                score += 1; // 1 pts for playing Rock
            }
        }
        else if (opponentOption == 'C') { // Scissors
            if (objective == 'Z') { // I must Win
                score += 6; // 6 pts for victory
                score += 1; // 1 pts for playing Rock
            }
            else if (objective == 'Y') { // I must Draw
                score += 3; // 3 pts for draw
                score += 3; // 3 pts for playing Scissors
            }
            else if (objective == 'X') { // I must Lose
                score += 2; // 2 pts for playing Paper
            }
        }

        return score;
    }
}
