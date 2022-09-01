package src.Hard;
/*
 * TIME LIMIT EXCEEDED on my personal solution. A solution after refering to the solution on LC is below
 */
import java.util.*;

class Solution {
    int[] memo;
    List<Job> jobs;
    int numJobs;
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        jobs = new ArrayList<Job>();
        int maxTime = 0;
        numJobs = startTime.length;
        if (numJobs == 0) return 0;
        for(int i = 0; i < numJobs; i++){
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
            maxTime = Math.max(maxTime, endTime[i]);
        }
        Collections.sort(jobs);
        memo = new int[numJobs + 1];
        Arrays.fill(memo, -1);
        return findMaxProfit(0);
    }
    
    public int findNextJob(int lastEndingTime) {
        int start = 0;
        int end = numJobs - 1;
        int nextIndex = numJobs;
        
        while(start<= end) {
            int mid = (start + end) / 2;
            if (jobs.get(mid).start >= lastEndingTime) {
                nextIndex = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nextIndex;
    }
    
    public int findMaxProfit(int position) {
        if (position == numJobs) return 0;
        if (memo[position] != -1) return memo[position];
        
        int nextIndex = findNextJob(jobs.get(position).end);
        
        int maxProfit = Math.max(findMaxProfit(position + 1), jobs.get(position).profit + findMaxProfit(nextIndex));
        
        return memo[position] = maxProfit;
    }
}


class Job implements Comparable<Job>{
    int start;
    int end;
    int profit;
    public Job(int start, int end, int profit) {
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
    
    public int compareTo(Job o) {
        return this.start - o.start;
    }
    
    @Override
    public String toString() {
        return "(" + start + " to " + end + " for $" + profit +")";
    }
}


class Solution2 {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<Job>();
        int maxTime = 0;
        int numJobs = startTime.length;
        if (numJobs == 0) return 0;
        for(int i = 0; i < numJobs; i++){
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
            maxTime = Math.max(maxTime, endTime[i]);
        }
        Collections.sort(jobs);
        int[] maxProfit = new int[maxTime + 1];
        for(Job curr : jobs) {
            int profitAfterJob = curr.profit + maxProfit[curr.start];
            for(int j = curr.end; j <= maxTime; j++) {
                if (maxProfit[j] >= profitAfterJob) break;
                maxProfit[j] = profitAfterJob;
            }
        }
        return maxProfit[maxTime];
        
    }
}