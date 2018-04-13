package edu.wz.cs.leetcode.sql;

/**
 * 178. Rank Scores<br>
 * https://leetcode.com/problems/rank-scores<br><br>
 * 
 * Write a SQL query to rank scores. If there is a tie between two scores, both should have the same ranking. Note that 
 * after a tie, the next ranking number should be the next consecutive integer value. In other words, there should be 
 * no "holes" between ranks.<br>
 * 
 * +----+-------+<br>
 * | Id | Score |<br>
 * +----+-------+<br>
 * | 1  | 3.50  |<br>
 * | 2  | 3.65  |<br>
 * | 3  | 4.00  |<br>
 * | 4  | 3.85  |<br>
 * | 5  | 4.00  |<br>
 * | 6  | 3.65  |<br>
 * +----+-------+<br>
 * 
 * For example, given the above Scores table, your query should generate the following report (order by highest score):<br>
 * 
 * +-------+------+<br>
 * | Score | Rank |<br>
 * +-------+------+<br>
 * | 4.00  | 1    |<br>
 * | 4.00  | 1    |<br>
 * | 3.85  | 2    |<br>
 * | 3.65  | 3    |<br>
 * | 3.65  | 3    |<br>
 * | 3.50  | 4    |<br>
 * +-------+------+<br>
 * 
 */
public class RankScores {

    public static final String SQL = "SELECT Score, "
                                   + "(SELECT COUNT(DISTINCT Score) FROME Scores s1 Where s1.Score > s2.Score) Rank "
                                   + "FROM Scores s2 ORDER BY Score DESC";
    
}
