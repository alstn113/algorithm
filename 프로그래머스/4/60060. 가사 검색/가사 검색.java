import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
                result[i] = rTrie.search(new StringBuilder(query).reverse().toString()) ;
            } else {
                result[i] = trie.search(query);
            }
        }

        return result;
    }

    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int cnt = 0;
    }

    class Trie {
        Map<Integer, TrieNode> root = new HashMap<>();

        public void insert(String word) {
            int len = word.length();
            TrieNode node = root.computeIfAbsent(len, v -> new TrieNode());
            node.cnt += 1;

            for (Character c : word.toCharArray()) {
                TrieNode next = node.children.computeIfAbsent(c, v -> new TrieNode());
                next.cnt += 1;
                node = next;
            }
        }

        public int search(String query) {
            int len = query.length();
            TrieNode node = root.get(len);
            if (node == null) {
                return 0;
            }

            for (Character c : query.toCharArray()) {
                if (c == '?') {
                    return node.cnt;
                }

                if (node.children.get(c) == null) {
                    return 0;
                }
                node = node.children.get(c);
            }

            return node.cnt;
        }
    }
}