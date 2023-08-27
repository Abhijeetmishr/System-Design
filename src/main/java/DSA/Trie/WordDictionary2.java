package DSA.Trie;

import java.util.ArrayList;
import java.util.List;

class WordDictionary2 {
    class TrieNode {
        TrieNode[] children;
        String word;
        TrieNode(){
            children = new TrieNode[26];
        }
    }
    TrieNode root;
    List<String> res;

    public List<String> findWords(char[][] board, String[] words) {
        this.res  = new ArrayList<>();
        this.root = new TrieNode();
        TrieNode curr = root;
        buildTrie(words);
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                dfs(board, i, j, curr);
            }
        }
        return res;
    }

    public void buildTrie(String[] words){
        for(String word: words){
            TrieNode curr = root;
            for(char ch : word.toCharArray()){
                if(curr.children[ch - 'a'] == null){
                    curr.children[ch -'a'] = new TrieNode();
                }
                curr = curr.children[ch - 'a'];
            }
            curr.word = word;
        }
        return;
    }

    public void dfs(char[][] board, int i, int j, TrieNode curr){
        char ch = board[i][j];
        if(ch == '#' || curr.children[ch -'a'] == null) return;
        curr = curr.children[ch - 'a'];

        if(curr.word != null){
            res.add(curr.word);
            curr.word = null;
        }

        board[i][j] = '#';
        if(i > 0) dfs(board, i-1, j, curr);
        if(j > 0) dfs(board, i, j-1, curr);
        if(i < board.length-1) dfs(board, i+1, j, curr);
        if(j < board[0].length-1) dfs(board, i, j+1, curr);
        board[i][j] = ch;
    }
}
