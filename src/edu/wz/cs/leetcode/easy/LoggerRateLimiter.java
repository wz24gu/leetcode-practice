package edu.wz.cs.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 359. Logger Rate Limiter<br>
 * https://leetcode.com/problems/logger-rate-limiter<br><br>
 * 
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed if
 * and only if it is not printed in the last 10 seconds. Given a message and a timestamp (in seconds granularity),
 * return true if the message should be printed in the given timestamp, otherwise returns false. It is possible that
 * several messages arrive roughly at the same time.
 */
public class LoggerRateLimiter {
    
    private Map<String, Integer> map;
    
    public LoggerRateLimiter() {
        map = new HashMap<String, Integer>();
    }
    
    public boolean solution(int timestamp, String message) {
        if (map.containsKey(message)) {            
            if (timestamp - map.get(message) >= 10) {
                map.put(message, timestamp);
                return true;
            }
            else {
                return false;
            }
        }
        else {
            map.put(message, timestamp);
            return true;
        }
    }
    
    public static void main(String[] args) {
        LoggerRateLimiter logger = new LoggerRateLimiter();
        System.out.println(logger.solution(1, "foo"));
        System.out.println(logger.solution(2, "bar"));
        System.out.println(logger.solution(3, "foo"));
        System.out.println(logger.solution(8, "bar"));
        System.out.println(logger.solution(10, "foo"));
        System.out.println(logger.solution(11, "foo"));
    }

}
