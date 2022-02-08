package week4.Task_Scheduling;

import java.util.*;

class Solution {

    /**
     * Computes how fast the given tasks can be finished by the given number of TAs.
     * @param durations Array containing the duration for each tasks.
     * @param n Number of TAs to complete the tasks.
     * @return The shortest time in which all tasks can be completed.
     */
    public static int completeTasks(int[] durations, int n) {
        // TODO
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(int i=0;i<n;i++)pq.add(0);
        for(int i=0;i<durations.length;i++){
            //        System.out.println(durations[i]);
            pq.add(pq.poll()+durations[i]);
        }
        int ans = 0;
        while(!pq.isEmpty())ans = pq.poll();
        return ans;
    }
}