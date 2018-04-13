package edu.wz.cs.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 635. Design Log Storage System<br>
 * https://leetcode.com/problems/design-log-storage-system<br><br>
 * 
 * You are given several logs that each log contains a unique id and timestamp. Timestamp is a string that has the 
 * following format: Year:Month:Day:Hour:Minute:Second, for example, 2017:01:01:23:59:59. All domains are zero-padded 
 * decimal numbers.<br>
 * 
 * Design a log storage system to implement the following functions:<br>
 * void Put(int id, string timestamp): Given a log's unique id and timestamp, store the log in your storage system.<br>
 * 
 * int[] Retrieve(String start, String end, String granularity): Return the id of logs whose timestamps are within the 
 * range from start to end. Start and end all have the same format as timestamp. However, granularity means the time 
 * level for consideration. For example, start = "2017:01:01:23:59:59", end = "2017:01:02:23:59:59", 
 * granularity = "Day", it means that we need to find the logs within the range from Jan. 1st 2017 to Jan. 2nd 2017.<br><br>
 * 
 * Note:<br>
 * 1. There will be at most 300 operations of Put or Retrieve.<br>
 * 2. Year ranges from [2000,2017]. Hour ranges from [00,23].<br>
 * 3. Output for Retrieve has no order required.
 */
public class DesignLogStorageSystem {
    
    private static class Pair {
        public int id;
        public String timestamp;
        public Pair(int id, String timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
    }
    
    private static final String[] units = {"Year", "Month", "Day", "Hour", "Minute", "Second"};
    private static final int[] indices = {4, 7, 10, 13, 16, 19};
    private List<Pair> list;
    
    public DesignLogStorageSystem() {
        list = new ArrayList<Pair>();
    }

    public void put(int id, String timestamp) {
        list.add(new Pair(id, timestamp));
    }
    
    public List<Integer> retrieve(String start, String end, String granularity) {
        List<Integer> result = new ArrayList<>();        
        int index = findIndex(granularity);
        for (Pair pair : list) {
            String t = pair.timestamp;
            if (t.substring(0, index).compareTo(start.substring(0, index)) >= 0 &&
                    t.substring(0, index).compareTo(end.substring(0, index)) <= 0) {
                result.add(pair.id);
            }
        }
        return result;
    }
    
    private int findIndex(String unit) {
        for (int i = 0; i < units.length; i++) {
            if (unit.equals(units[i])) {
                return indices[i];
            }
        }
        throw new NoSuchElementException();
    }
    
    public static void main(String[] args) {
        DesignLogStorageSystem system = new DesignLogStorageSystem();
        system.put(1, "2017:01:01:23:59:59");
        system.put(2, "2017:01:01:22:59:59");
        system.put(3, "2016:01:01:00:00:00");
        System.out.println(system.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year"));
        System.out.println(system.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour"));
    }

}
