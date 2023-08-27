package DSA.Trie;

class TrieNode {
    TrieNode[] children;
    boolean isWordCompleted;

    TrieNode() {
        children = new TrieNode[26];
        isWordCompleted = false;
    }
}

class WordDictionary {
    TrieNode root;

    WordDictionary() {
        root = new TrieNode();
    }

    //add word in our dictionary
    void addWord(String word) {
        TrieNode newRoot = root;
        for (char ch : word.toCharArray()) {
            int alphabetIndex = ch - 'a';
            if (newRoot.children[alphabetIndex] == null) {
                newRoot.children[alphabetIndex] = new TrieNode();
            }
            newRoot = newRoot.children[alphabetIndex];
        }
        newRoot.isWordCompleted = true;
    }

    //search word in our dictionary
    boolean search(String word) {
        return dfs(word, 0, root);
    }
    /**using dfs in case of word like ".at" where '.' can be matched with any word like
        bat, cat, rat, mat, hat etc. */
    boolean dfs(String word, int index, TrieNode curr) {
        for(int i = index; i < word.length(); i++){
            char ch = word.charAt(i);
            if (ch == '.') {
                for (TrieNode child : curr.children) {
                    if (child != null && dfs(word, i + 1, child)) {
                        return true;
                    }
                }
                return false;
            }
            else {
                if (curr.children[ch - 'a'] == null) {
                    return false;
                }
                curr = curr.children[ch - 'a'];
            }
        }
        return curr.isWordCompleted;
    }

}