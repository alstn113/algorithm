package algorithm.트라이;

import java.util.HashMap;
import java.util.Map;

public class 트라이 {

    static class TrieNode {

        Map<Character, TrieNode> children = new HashMap<>();
        int cnt = 0;
    }

    static class Trie {

        private final TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                cur.children.putIfAbsent(c, new TrieNode());
                cur = cur.children.get(c);
                cur.cnt += 1;
            }
        }

        public int prefixCount(String prefix) {
            TrieNode cur = root;
            for (char c : prefix.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    return 0;
                }
                cur = cur.children.get(c);
            }
            return cur.cnt;
        }

        public static void main(String[] args) {
            Trie trie = new Trie();
            trie.insert("apple");
            trie.insert("app");
            trie.insert("apply");
            trie.insert("ape");
            trie.insert("bat");

            System.out.println(trie.prefixCount("app")); // 3
            System.out.println(trie.prefixCount("a"));   // 4
            System.out.println(trie.prefixCount("b"));   // 1
        }
    }
}
