package edu.wz.cs.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 288. Unique Word Abbreviation<br/>
 * 
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word 
 * abbreviations:<br/><br/>
 * 
 * a) it -> it (no abbreviateion)<br/>
 * b) dog -> d1g<br/>
 * c) internationalization -> i18n<br/>
 * d) localization -> l10n<br/>
 * 
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's 
 * abbreviation is unique if no other word from the dictionary has the same abbreviation.<br/>
 */
public class UniqueWordAbbreviation {
    
    private Map<String, Set<String>> map;
    
    public UniqueWordAbbreviation(String[] dict) {
        map = new HashMap<String, Set<String>>();
        for (String word : dict) {
            String abbr = new String(word);
            if (word.length() > 2) {                
                abbr = word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
            }
            
            if (!map.containsKey(abbr)) {
                map.put(abbr, new HashSet<String>());
            }
            map.get(abbr).add(word);
        }
    }
    
    public boolean isUnique(String word) {
        String abbr = new String (word);
        if (word.length() > 2) {
            abbr = word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
        }
        
        if (!map.containsKey(abbr)) {
            return true;
        }
        else {
            if (map.get(abbr).contains(word)) {
                return map.get(abbr).size() == 1;
            }
            else {
                map.get(abbr).add(word);
                boolean unique = map.get(abbr).size() == 1;
                map.get(abbr).remove(word);
                return unique;
                // we can just return false, however, above code will guard against bad data
            }
        }        
    }
    
    public static void main(String[] args) {
        String[] dict = {"deer", "door", "cake", "card"};
        UniqueWordAbbreviation uniqe = new UniqueWordAbbreviation(dict);
        System.out.println(uniqe.isUnique("dear"));
        System.out.println(uniqe.isUnique("cart"));
        System.out.println(uniqe.isUnique("cane"));
        System.out.println(uniqe.isUnique("make"));
    }

}
