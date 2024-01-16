package DSA.Tree;
/*
 * https://leetcode.com/problems/unique-binary-search-trees/solutions/409987/summary-of-all-solutions-in-java-with-explanations/
    https://leetcode.com/problems/unique-binary-search-trees/solutions/31666/dp-solution-in-6-lines-with-explanation-f-i-n-g-i-1-g-n-i/
 */
public class UniqueBST {
    public int numTrees(int n) {
        /**G(n) = G(0) * G(n-1) + G(1) * G(n-2) + ..... + G(n-1) * G(0) */

        int[] G = new int[n+1];
        G[0] = G[1] = 1;

        for(int i = 2; i <= n; ++i){
            for(int j = 1; j <= i; ++j){
                G[i] += G[j-1] * G[i-j];
            }
        }
        return G[n];
    }
    // public int numTrees(int n) {
    //     long  C = 1;
    //     for(int i = 0; i < n; i++){
    //         C = C * 2 * (2 * i + 1)/(i + 2); // using Catalan Number
    //     }
    //     return (int)C;
    // }
}
