import java.util.*;

class Solution {
    public int solution(String[] words) {
        Node root = new Node();
        for (String word : words) {
            Node node = root;
            for (int i=0; i<word.length(); i++) {
                Character c = word.charAt(i);
                
                if(node.map.containsKey(c)) {
                    node = node.map.get(c);
                    node.cnt += 1;
                } else {
                    Node newNode = new Node();
                    newNode.cnt += 1;
                    node.map.put(c, newNode);
                    node = newNode;
                }
            }
        }
        
        int result = 0;
        for (String word: words) {
            Node node = root;
            boolean flag = false;
            for (int i=0; i<word.length(); i++) {
                Character c = word.charAt(i);
                node = node.map.get(c);
                
                if (node.cnt == 1) {
                    result += i+1;
                    flag = true;
                    break;
                }
            }
            
            if (!flag) {
                result += word.length();
            }
        }
        return result;
    }
    
    class Node {
        Map<Character, Node> map = new HashMap();
        int cnt = 0;
    }
}