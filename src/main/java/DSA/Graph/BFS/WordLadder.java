package DSA.Graph.BFS;

import java.util.*;

/**
 * Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.

 

    Example 1:

    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
    Output: 5
    Explanation: One shortest transformation sequence is "hit" -> "hot" -> "dot" -> "dog" -> cog", which is 5 words long.
    Example 2:

    Input: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log"]
    Output: 0
    Explanation: The endWord "cog" is not in wordList, therefore there is no valid transformation sequence.
 */
class WordLadder {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        HashSet<String> dict = new HashSet<>();
        wordList.stream().forEach((str) -> dict.add(str));
        queue.add(beginWord);
        visited.add(beginWord);
        int steps = 1;

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int j = 0; j < size; j++){
                String str = queue.poll();
                for (int i = 0; i < str.length(); i++) {
                    char[] chars = str.toCharArray();
                    
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[i] = c;
                        
                        String word = new String(chars);
                        
                        // Found the end word
                        if (word.equals(endWord)) return steps + 1;
                        
                        // Put it to the queue
                        if (dict.contains(word) && !visited.contains(word)) {
                            queue.add(word);
                            visited.add(word);
                        }
                    }
                }
            }
            steps += 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String beginWord = scanner.nextLine();
        String endWord = scanner.nextLine();

        int n = scanner.nextInt();
        List<String> wordList = new ArrayList<String>();

        for (int i = 0; i < n; ++i) {
            String word = scanner.next();
            wordList.add(word);
        }
        scanner.close();
        int result = new WordLadder().ladderLength(beginWord, endWord, wordList);
        System.out.println(result);
    }
}
