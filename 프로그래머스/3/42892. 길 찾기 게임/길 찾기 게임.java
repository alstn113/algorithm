import java.util.*;

class Solution {
    // nodeinfo [열,행]
    public int[][] solution(int[][] nodeinfo) {
        List<Node> nodes = new ArrayList<>();
        int n = nodeinfo.length;
        
        for (int i=0; i<n; i++) {
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            Node node = new Node(x, y, i+1, null, null);    
            nodes.add(node);
        }
        nodes.sort((o1, o2) -> {
            return o2.y - o1.y;
        });
        
        Node root = nodes.get(0);
        for (int i=1; i<n; i++) {
            dfs(root, nodes.get(i));
        }
        
        List<Integer> presult = new ArrayList<>();
        piter(root, presult);
        List<Integer> aresult = new ArrayList<>();
        aiter(root, aresult);
    
        return new int[][] {
            presult.stream().mapToInt(i -> i).toArray(),
            aresult.stream().mapToInt(i -> i).toArray()
        };
    }
    
    public void piter(Node node, List<Integer> result) {
        result.add(node.num);
        if (node.left != null) {
            piter(node.left, result);
        }
        if (node.right != null) {
            piter(node.right, result);
        }
    }
    
    public void aiter(Node node, List<Integer> result) {
        if (node.left != null) {
            aiter(node.left, result);
        }
        if (node.right != null) {
            aiter(node.right, result);
        }
        result.add(node.num);
    }
    
    public void dfs(Node node, Node target) {
        if (node.x > target.x) {
            if (node.left == null) {
                node.left = target;
            } else {
                dfs(node.left, target);
            }
        } else {
            if (node.right == null) {
                node.right = target;
            } else {
                dfs(node.right, target);
            }
        }
    }
    
    class Node {
        int x;
        int y;
        int num;
        Node left;
        Node right;
        
        public Node(int x, int y, int num, Node left, Node right) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.left = left;
            this.right = right;
        }
    }
}