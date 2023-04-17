package src;

public class TrieNode {
    boolean isEndOfWord;
    CustomMap<String, TrieNode> children;

    public TrieNode() {
        isEndOfWord = false;
        children = new HashMap<>();
    }
}