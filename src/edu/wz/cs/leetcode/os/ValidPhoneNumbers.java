package edu.wz.cs.leetcode.os;

/**
 * 193. Valid Phone Numbers<br/>
 * https://leetcode.com/problems/valid-phone-numbers<br/><br/>
 * 
 * Given a text file file.txt that contains list of phone numbers (one per line), write a one liner bash script to 
 * print all valid phone numbers.<br/>
 * 
 * You may assume that a valid phone number must appear in one of the following two formats: (xxx) xxx-xxxx or 
 * xxx-xxx-xxxx. (x means a digit)<br/>
 * 
 * You may also assume each line in the text file must not contain leading or trailing white spaces.<br/><br/>
 * 
 * For example, assume that file.txt has the following content:<br/>
 * 987-123-4567<br/>
 * 123 456 7890<br/>
 * (123) 456-7890<br/><br/>
 * 
 * Your script should output the following valid phone numbers:<br/>
 * 987-123-4567<br/>
 * (123) 456-7890
 */
public class ValidPhoneNumbers {
    
    public static final String COMMAND = "grep '^([0-9] {3}-|\\([0-9] {3}\\) ) [0-9] {3}-[0-9] {4}$' file.txt";

}
