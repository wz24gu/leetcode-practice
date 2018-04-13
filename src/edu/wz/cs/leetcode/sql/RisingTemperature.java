package edu.wz.cs.leetcode.sql;

/**
 * 197. Rising Temperature<br/>
 * https://leetcode.com/problems/rising-temperature<br/><br/>
 * 
 * Given a Weather table, write a SQL query to find all dates' Ids with higher temperature compared to its previous 
 * (yesterday's) dates.<br/><br/>
 * 
 * +---------+------------+------------------+<br/>
 * | Id(INT) | Date(DATE) | Temperature(INT) |<br/>
 * +---------+------------+------------------+<br/>
 * |       1 | 2015-01-01 |               10 |<br/>
 * |       2 | 2015-01-02 |               25 |<br/>
 * |       3 | 2015-01-03 |               20 |<br/>
 * |       4 | 2015-01-04 |               30 |<br/>
 * +---------+------------+------------------+<br/><br/>
 * 
 * For example, return the following Ids for the above Weather table:<br/><br/>
 * +----+<br/>
 * | Id |<br/>
 * +----+<br/>
 * |  2 |<br/>
 * |  4 |<br/>
 * +----+
 */
public class RisingTemperature {
    
    public static final String SQL = "SELECT w1.Id from Weahter w1, Weahter w2 "
                                   + "WHERE w1.Temperature > w2.Temperature AND TO_DAYS(w1.Date) = TO_DAYS(w2.Date) + 1";

}
