package edu.wz.cs.leetcode.os;

/**
 * 195. Tenth Line<br/>
 * https://leetcode.com/problems/tenth-line<br/><br/>
 * 
 * How would you print just the 10th line of a file?<br/>
 * For example, assume that file.txt has the following content:<br/>
 * Line 1<br/>
 * Line 2<br/>
 * Line 3<br/>
 * Line 4<br/>
 * Line 5<br/>
 * Line 6<br/>
 * Line 7<br/>
 * Line 8<br/>
 * Line 9<br/>
 * Line 10<br/>
 * 
 * Your script should output the tenth line, which is:<br/>
 * Line 10<br/><br/>
 * 
 * Hint:<br/>
 * 1. If the file contains less than 10 lines, what should you output?<br/>
 * 2. There's at least three different solutions. Try to explore all possibilities.
 * 
 * tail -n 3 file.txt: print last 3 lines<br/>
 * tail -n +3 file.txt： print from line 3<br/>
 * head -n 3 file.txt： print first 3 lines<br/>
 * head -n -3 file.txt： print all except the last 3 lines
 */
public class TenthLine {

    public static final String COMMAND = "tail -n +10 file.txt | head -n 1";
    
    public static final String COMMAND2 = "awk 'NR == 10' file.txt";
    
    public static final String COMMAND3 = "sed -n 10p file.txt";

}
