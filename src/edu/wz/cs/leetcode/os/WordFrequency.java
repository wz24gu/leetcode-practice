package edu.wz.cs.leetcode.os;

/**
 * 192. Word Frequency<br>
 * Write a bash script to calculate the frequency of each word in a text file words.txt.<br>
 * 
 * For simplicity sake, you may assume:<br>
 * 1. words.txt contains only lowercase characters and space ' ' characters.<br>
 * 2. Each word must consist of lowercase characters only.<br>
 * 3. Words are separated by one or more whitespace characters.<br>
 * 
 * For example, assume that words.txt has the following content:<br><br>
 * the day is sunny the the<br>
 * the sunny is is<br>
 * 
 * Your script should output the following, sorted by descending frequency:<br>
 * the 4<br>
 * is 3<br>
 * sunny 2<br>
 * day 1<br>
 * 
 * Note: Don't worry about handling ties, it is guaranteed that each word's frequency count is unique.
 */
public class WordFrequency {
    
    public static String BASH = "grep -oE '[a-z]+' words.txt | sort | uniq -c | sort -nr | awk '{print $2 $1}'";

}
