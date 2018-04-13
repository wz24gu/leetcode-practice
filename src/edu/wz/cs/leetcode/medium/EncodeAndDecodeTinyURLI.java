package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 535: Encode and Decode TinyURL<br>
 * https://leetcode.com/problems/encode-and-decode-tinyurl<br><br>
 * 
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it
 * returns a short URL such as http://tinyurl.com/4e9iAk. Design the encode and decode methods for the TinyURL service.
 * There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be
 * encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 */
public class EncodeAndDecodeTinyURLI {
    
    private Map<String, Integer> map1;
    private Map<Integer, String> map2;
    
    public EncodeAndDecodeTinyURLI() {
        map1 = new HashMap<>();
        map2 = new HashMap<>();
    }
    
    public String encode(String url) {
        if (!map1.containsKey(url)) {
            map1.put(url, map1.size());
            map2.put(map1.get(url), url);
        }
        return "http://tinyurl.com/" + map1.get(url);
    }
    
    public String decode(String url) {
        url = url.substring(url.lastIndexOf("/") + 1);
        if (map2.containsKey(Integer.valueOf(url))) {
            return map2.get(Integer.valueOf(url));
        }
        return null;
    }
    
    public static void main(String[] args) {
        EncodeAndDecodeTinyURLI service = new EncodeAndDecodeTinyURLI();
        String tinyUrl = service.encode("http://sina.com.cn");
        System.out.println(tinyUrl);
        System.out.println(service.decode(tinyUrl));        
    }

}
