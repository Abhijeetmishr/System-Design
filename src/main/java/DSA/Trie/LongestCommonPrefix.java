package DSA.Trie;

public class LongestCommonPrefix {
    
    public String longestCommonPrefix(String[] strs) {
        //Trie Based approach
        //global root TrieNode
        TrieNode root = new TrieNode();
        for(int i=0;i<strs.length;i++) {
            //start from the root
            TrieNode curr = root;
            for(int j=0;j<strs[i].length();j++) {
                if(curr.character[strs[i].charAt(j) - 'a'] == null) {
                    //character not seen before
                    TrieNode toAdd = new TrieNode();
                    curr.character[strs[i].charAt(j) - 'a'] = toAdd;
                }
                //move current Trienode
                curr = curr.character[strs[i].charAt(j) - 'a'];
                //increment current node prefixCount
                curr.prefixCount++;
            }
            //strs[i] completely traversed
            curr.isEndOfWord = true;
        }
        //using StringBuilder as concatenation is faster than String
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs[0].length();i++) {
            //checking if prefixCount == n
            if(root.character[strs[0].charAt(i) - 'a'].prefixCount == strs.length) {
                sb.append(strs[0].charAt(i));
                root = root.character[strs[0].charAt(i) - 'a'];
            }else {
                //no more answer ahead
                break;
            }
        }
        return String.valueOf(sb);
    }
    static class TrieNode {
        TrieNode[] character;
        boolean isEndOfWord;
        int prefixCount;
        
        TrieNode() {
            isEndOfWord = false;
            character = new TrieNode[26];
            prefixCount= 0;
        }
    }
}
