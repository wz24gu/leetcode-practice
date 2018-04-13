package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 609. Find Duplicate File in System<br>
 * https://leetcode.com/problems/find-duplicate-file-in-system<br><br>
 * 
 * Given a list of directory info including directory path, and all the files with contents in this directory, you need
 * to find out all the groups of duplicate files in the file system in terms of their paths.<br>
 * 
 * A group of duplicate files consists of at least two files that have exactly the same content.<br>
 * 
 * A single directory info string in the input list has the following format:<br>
 * "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"<br>
 * It means there are n files (f1.txt, f2.txt ... fn.txt with content f1_content, f2_content ... fn_content,
 * respectively) in directory root/d1/d2/.../dm. Note that n >= 1 and m >= 0. If m = 0, it means the directory is just
 * the root directory.<br>
 * 
 * The output is a list of group of duplicate file paths. For each group, it contains all the file paths of the files
 * that have the same content. A file path is a string that has the following format:<br>
 * "directory_path/file_name.txt"<br><br>
 * 
 * Note:<br>
 * 1. No order is required for the final output.<br>
 * 2. You may assume the directory name, file name and file content only has letters and digits, and the length of file
 * content is in the range of [1,50].<br>
 * 3. The number of files given is in the range of [1,20000].<br>
 * 4. You may assume no files or directories share the same name in the same directory.<br>
 * 5. You may assume each given directory info represents a unique directory. Directory path and file info are separated
 * by a single blank space.<br><br>
 * 
 * Follow-up beyond contest:<br>
 * 1. Imagine you are given a real file system, how will you search files? DFS or BFS?<br>
 * In general, BFS will use more memory then DFS. However BFS can take advantage of the locality of files in inside 
 * directories, and therefore will probably be faster<br><br>
 * 
 * 2. If the file content is very large (GB level), how will you modify your solution?<br>
 * In a real life solution we will not hash the entire file content, since it's not practical. Instead we will first map 
 * all the files according to size. Files with different sizes are guaranteed to be different. We will than hash a small 
 * part of the files with equal sizes (using MD5 for example). Only if the md5 is the same, we will compare the files byte 
 * by byte<br><br>
 * 
 * 3. If you can only read the file by 1kb each time, how will you modify your solution?<br>
 * This won't change the solution. We can create the hash from the 1kb chunks, and then read the entire file if a full 
 * byte by byte comparison is required.<br><br>
 * 
 * 4. What is the time complexity of your modified solution? What is the most time-consuming part and memory consuming
 * part of it? How to optimize?<br>
 * Time complexity is O(n^2 * k) since in worse case we might need to compare every file to all others. k is the file size<br><br>
 * 
 * 5. How to make sure the duplicated files you find are not false positive?<br>
 * We will use several filters to compare: File size, Hash and byte by byte comparisons.
 */
public class FindDuplicateFileInSystem {
    
    public static List<List<String>> solution(String[] paths) {
        List<List<String>> result = new ArrayList<>();
        if (paths == null || paths.length == 0) {
            return result;
        }
        
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] fields = path.split(" ");
            String dir = fields[0];
            for (int i = 1; i < fields.length; i++) {
                String file = fields[i];
                String filename = file.substring(0, file.indexOf("("));
                String content = file.substring(file.indexOf("(") + 1, file.indexOf(")"));
                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<String>());
                }
                map.get(content).add(dir + "/" + filename);
            }
        }
        
        for (String content : map.keySet()) {
            if (map.get(content).size() > 1) {
                result.add(map.get(content));
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};
        System.out.println(FindDuplicateFileInSystem.solution(paths));
    }

}
