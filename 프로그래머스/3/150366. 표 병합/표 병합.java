import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.w3c.dom.Node;

class Solution {
    public String[] solution(String[] commands) {
        String[][] board = new String[51][51]; // null;
        List<String> result = new ArrayList<>();

        Map<String, Node> map = new HashMap<>();

        for (String com : commands) {
            if (com.startsWith("UPDATE")) {
                String[] split = com.split(" ");
                if (split.length == 4) {
                    // 해당 셀 변경
                    int r = Integer.parseInt(split[1]);
                    int c = Integer.parseInt(split[2]);
                    String value = split[3];

                    String key = String.format("%d %d", r, c);
                    if (map.containsKey(key)) {
                        Node cur = map.get(key);
                        cur.str = value;
                    } else {
                        board[r][c] = value;
                    }
                } else if (split.length == 3) {
                    // 전체 value1을 value2로 변경
                    String value1 = split[1];
                    String value2 = split[2];

                    for (int i = 1; i < 51; i++) {
                        for (int j = 1; j < 51; j++) {
                            if (board[i][j] != null && board[i][j].equals(value1)) {
                                board[i][j] = value2;
                            }
                        }
                    }

                    for (Map.Entry<String, Node> entry : map.entrySet()) {
                        Node cur = entry.getValue();
                        if (cur.str != null && cur.str.equals(value1)) {
                            cur.str = value2;
                        }
                    }
                }
            } else if (com.startsWith("MERGE")) {
                // 두 셀을 논리적으로 병합
                String[] split = com.split(" ");
                int r1 = Integer.parseInt(split[1]);
                int c1 = Integer.parseInt(split[2]);
                int r2 = Integer.parseInt(split[3]);
                int c2 = Integer.parseInt(split[4]);

                if (r1 == r2 && c1 == c2) { // 동일한 셀인 경우 무시
                    continue;
                }

                String key1 = String.format("%d %d", r1, c1);
                String key2 = String.format("%d %d", r2, c2);

                if (map.containsKey(key1) && map.containsKey(key2)) {
                    Node node1 = map.get(key1);
                    Node node2 = map.get(key2);
                    if (node1 == node2) { // 동일한 셀인 경우 무시
                        continue;
                    }

                    List<int[]> tmp = new ArrayList<>();
                    tmp.addAll(node1.merged);
                    tmp.addAll(node2.merged);

                    String newStr = null;
                    if (node1.str != null) {
                        newStr = node1.str;
                    } else {
                        newStr = node2.str;
                    }

                    Node newNode = new Node();
                    newNode.str = newStr;
                    newNode.merged = tmp;

                    for (int[] id : tmp) {
                        String newKey = String.format("%d %d", id[0], id[1]);
                        map.put(newKey, newNode);
                    }
                } else if (map.containsKey(key1)) {
                    Node curNode = map.get(key1);
                    curNode.merged.add(new int[]{r2, c2});

                    String newStr = null;
                    if (curNode.str != null) {
                        newStr = curNode.str;
                    } else {
                        newStr = board[r2][c2];
                    }
                    curNode.str = newStr;

                    map.put(key2, curNode);
                    board[r2][c2] = null;
                } else if (map.containsKey(key2)) {
                    Node curNode = map.get(key2);
                    curNode.merged.add(new int[]{r1, c1});

                    String newStr = null;
                    if (board[r1][c1] != null) {
                        newStr = board[r1][c1];
                    } else {
                        newStr = curNode.str;
                    }
                    curNode.str = newStr;

                    map.put(key1, curNode);
                    board[r1][c1] = null;
                } else {
                    // 둘 다 단일 셀
                    List<int[]> tmp = new ArrayList<>();
                    tmp.add(new int[]{r1, c1});
                    tmp.add(new int[]{r2, c2});

                    String newStr = null;
                    if (board[r1][c1] != null) {
                        newStr = board[r1][c1];
                    } else {
                        newStr = board[r2][c2];
                    }

                    Node newNode = new Node();
                    newNode.str = newStr;
                    newNode.merged = tmp;

                    map.put(key1, newNode);
                    map.put(key2, newNode);
                    board[r1][c1] = null;
                    board[r2][c2] = null;
                }
            } else if (com.startsWith("UNMERGE")) {
                // 병합 해제 후 해당 셀에 값 부여
                String[] split = com.split(" ");
                int r = Integer.parseInt(split[1]);
                int c = Integer.parseInt(split[2]);
                String key = String.format("%d %d", r, c);
                if (!map.containsKey(key)) {
                    continue;
                }

                Node node = map.get(key);
                List<int[]> tmp = node.merged;
                for (int[] t : tmp) {
                    String newKey = String.format("%d %d", t[0], t[1]);
                    map.remove(newKey);
                }

                board[r][c] = node.str;
            } else if (com.startsWith("PRINT")) {
                String[] split = com.split(" ");
                int r = Integer.parseInt(split[1]);
                int c = Integer.parseInt(split[2]);
                String key = String.format("%d %d", r, c);
                if (map.containsKey(key)) {
                    Node node = map.get(key);
                    if (node.str == null) {
                        result.add("EMPTY");
                    } else {
                        result.add(node.str);
                    }
                } else {
                    if (board[r][c] == null) {
                        result.add("EMPTY");
                    } else {
                        result.add(board[r][c]);
                    }
                }
            }
        }

        return result.stream().toArray(String[]::new);
    }

    class Node {
        String str = null;
        List<int[]> merged = new ArrayList<>();
    }
}