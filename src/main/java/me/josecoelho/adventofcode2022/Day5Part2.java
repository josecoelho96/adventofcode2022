package me.josecoelho.adventofcode2022;

import me.josecoelho.adventofcode2022.utils.FileUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class Day5Part2 {

    public static void main(String[] args) {
        final String result = solve("inputs/day5.txt");
        System.out.printf("Day 5 Part 2 Answer: %s%n", result);
    }

    protected static String solve(final String fileInput) {

        final List<String> lines = FileUtils.getFileAsStringList(fileInput);
        final Map<Integer, Stack<Character>> stacks = new HashMap<>();

        final List<String> initialStacks = new ArrayList<>(
                lines
                        .stream()
                        .filter(l -> l.strip().startsWith("["))
                        .toList()
        );

        Collections.reverse(initialStacks);

        initialStacks.forEach(line -> {
            int idx = line.indexOf("[");
            while (idx >= 0) {
                int stackIdx = idx / 4;
                stacks.putIfAbsent(stackIdx, new Stack<>());
                stacks.get(stackIdx).push(line.charAt(idx + 1));
                idx = line.indexOf("[", idx + 1);
            }
        });

        final List<String> moveCommands = lines
                .stream()
                .filter(l -> l.strip().startsWith("move"))
                .toList();

        moveCommands.forEach(line -> {
            final String[] s1 = line.substring(5).split(" from ");
            final String[] s2 = s1[1].split(" to ");
            final int quantity = Integer.parseInt(s1[0]);
            final int origin = Integer.parseInt(s2[0]) - 1;
            final int destiny = Integer.parseInt(s2[1]) - 1;
            final Stack<Character> tempStack = new Stack<>();
            for (int i = 1; i <= quantity; i++) {
                tempStack.push(stacks.get(origin).pop());
            }
            for (int i = 1; i <= quantity; i++) {
                stacks.get(destiny).push(tempStack.pop());
            }
        });

        return stacks
                .values()
                .stream()
                .map(Stack::peek)
                .map(Object::toString)
                .collect(Collectors.joining());
    }
}
