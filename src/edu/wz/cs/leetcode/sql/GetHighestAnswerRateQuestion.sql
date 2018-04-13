/**
 * 578. Get Highest Answer Rate Question<br>
 * https://leetcode.com/problems/get-highest-answer-rate-question<br><br>
 * 
 * Get the highest answer rate question from a table survey_log with these columns: uid, action, question_id, answer_id, 
 * q_num, timestamp.<br>
 * 
 * uid means user id; action has these kind of values: "show", "answer", "skip"; answer_id is not null when action column 
 * is "answer", while is null for "show" and "skip"; q_num is the numeral order of the question in current session.<br>
 * 
 * Write a sql query to identify the question which has the highest answer rate.<br>
 * 
 * Example:<br>
 * Input:<br>
 * +------+-----------+--------------+------------+-----------+------------+<br>
 * | uid  | action    | question_id  | answer_id  | q_num     | timestamp  |<br>
 * +------+-----------+--------------+------------+-----------+------------+<br>
 * | 5    | show      | 285          | null       | 1         | 123        |<br>
 * | 5    | answer    | 285          | 124124     | 1         | 124        |<br>
 * | 5    | show      | 369          | null       | 2         | 125        |<br>
 * | 5    | skip      | 369          | null       | 2         | 126        |<br>
 * +------+-----------+--------------+------------+-----------+------------+<br>
 * 
 * Output:<br>
 * +-------------+<br>
 * | survey_log  |<br>
 * +-------------+<br>
 * |    285      |<br>
 * +-------------+<br>
 * 
 * Explanation:<br>
 * question 285 has answer rate 1/1, while question 369 has 0/1 answer rate, so output 285.<br>
 * 
 * Note: The highest answer rate meaning is: answer number's ratio in show number in the same question.
 */

SELECT question_id AS survey_log FROM survey_log
GROUP BY question_id
ORDER BY sum(case when action = 'answer' then 1 else 0 end) DESC LIMIT 1;


SELECT question_id AS survey_log FROM survey_log
GROUP BY question_id
ORDER BY count(answer_id) / count(q_num) DESC LIMIT 1;

