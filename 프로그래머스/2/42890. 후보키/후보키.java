import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int columnCount = relation[0].length;
        int tupleCount = relation.length;

        List<List<Integer>> combinations = new ArrayList<>();
        for (int size = 1; size <= columnCount; size++) {
            generateCombinations(columnCount, size, 0, new ArrayList<>(), combinations);
        }

        List<List<Integer>> candidateKeys = new ArrayList<>();

        for (List<Integer> combination : combinations) {
            if (!isMinimal(combination, candidateKeys)) {
                continue;
            }

            if (isUnique(combination, relation, tupleCount)) {
                candidateKeys.add(combination);
            }
        }

        return candidateKeys.size();
    }

    private void generateCombinations(int columnCount, int size, int start, List<Integer> current, List<List<Integer>> combinations) {
        if (current.size() == size) {
            combinations.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < columnCount; i++) {
            current.add(i);
            generateCombinations(columnCount, size, i + 1, current, combinations);
            current.remove(current.size() - 1);
        }
    }

    private boolean isMinimal(List<Integer> combination, List<List<Integer>> candidateKeys) {
        for (List<Integer> key : candidateKeys) {
            if (new HashSet<>(combination).containsAll(key)) {
                return false;
            }
        }
        return true;
    }

    private boolean isUnique(List<Integer> combination, String[][] relation, int tupleCount) {
        Set<String> seen = new HashSet<>();

        for (String[] row : relation) {
            StringBuilder keyBuilder = new StringBuilder();
            for (int colIndex : combination) {
                keyBuilder.append(row[colIndex]).append(",");
            }
            if (!seen.add(keyBuilder.toString())) {
                return false;
            }
        }

        return seen.size() == tupleCount;
    }
}
