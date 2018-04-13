package edu.wz.cs.leetcode.medium;

/**
 * 779. K-th Symbol in Grammar<br>
 * https://leetcode.com/problems/k-th-symbol-in-grammar<br><br>
 * 
 * On the first row, we write a 0. Now in every subsequent row, we look at the previous row and replace each occurrence 
 * of 0 with 01, and each occurrence of 1 with 10.<br>
 * 
 * Given row N and index K, return the K-th indexed symbol in row N. (The values of K are 1-indexed.) (1 indexed).<br><br>
 * 
 * Note:<br>
 * 1. N will be an integer in the range [1, 30].<br>
 * 2. K will be an integer in the range [1, 2^(N-1)].
 */
public class KthSymbolInGrammar {
    
    public static int solution(int N, int K) {
        return Integer.bitCount(K - 1) & 1;
    }
    
    public static void main(String[] args) {
        System.out.println(KthSymbolInGrammar.solution(1, 1));
        System.out.println(KthSymbolInGrammar.solution(2, 1));
        System.out.println(KthSymbolInGrammar.solution(2, 2));
        System.out.println(KthSymbolInGrammar.solution(4, 5));
    }

}
