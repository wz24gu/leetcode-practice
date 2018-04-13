package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 534. Design TinyURL
 */
public class TinyURLService {    
    
    private static final String DICT = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String PREFIX = "http://tiny.url/";
    private int counter;
    private Map<String, Integer> map1;
    private Map<Integer, String> map2;
    
    public TinyURLService() {
        counter = 1;
        map1 = new HashMap<String, Integer>();
        map2 = new HashMap<Integer, String>();
    }
    
    public String encode(String url) {
        String tinyUrl = toBase62(counter);
        map1.put(url, counter);
        map2.put(counter, url);
        counter++;
        return PREFIX + tinyUrl;
    }
    
    public String decode(String tinyUrl) {
        tinyUrl = tinyUrl.substring(PREFIX.length());
        int n = toCounter(tinyUrl);
        return map2.get(n);
    }
    
    private String toBase62(int n) {
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            sb.insert(0, DICT.charAt(n % 62));
            n /= 62;
        }
        while (sb.length() < 6) {
            sb.insert(0, '0');
        }
        return sb.toString();
    }
    
    private int toCounter(String s) {
        int counter = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            counter = counter * 62 + convert(s.charAt(i));
        }
        return counter;        
    }
    
    private int convert(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';
        }
        else if (c >= 'a' && c <= 'z') {
            return c - 'a' + 10;
        }
        else if (c >= 'A' && c <= 'Z') {
            return c - 'A' + 36;
        }
        return -1;
    }
    
    public static void main(String[] args) {
        TinyURLService service = new TinyURLService();
        String tinyUrl = service.encode("http://sina.com.cn");
        System.out.println(tinyUrl);
        System.out.println(service.decode(tinyUrl));
    }

}
