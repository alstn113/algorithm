package grammar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortEx {

    public static void main(String[] args) {

        // (1) 오름차순 정렬
        int[] arr1 = {3, 1, 9, 7, 5, 11, 4, 6, 2, 8};
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        // (2) 내림차순 정렬
        int[] arr2 = {3, 1, 9, 7, 5, 11, 4, 6, 2, 8};
        Integer[] arr3 = Arrays.stream(arr2).boxed().toArray(Integer[]::new);
        Arrays.sort(arr3, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr3));

        // (3) x로 오름차순 정렬, x가 같으면 y로 내림차순 정렬
        List<Node> list = new ArrayList<>();
        list.add(new Node(1, 2));
        list.add(new Node(3, 1));
        list.add(new Node(1, 1));
        list.add(new Node(2, 3));
        list.add(new Node(2, 2));
        list.add(new Node(3, 3));

        list.sort((node1, node2) -> {
            if (node1.getX() == node2.getX()) {
                return node2.getY() - node1.getY(); //
            }
            return node1.getX() - node2.getX(); // 오름차순
        });
        System.out.println(list);

        // (4) x로 오름차순 정렬, x가 같으면 y로 내림차순 정렬
        List<Node2> list2 = new ArrayList<>();
        list2.add(new Node2(1, 2));
        list2.add(new Node2(3, 1));
        list2.add(new Node2(1, 1));
        list2.add(new Node2(2, 3));
        list2.add(new Node2(2, 2));
        list2.add(new Node2(3, 3));

        Collections.sort(list2);
        System.out.println(list2);
    }
}

class Node {

    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

class Node2 implements Comparable<Node2> {

    int x;
    int y;

    public Node2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Node2 other) {
        if (this.x == other.x) {
            return other.y - this.y; // 내림차순
        }
        return this.x - other.x; // 오름차순
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}