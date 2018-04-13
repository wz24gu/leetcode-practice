package edu.wz.cs.leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 588. Design In-Memory File System<br>
 * 
 * Design an in-memory file system to simulate the following functions:<br>
 * 
 * ls: Given a path in string format. If it is a file path, return a list that only contains this file's name. If it is 
 * a directory path, return the list of file and directory names in this directory. Your output (file and directory 
 * names together) should in lexicographic order.<br>
 * 
 * mkdir: Given a directory path that does not exist, you should make a new directory according to the path. If the 
 * middle directories in the path don't exist either, you should create them as well. This function has void return type.<br>
 * 
 * addContentToFile: Given a file path and file content in string format. If the file doesn't exist, you need to create 
 * that file containing given content. If the file already exists, you need to append given content to original content. 
 * This function has void return type.<br>
 * 
 * readContentFromFile: Given a file path, return its content in string format.<br><br>
 * 
 * Note:<br>
 * 1. You can assume all file or directory paths are absolute paths which begin with / and do not end with /except that 
 * the path is just "/".<br>
 * 2. You can assume that all operations will be passed valid parameters and users will not attempt to retrieve file 
 * content or list a directory or file that does not exist.<br>
 * 3. You can assume that all directory names and file names only contain lower-case letters, and same names won't 
 * exist in the same directory.
 */
public class DesignInMemoryFileSystem {
    
    private static class File {
        String name;
        String content;
        Map<String, File> children;
        boolean isFile;
        
        public File(String name) {
            this.name = name;
            content = "";
            children = new HashMap<String, File>();
            isFile = false;
        }
    }
    
    private File root;

    public DesignInMemoryFileSystem() {
        root = new File("/");
    }
    
    public List<String> ls(String path) {
        List<String> res = new ArrayList<>();
        File curr = root;
        
        String[] dirs = path.split("/");        
        for (String dir : dirs) {
            if (dir.length() == 0) {
                continue;
            }
            if (!curr.children.containsKey(dir)) {
                return res;
            }
            curr = curr.children.get(dir);
        }
        
        if (curr.isFile) {
            res.add(curr.name);
        }
        else {
            for (String dirName : curr.children.keySet()) {
                res.add(dirName);
            }
        }
        
        Collections.sort(res);
        return res;
    }
    
    public void mkdir(String path) {
        File curr = root;
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.length() == 0) {
                continue;
            }
            if (!curr.children.containsKey(dir)) {
                File file = new File(dir);
                curr.children.put(dir, file);
            }
            curr = curr.children.get(dir);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        File node = root;
        String[] dirs = filePath.split("/");
        for (String dir : dirs) {
            if (dir.length() == 0) {
                continue;
            }
            if (!node.children.containsKey(dir)) {
                File file = new File(dir);
                node.children.put(dir, file);
            }
            node = node.children.get(dir);
        }
        node.isFile = true;
        node.content += content;
    }
    
    public String readContentFromFile(String filePath) {
        File node = root;
        String[] dirs = filePath.split("/");        
        for (String dir : dirs) {
            if (dir.length() == 0) {
                continue;
            }
            if (!node.children.containsKey(dir)) {
                File file = new File(dir);
                node.children.put(dir, file);
            }
            node = node.children.get(dir);
        }
        return node.content;
    }

}

