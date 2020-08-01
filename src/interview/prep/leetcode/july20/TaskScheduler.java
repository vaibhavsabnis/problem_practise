package interview.prep.leetcode.july20;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * Task Scheduler

Solution
You are given a char array representing tasks CPU need to do. It contains capital letters A to Z where each letter represents a different task. Tasks could be done without the original order of the array. Each task is done in one unit of time. For each unit of time, the CPU could complete either one task or just be idle.

However, there is a non-negative integer n that represents the cooldown period between two same tasks (the same letter in the array), that is that there must be at least n units of time between any two same tasks.

You need to return the least number of units of times that the CPU will take to finish all the given tasks.

 

Example 1:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: 
A -> B -> idle -> A -> B -> idle -> A -> B
There is at least 2 units of time between any two same tasks.
Example 2:

Input: tasks = ["A","A","A","B","B","B"], n = 0
Output: 6
Explanation: On this case any permutation of size 6 would work since n = 0.
["A","A","A","B","B","B"]
["A","B","A","B","A","B"]
["B","B","B","A","A","A"]
...
And so on.
Example 3:

Input: tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
Output: 16
Explanation: 
One possible solution is
A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> idle -> idle -> A -> idle -> idle -> A
 

Constraints:

The number of tasks is in the range [1, 10000].
The integer n is in the range [0, 100].
 */
public class TaskScheduler {
	public int leastInterval(char[] tasks, int n) {
        if (tasks.length ==0)
            return 0;
        if (n ==0)
            return tasks.length; 
        
        int totalTime = 0; 
        
        Map<Character, Integer> taskCnt = new HashMap<>();
        for(char c: tasks)
            taskCnt.put(c,taskCnt.getOrDefault(c,0)+1);
        
        if(taskCnt.size() ==1)
        	return tasks.length;
        
        int[] cooldown= new int[26];
        //Arrays.fill(cooldown, Integer.MIN_VALUE);
        
        for(char x = 'A'; x<='Z'; x++){
            if(taskCnt.get(x)!=null)
            	cooldown[x-'A'] = 0;
        }
        
        int idleTime = 0;
        while(taskCnt.size()>0) {
        	boolean taskExecutedInThisRun = false; 
        	//get task
        	//check cooldown (if non-zero put it back) and check next task.
        	Iterator<Character> iter = taskCnt.keySet().iterator();
        	while (iter.hasNext()) {
        		Character task = iter.next();
        		if(taskCnt.get(task)!=null && cooldown[task-'A']>0)
        			continue;
        		else {
        			taskCnt.put(task, taskCnt.get(task)-1);
        			System.out.print(task+"-->");
        			cooldown[task-'A'] =n;
        			totalTime++;
        			taskExecutedInThisRun =true;
        	        for(char x = 'A'; x<='Z'; x++){
        	            if(taskCnt.get(x)!=null && x != task)
        	            	cooldown[x-'A'] -= 1;
        	        }
        		}
        	}
        	if(!taskExecutedInThisRun) {
        		idleTime++;
        		System.out.print("idleTime-->");
        		for(int i=0; i<26;i++)
        			cooldown[i] -= 1;
        	}
        		
        	for(char x = 'A'; x<='Z'; x++){
        		if(taskCnt.get(x)!=null && taskCnt.get(x)<=0)
        			taskCnt.remove(x);
        	}
        }        
        return totalTime +idleTime;
	}
}
