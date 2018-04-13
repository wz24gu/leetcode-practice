/**
 * 597. Friend Requests I: Overall Acceptance Rate<br>
 * https://leetcode.com/problems/friend-requests-i-overall-acceptance-rate<br><br>
 * 
 * In social network like Facebook or Twitter, people send friend requests and accept others’ requests as well. Now given 
 * two tables as below:<br>
 * 
 * Table: friend_request<br>
 * | sender_id | send_to_id |request_date|<br>
 * |-----------|------------|------------|<br>
 * | 1         | 2          | 2016_06-01 |<br>
 * | 1         | 3          | 2016_06-01 |<br>
 * | 1         | 4          | 2016_06-01 |<br>
 * | 2         | 3          | 2016_06-02 |<br>
 * | 3         | 4          | 2016-06-09 |<br>
 * 
 * Table: request_accepted<br>
 * | requester_id | accepter_id |accept_date |<br>
 * |--------------|-------------|------------|<br>
 * | 1            | 2           | 2016_06-03 |<br>
 * | 1            | 3           | 2016-06-08 |<br>
 * | 2            | 3           | 2016-06-08 |<br>
 * | 3            | 4           | 2016-06-09 |<br>
 * | 3            | 4           | 2016-06-10 |<br>
 * 
 * Write a query to find the overall acceptance rate of requests rounded to 2 decimals, which is the number of acceptance 
 * divide the number of requests.<br>
 * 
 * For the sample data above, your query should return the following result.<br>
 * 
 * |accept_rate|<br>
 * |-----------|<br>
 * |       0.80|<br>
 * 
 * Note:<br>
 * 1. The accepted requests are not necessarily from the table friend_request. In this case, you just need to simply 
 * count the total accepted requests (no matter whether they are in the original requests), and divide it by the number 
 * of requests to get the acceptance rate.<br>
 * 2. It is possible that a sender sends multiple requests to the same receiver, and a request could be accepted more 
 * than once. In this case, the 'duplicated' requests or acceptances are only counted once.<br>
 * 3. If there is no requests at all, you should return 0.00 as the accept_rate.<br>
 * 
 * Explanation: There are 4 unique accepted requests, and there are 5 requests in total. So the rate is 0.80.<br>
 * 
 * Follow-up:<br>
 * 1. Can you write a query to return the accept rate but for every month?<br>
 * 2. How about the cumulative accept rate for every day?
 */

select ifnull(
  (select round(count(distinct requester_id, accepter_id) / count(distinct sender_id, send_to_id), 2) from request_accepted, friend_request),
0) as accept_rate;
