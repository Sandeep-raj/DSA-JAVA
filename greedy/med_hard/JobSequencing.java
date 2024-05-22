package greedy.med_hard;

import java.util.Arrays;

/*
 * Job Sequencing Problem
 * 
 * Given a set of N jobs where each jobi has a deadline and profit associated with it.
Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with job if and only if the job is completed by its deadline.
Find the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job. Deadline of the job is the time before which job needs to be completed to earn the profit.


Input:
N = 4
Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
Output:
2 60
Explanation:
Job1 and Job3 can be done with
maximum profit of 60 (20+40).


Input:
N = 5
Jobs = {(1,2,100),(2,1,19),(3,2,27),
        (4,1,25),(5,1,15)}
Output:
2 127
Explanation:
2 jobs can be done with
maximum profit of 127 (100+27).


Your Task :
You don't need to read input or print anything. Your task is to complete the function JobScheduling() which takes an integer N and an array of Jobs(Job id, Deadline, Profit) as input and returns the count of jobs and maximum profit as a list or vector of 2 elements.


Expected Time Complexity: O(NlogN)
Expected Auxilliary Space: O(N)


Constraints:
1 <= N <= 105
1 <= Deadline <= N
1 <= Profit <= 500
 */

public class JobSequencing {
    static class Job {
        int JobId;
        int Deadline;
        int Profit;

        public Job(int id,int dead,int profit) {
            this.JobId = id;
            this.Deadline = dead;
            this.Profit = profit;
        }
    }
    public static int[] scheduling(int[][] jobs) {
        Job[] jobArr = new Job[jobs.length];
        for(int i = 0; i < jobs.length; i++) {
            jobArr[i] = new Job(jobs[i][0] , jobs[i][1], jobs[i][2] );
        }

        Arrays.sort(jobArr,(a,b) -> (b.Profit - a.Profit));

        int maxDeadLine = 0;
        for(int i = 0; i < jobArr.length; i++) {
            maxDeadLine = Math.max(jobArr[i].Deadline, maxDeadLine);
        }

        int[] jobProcessed = new int[maxDeadLine];
        for(int i = 0; i < maxDeadLine; i++) {
            jobProcessed[i] = -1;
        }

        int jobsTaken = 0, maxProfit = 0;
        for(int i = 0; i < jobArr.length; i++) {
            int currIdx = jobArr[i].Deadline - 1;
            while (currIdx >= 0 && jobProcessed[currIdx] > 0) {
                currIdx--;
            }

            if(currIdx >= 0 && jobProcessed[currIdx] < 0) {
                jobProcessed[currIdx] = jobArr[i].JobId;
                jobsTaken++;
                maxProfit += jobArr[i].Profit;
            }
        }

        return new int[]{jobsTaken, maxProfit};
    }
}
