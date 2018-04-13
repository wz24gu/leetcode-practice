package edu.wz.cs.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 535. Encode And Decode Tiny URL II<br>
 * https://leetcode.com/problems/encode-and-decode-tinyurl<br><br>
 * 
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it 
 * returns a short URL such as http://tinyurl.com/4e9iAk.<br>
 * 
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode 
 * algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be 
 * decoded to the original URL.
 */
public class EncodeAndDecodeTinyURLII {
    
    private static final String DICT = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
    private static final String PREFIX = "http://tinyurl.com/";
    private Map<String, String> tiny2long;
    private Map<String, String> long2tiny;
    private Random rand;
    
    public EncodeAndDecodeTinyURLII() {
        tiny2long = new HashMap<String, String>();  // long -> tiny
        long2tiny = new HashMap<String, String>();  // tiny -> long
        rand = new Random();
    }
    
    public String encode(String longUrl) {
        if (long2tiny.containsKey(longUrl)) {
            return PREFIX + long2tiny.get(longUrl);
        }
        
        String tinyUrl = generate(longUrl);
        tiny2long.put(tinyUrl, longUrl);
        long2tiny.put(longUrl, tinyUrl);
        return PREFIX + tinyUrl;
    }
    
    public String decode(String tinyUrl) {
        tinyUrl = tinyUrl.substring(PREFIX.length());
        if (tiny2long.containsKey(tinyUrl)) {
            return tiny2long.get(tinyUrl);
        }
        else {
            return "";
        }
    }
    
    private String generate(String longUrl) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            sb.append(DICT.charAt(rand.nextInt(DICT.length())));
        }
        
        String tinyUrl = sb.toString();
        while (tiny2long.containsKey(tinyUrl)) {
            tinyUrl = generate(longUrl);
        }
        return tinyUrl;
    }
    
    public static void main(String[] args) {
        EncodeAndDecodeTinyURLII service = new EncodeAndDecodeTinyURLII();
        String tinyUrl = service.encode("http://sina.com.cn");
        System.out.println(tinyUrl);
        System.out.println(service.decode(tinyUrl));
    }

}
