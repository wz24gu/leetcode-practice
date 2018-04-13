package edu.wz.cs.leetcode.os;

/**
 * 194. Transpose File<br>
 * https://leetcode.com/problems/transpose-file<br><br>
 * 
 * Given a text file file.txt, transpose its content.<br>
 * 
 * You may assume that each row has the same number of columns and each field is separated by the ' ' character.<br>
 * 
 * For example, if file.txt has the following content:<br>
 * name age<br>
 * alice 21<br>
 * ryan 30<br>
 * 
 * Output the following:<br>
 * name alice ryan<br>
 * age 21 30
 */
public class TransposeFile {
    
    public static final String BASH =
            "while read -a line; do"
          + "    for ((i = 0; i < \"${#line[@]}\"; ++i)); do"
          + "        a[$i]=\"${a[$i]} ${line[$i]}\""
          + "    done"
          + "done < file.txt"
          + "for ((i = 0; i < ${#a[@]}; ++i)); do"
          + "    echo ${a[i]}"
          + "done";

}
