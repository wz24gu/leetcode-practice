package edu.wz.cs.leetcode.medium;

/**
 * 648. Replace Words<br>
 * https://leetcode.com/problems/replace-words<br><br>
 * 
 * In English, we have a concept called root, which can be followed by some other words to form another longer word - 
 * let's call this word successor. For example, the root an, followed by other, which can form another word another.<br>
 * 
 * Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the 
 * sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the 
 * shortest length. You need to output the sentence after the replacement.<br>
 * 
 * Example 1:<br>
 * Input: dict = ["cat", "bat", "rat"]<br>
 * sentence = "the cattle was rattled by the battery"<br>
 * Output: "the cat was rat by the bat"<br><br>
 * 
 * Note:<br>
 * 1. The input will only have lower-case letters.<br>
 * 2. 1 <= dict words number <= 1000<br>
 * 3. 1 <= sentence words number <= 1000<br>
 * 4. 1 <= root length <= 100<br>
 * 5. 1 <= sentence words length <= 1000
 */
public class ReplaceWords {
    
    private static class TrieNode {
        public boolean isWord;
        public TrieNode[] children;
        public TrieNode() {
            isWord = false;
            children = new TrieNode[26];
        }
    }
    
    public static String solution(String[] dict, String sentence) {
        TrieNode trie = buildTrie(dict);
        String[] words = sentence.split(" ");
        
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(getShortestPrefix(trie, word));
            sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
    
    private static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        
        for (String word : words) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                }
                curr = curr.children[c - 'a'];
            }
            curr.isWord = true;
        }
        return root;
    }
    
    private static String getShortestPrefix(TrieNode root, String word) {
        TrieNode curr = root;
        StringBuilder sb = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                return word;
            }
            else {
                curr = curr.children[c - 'a'];  // curr was root
                sb.append(c);
                if (curr.isWord) {
                    break;
                }
            }
        }   
        return sb.toString();
    }
    
    public static void main(String[] args) {
        String[] dict = {"cat", "bat", "rat"};
        String sentence = "the cattle was rattled by the battery";
        System.out.println(ReplaceWords.solution(dict, sentence));
    }

}
