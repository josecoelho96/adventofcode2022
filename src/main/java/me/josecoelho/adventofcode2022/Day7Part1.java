package me.josecoelho.adventofcode2022;

import me.josecoelho.adventofcode2022.utils.FileUtils;
import me.josecoelho.adventofcode2022.utils.Tree;
import me.josecoelho.adventofcode2022.utils.Tree.Node;

import java.util.ArrayList;
import java.util.List;

public class Day7Part1 {

    public static void main(String[] args) {
        final long result = solve("inputs/day7.txt");
        System.out.printf("Day 7 Part 1 Answer: %d%n", result);
    }

    protected static long solve(final String fileInput) {

        final List<String> lines = FileUtils.getFileAsStringList(fileInput);

        final Tree<File> filesystem = new Tree<>(File.newFolder("/"));
        Node<File> currentNode = filesystem.getRoot();

        for (int i = 1; i < lines.size(); i++) {
            final String line = lines.get(i);

            if (line.startsWith("$")) {
                if (line.startsWith("$ cd")) {
                    final String folderName = line.split(" ")[2];
                    if (folderName.equals("/")) {
                        throw new RuntimeException("root dir already defined");
                    }
                    else if (folderName.equals("..")) {
                        currentNode = currentNode.getParent();
                    }
                    else {
                        currentNode = currentNode
                                .getChildren()
                                .stream()
                                .filter(c -> c.getData().getName().equals(folderName))
                                .findFirst()
                                .orElseThrow(() -> new RuntimeException("bad tree"));
                    }
                }
            }
            else {
                final String[] s = line.split(" ");
                if (s[0].equals("dir")) {
                    currentNode.appendChild(File.newFolder(s[1]));
                }
                else {
                    currentNode.appendChild(File.newFile(s[1], Long.parseLong(s[0])));
                }
            }
        }

        final List<Long> sizesMatchingCriteria = new ArrayList<>();
        computeNodeSize(filesystem.getRoot(), sizesMatchingCriteria);

        return sizesMatchingCriteria.stream().reduce(0L, Long::sum);
    }

    private static long computeNodeSize(Node<File> node, List<Long> sizesMatchingCriteria) {
        if (node.getData().isFile()) {
            return node.getData().getSize();
        }
        long childrenSize = 0;
        for (Node<File> child : node.getChildren()) {
            long childSize = computeNodeSize(child, sizesMatchingCriteria);
            child.getData().setSize(childSize);
            childrenSize += childSize;
        }

        if (childrenSize <= 100000) {
            sizesMatchingCriteria.add(childrenSize);
        }
        node.getData().setSize(childrenSize);
        return childrenSize;
    }

    private static final class File {
        enum Type {FILE, FOLDER}
        private final Type type;
        private final String name;
        private long size;

        private File(Type type, String name, long size) {
            this.type = type;
            this.name = name;
            this.size = size;
        }

        public static File newFile(String name, long size) {
            return new File(Type.FILE, name, size);
        }

        public static File newFolder(String name) {
            return new File(Type.FOLDER, name, -1);
        }

        public boolean isFile() {
            return type.equals(Type.FILE);
        }

        public String getName() {
            return name;
        }

        public long getSize() {
            return size;
        }

        public void setSize(long size) {
            this.size = size;
        }

        @Override
        public String toString() {
            return "File{" +
                    "type=" + type +
                    ", name='" + name + '\'' +
                    ", size=" + size +
                    '}';
        }
    }
}
