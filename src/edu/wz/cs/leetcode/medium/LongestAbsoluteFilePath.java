package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 388. Longest Absolute File Path<br>
 * https://leetcode.com/problems/longest-absolute-file-path<br><br>
 * 
 * Suppose we abstract our file system by a string in the following manner:<br>
 * 
 * The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:<br>
 * dir
 *     subdir1
 *     subdir2
 *         file.ext
 *         
 * The directory dir contains an empty sub-directory subdir1 and a sub-directory subdir2 containing a file file.ext.<br>
 * 
 * The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" represents:<br>
 * dir
 *     subdir1
 *         file1.ext
 *         subsubdir1
 *     subdir2
 *         subsubdir2
 *         file2.ext
 *         
 * The directory dir contains two sub-directories subdir1 and subdir2. subdir1 contains a file file1.ext and an empty 
 * second-level sub-directory subsubdir1. subdir2 contains a second-level sub-directory subsubdir2 containing a file 
 * file2.ext.<br>
 * 
 * We are interested in finding the longest (number of characters) absolute path to a file within our file system. For 
 * example, in the second example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext", and its length 
 * is 32 (not including the double quotes).<br>
 * 
 * Given a string representing the file system in the above format, return the length of the longest absolute path to 
 * file in the abstracted file system. If there is no file in the system, return 0.<br><br>
 * 
 * Note:<br>
 * 1. The name of a file contains at least a . and an extension.<br>
 * 2. The name of a directory or sub-directory will not contain a ..<br>
 * 3. Time complexity required: O(n) where n is the size of the input string.<br>
 * 
 * Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
 */
public class LongestAbsoluteFilePath {
    
    public static int solution(String input) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        
        String[] inputs = input.split("\n");
        for (String s : inputs) {
            int level = s.lastIndexOf("\t") + 1;
            int len = s.substring(level).length();
            if (s.contains(".")) {
                result = Math.max(result, map.get(level) + len);
            }
            else {
                map.put(level + 1, map.get(level) + len + 1);
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(LongestAbsoluteFilePath.solution("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(LongestAbsoluteFilePath.solution("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }

}
