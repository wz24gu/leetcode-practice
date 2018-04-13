package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 642. Design Search Autocomplete System<br>
 * 
 * Design a search autocomplete system for a search engine. Users may input a sentence (at least one word and end with 
 * a special character '#'). For each character they type except '#', you need to return the top 3 historical hot 
 * sentences that have prefix the same as the part of sentence already typed. Here are the specific rules:<br>
 * 
 * The hot degree for a sentence is defined as the number of times a user typed the exactly same sentence before. The 
 * returned top 3 hot sentences should be sorted by hot degree (The first is the hottest one). If several sentences 
 * have the same degree of hot, you need to use ASCII-code order (smaller one appears first).<br>
 * 
 * If less than 3 hot sentences exist, then just return as many as you can.<br>
 * 
 * When the input is a special character, it means the sentence ends, and in this case, you need to return an empty list.<br><br>
 * 
 * Your job is to implement the following functions:<br>
 * The constructor function:<br>
 * AutocompleteSystem(String[] sentences, int[] times): This is the constructor. The input is historical data. 
 * Sentences is a string array consists of previously typed sentences. Times is the corresponding times a sentence 
 * has been typed. Your system should record these historical data.<br>
 * 
 * Now, the user wants to input a new sentence. The following function will provide the next character the user types:<br>
 * List<String> input(char c): The input c is the next character typed by the user. The character will only be 
 * lower-case letters ('a' to 'z'), blank space (' ') or a special character ('#'). Also, the previously typed sentence 
 * should be recorded in your system. The output will be the top 3 historical hot sentences that have prefix the same as 
 * the part of sentence already typed.<br><br>
 * 
 * Note:<br>
 * 1. The input sentence will always start with a letter and end with '#', and only one blank space will exist between 
 * two words.<br>
 * 2. The number of complete sentences that to be searched won't exceed 100. The length of each sentence including 
 * those in the historical data won't exceed 100.<br>
 * 3. Please use double-quote instead of single-quote when you write test cases even for a character input.<br>
 * 4. Please remember to RESET your class variables declared in class AutocompleteSystem, as static/class variables are 
 * persisted across multiple test cases. Please see here for more details.
 */
public class DesignSearchAutocompleteSystem {
    
    private class TrieNode {
        public Map<Character, TrieNode> children;
        public Map<String, Integer> counts;  // this is not typical trie field but facilitate the search
        @SuppressWarnings("unused")
        public boolean isWord;
        public TrieNode() {
            children = new HashMap<Character, TrieNode>();
            counts = new HashMap<String, Integer>();
            isWord = false;
        }
    }
    
    private class Pair {
        public String string;
        public int count;
        public Pair(String string, int count) {
            this.string = string;
            this.count = count;
        }
    }
    
    private TrieNode root;
    private String prefix;
    
    public DesignSearchAutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }
    
    private void add(String string, int count) {
        TrieNode current = root;
        for (char c : string.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNode());
            }
            current = current.children.get(c);
            current.counts.put(string, current.counts.getOrDefault(string, 0) + count);
        }
        current.isWord = true;
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            add(prefix, 1);  // add prefix as historical data
            prefix = "";  // clean up
            return new ArrayList<String>();
        }
        
        prefix = prefix + c;
        TrieNode current = root;
        for (char ch : prefix.toCharArray()) {
            if (current.children.get(ch) == null) {
                return new ArrayList<String>();
            }
            current = current.children.get(ch);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            // sort by count DESC, and if equal, sort alphabetically ASC
            public int compare(Pair p1, Pair p2) {
                if (p1.count == p2.count) {
                    return p1.string.compareTo(p2.string);
                }
                return p2.count - p1.count;
            }
        });        
        for (String s : current.counts.keySet()) {
            pq.add(new Pair(s, current.counts.get(s)));
        }
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 3 && !pq.isEmpty(); i++) {
            result.add(pq.poll().string);
        }
        return result;        
    }

}
