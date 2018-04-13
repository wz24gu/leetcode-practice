package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

/**
 * 355. Design Twitter<br>
 * https://leetcode.com/problems/design-twitter<br><br>
 * 
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see 
 * the 10 most recent tweets in the user's news feed. Your design should support the following methods:<br>
 * 
 * postTweet(userId, tweetId): Compose a new tweet.<br>
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must 
 * be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least 
 * recent.<br>
 * follow(followerId, followeeId): Follower follows a followee.<br>
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 */
public class DesignTwitter {
    
    private static int timestamp = 0;
    
    private static class Tweet {
        int id;
        int time;        
        public Tweet(int id) {
            this.id = id;
            time = timestamp++;
        }
    }
    
    private static class User {
        @SuppressWarnings("unused")
        int id;
        Set<Integer> followed;
        List<Tweet> tweets;
        
        public User(int id) {
            this.id = id;
            followed = new HashSet<Integer>();
            follow(id);
            tweets = new ArrayList<Tweet>();
        }
        
        public void follow(int id) {
            followed.add(id);
        }
        
        public void unfollow(int id) {
            followed.remove(id);
        }
        
        public void post(int tid) {
            Tweet t = new Tweet(tid);
            tweets.add(t);
        }
    }
    
    private Map<Integer, User> map;    
    
    /** Initialize your data structure here. */
    public DesignTwitter() {
        map = new HashMap<Integer, User>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!map.containsKey(userId)) {
            User user = new User(userId);
            map.put(userId, user);
        }
        map.get(userId).post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<>();
        if (!map.containsKey(userId)) {
            return result;
        }
        
        User user = map.get(userId);
        Queue<Tweet> pq = new PriorityQueue<>((a, b) -> b.time - a.time);
        
        for (int id : user.followed) {
            pq.addAll(map.get(id).tweets);
        }
        
        int k = 10;
        while (k > 0 && !pq.isEmpty()) {
            result.add(pq.poll().id);
            k--;
        }
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (!map.containsKey(followerId)) {
            User follower = new User(followerId);
            map.put(followerId, follower);
        }
        if (!map.containsKey(followeeId)) {
            User followee = new User(followeeId);
            map.put(followeeId, followee);
        }
        map.get(followerId).follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (!map.containsKey(followerId) || !map.containsKey(followeeId)) {
            return;
        }
        map.get(followerId).unfollow(followeeId);
    }
    
    public static void main(String[] args) {
        DesignTwitter t = new DesignTwitter();
        t.postTweet(1, 5);
        System.out.println(t.getNewsFeed(1));
        t.follow(1, 2);
        t.postTweet(2, 6);
        System.out.println(t.getNewsFeed(1));
        t.unfollow(1, 2);
        System.out.println(t.getNewsFeed(1));
    }

}
