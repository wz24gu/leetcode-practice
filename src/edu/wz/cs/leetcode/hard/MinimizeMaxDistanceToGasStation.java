package edu.wz.cs.leetcode.hard;

/**
 * 774. Minimize Max Distance to Gas Station<br>
 * https://leetcode.com/problems/minimize-max-distance-to-gas-station<br><br>
 * 
 * On a horizontal number line, we have gas stations at positions stations[0], stations[1], ..., stations[N-1], where 
 * N = stations.length.<br>
 * 
 * Now, we add K more gas stations so that D, the maximum distance between adjacent gas stations, is minimized.<br>
 * 
 * Return the smallest possible value of D.<br><br>
 * 
 * Note:<br>
 * 1. stations.length will be an integer in range [10, 2000].<br>
 * 2. stations[i] will be an integer in range [0, 10^8].<br>
 * 3. K will be an integer in range [1, 10^6].<br>
 * 4. Answers within 10^-6 of the true value will be accepted as correct.
 */
public class MinimizeMaxDistanceToGasStation {
    
    public static double solution(int[] stations, int K) {
        int n = stations.length;
        double count = 0;
        
        double left = 0;
        double right = stations[n-1] - stations[0];
        while (left + 1e-6 < right) {
            double mid = (left + right) / 2;
            count = 0;
            for (int i = 0; i < n - 1; i++) {
                count += Math.ceil((stations[i+1] - stations[i]) / mid) - 1;
                if (count > K) {
                    left = mid;
                }
                else {
                    right = mid;
                }
            }
        }
        return right;
    }
    
    public static void main(String[] args) {
        int[] stations = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(MinimizeMaxDistanceToGasStation.solution(stations, 9));
    }

}
