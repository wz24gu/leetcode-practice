package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 721. Accounts Merge<br>
 * https://leetcode.com/problems/accounts-merge<br><br>
 * 
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a 
 * name, and the rest of the elements are emails representing emails of the account.<br>
 * 
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email 
 * that is common to both accounts. Note that even if two accounts have the same name, they may belong to different 
 * people as people could have the same name. A person can have any number of accounts initially, but all of their 
 * accounts definitely have the same name.<br>
 * 
 * After merging the accounts, return the accounts in the following format: the first element of each account is the 
 * name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.<br><br>
 * 
 * Note:<br><br>
 * 1. The length of accounts will be in the range [1, 1000].<br>
 * 2. The length of accounts[i] will be in the range [1, 10].<br>
 * 3. The length of accounts[i][j] will be in the range [1, 30].
 */
public class AccountsMerge {
    
    public static List<List<String>> solution(List<List<String>> accounts) {
        Map<String, String> owner = new HashMap<>();
        Map<String, String> parent = new HashMap<>();
        Map<String, Set<String>> union = new HashMap<>();
        
        for (List<String> a : accounts) {
            for (int i = 1; i < a.size(); i++) {
                parent.put(a.get(i), a.get(i));
                owner.put(a.get(i), a.get(0));
            }
        }
        
        for (List<String> a: accounts) {
            String p = find(parent, a.get(1));
            for (int i = 2; i < a.size(); i++) {
                parent.put(find(parent, a.get(i)), p);
            }
        }
        
        for (List<String> a : accounts) {
            String p = find(parent, a.get(1));
            if (!union.containsKey(p)) {
                union.put(p, new TreeSet<>());
            }
            for (int i = 1; i < a.size(); i++) {
                union.get(p).add(a.get(i));
            }
        }
        
        List<List<String>> res = new ArrayList<>();
        for (String p : union.keySet()) {
            List<String> account = new ArrayList<>(union.get(p));
            account.add(0, owner.get(p));
            res.add(account);
        }
        return res;
    }
    
    private static String find(Map<String, String> parent, String s) {
        return parent.get(s).equals(s) ? s : find(parent, parent.get(s));
    }
    
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"));
        accounts.add(Arrays.asList("John", "johnnybravo@mail.com"));
        accounts.add(Arrays.asList("Mary", "mary@mail.com"));
        accounts.add(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"));
        System.out.println(AccountsMerge.solution(accounts));        
    }

}
