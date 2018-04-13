package edu.wz.cs.leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 811. Subdomain Visit Count<br>
 * https://leetcode.com/problems/subdomain-visit-count<br><br>
 * 
 * A website domain like "discuss.leetcode.com" consists of various subdomains. At the top level, we have "com", at the 
 * next level, we have "leetcode.com", and at the lowest level, "discuss.leetcode.com". When we visit a domain like 
 * "discuss.leetcode.com", we will also visit the parent domains "leetcode.com" and "com" implicitly.<br>
 * 
 * Now, call a "count-paired domain" to be a count (representing the number of visits this domain received), followed by 
 * a space, followed by the address. An example of a count-paired domain might be "9001 discuss.leetcode.com".<br>
 * 
 * We are given a list cpdomains of count-paired domains. We would like a list of count-paired domains, (in the same 
 * format as the input, and in any order), that explicitly counts the number of visits to each subdomain.<br><br>
 * 
 * Notes:<br>
 * 1. The length of cpdomains will not exceed 100.<br>
 * 2. The length of each domain name will not exceed 100.<br>
 * 3. Each address will have either 1 or 2 "." characters.<br>
 * 4. The input count in any count-paired domain will not exceed 10000.<br>
 * 5. The answer output can be returned in any order.
 */
public class SubdomainVisitCount {
    
    public static List<String> solution(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String domain : cpdomains) {
            int i = domain.indexOf(" ");
            int n = Integer.parseInt(domain.substring(0, i));
            
            String s = domain.substring(i + 1);
            map.put(s, map.getOrDefault(s, 0) + n);
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '.') {
                    String d = s.substring(j + 1);
                    map.put(d, map.getOrDefault(d, 0) + n);
                }
            }
        }
        
        List<String> res = new ArrayList<>();
        for (String d : map.keySet()) {
            res.add(map.get(d) + " " + d);
        }
        return res;   
    }
    
    public static void main(String[] args) {
        String[] cpdomains = {"9001 discuss.leetcode.com"};
        System.out.println(SubdomainVisitCount.solution(cpdomains));
        
        String[] cpdomains2 = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(SubdomainVisitCount.solution(cpdomains2));
    }

}
