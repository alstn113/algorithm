import java.util.*;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        Trie trie = new Trie();
        Trie rTrie = new Trie();
        
        for (String word : words) {
            trie.insert(word);
            rTrie.insert(new StringBuilder(word).reverse().toString());
        }
        
        int[] result = new int[queries.length];
        for (int i=0; i<queries.length; i++) {
            String query = queries[i];
            if (query.startsWith("?")) {
                String nq = new StringBuilder(query).reverse().toString();
                result[i] = rTrie.search(nq);
            } else {
                result[i] = trie.search(query);
            }
        }
        
        return result;
    }
    
    class Node {
        Map<Character, Node> nodes = new HashMap<>();
        int pass = 1;
    }
    
    class Trie {
        Map<Integer, Node> map = new HashMap<>();
        
        public void insert(String word) {
            int len = word.length();
            Node node;
            if (!map.containsKey(len)) {
                node = new Node();
                map.put(len, node);
            } else {
                node = map.get(len);
                node.pass += 1;
            }

            for (Character c : word.toCharArray()) {
                if (!node.nodes.containsKey(c)) {
                    Node newNode = new Node();
                    node.nodes.put(c, newNode);
                    node = newNode;
                } else {
                    Node cur = node.nodes.get(c);
                    cur.pass += 1;
                    node = cur;
                }
            }
        }
        
        public int search(String query) {
            int len = query.length();
            Node cur = map.get(len);
            if (cur == null) {
                return 0;
            }
            
            for (Character c : query.toCharArray()) {
                if (c == '?') {
                    return cur.pass;
                }
                
                Node next = cur.nodes.get(c);
                if (next == null) {
                    return 0;
                }
                
                cur = next;
            }
            
            return cur.pass;
        }
    }
}