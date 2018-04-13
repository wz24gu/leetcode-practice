package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 676. Implement Magic Dictionary<br>
 * https://leetcode.com/problems/implement-magic-dictionary<br><br>
 * 
 * Implement a magic directory with buildDict, and search methods. For the method buildDict, you'll be given a list of 
 * non-repetitive words to build a dictionary. For the method search, you'll be given a word, and judge whether if you 
 * modify exactly one character into another character in this word, the modified word is in the dictionary you just 
 * built.<br><br>
 * 
 * Note:<br>
 * 1. You may assume that all the inputs are consist of lowercase letters a-z.<br>
 * 2. For contest purpose, the test data is rather small by now. You could think about highly efficient algorithm after 
 * the contest.
 * 3. Please remember to RESET your class variables declared in class MagicDictionary, as static/class variables are 
 * persisted across multiple test cases. Please see here for more details.
 */
public class ImplementMagicDictionary {
    
    private Map<Integer, List<String>> map;
    
    public void buildDict(String[] words) {
        map = new HashMap<Integer, List<String>>();
        for (String word : words) {
            int len = word.length();
            if (!map.containsKey(len)) {
                map.put(len, new ArrayList<String>());
            }
            map.get(len).add(word);
        }
    }
    
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        
        int len = word.length();
        if (!map.containsKey(len)) {
            return false;
        }
        else {
            for (String s : map.get(len)) {
                int count = 0;
                for (int i = 0; i < len; i++) {
                    if (s.charAt(i) != word.charAt(i)) {
                        count++;
                    }
                }
                if (count == 1) {
                    return true;
                }
            }
            return false;
        }
    }
    
    private Set<String> set;
    
    public void buildDictX(String[] words) {
        set = new HashSet<String>();
        for (String word : words) {
            set.add(word);
        }
    }
    
    public boolean searchX(String word) {
        if (word == null) {
            return false;
        }
        
        char[] array = word.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char t = array[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (t == c) {
                    continue;
                }
                array[i] = c;
                if (set.contains(new String(array))) {
                    return true;
                }
            }
            array[i] = t;
        }
        return false;
    }
    
    public static void main(String[] args) {
        String[] words = {"hello", "leetcode"};
        ImplementMagicDictionary dict = new ImplementMagicDictionary();
        dict.buildDict(words);
        System.out.println(dict.search("hello"));
        System.out.println(dict.search("hhllo"));
        System.out.println(dict.search("hell"));
        System.out.println(dict.search("leetcoded"));
        
        String[] words1 = {"hello", "leetcode"};
        ImplementMagicDictionary dict1 = new ImplementMagicDictionary();
        dict1.buildDictX(words1);
        System.out.println(dict1.searchX("hello"));
        System.out.println(dict1.searchX("hhllo"));
        System.out.println(dict1.searchX("hell"));
        System.out.println(dict1.searchX("leetcoded"));
    }

}
