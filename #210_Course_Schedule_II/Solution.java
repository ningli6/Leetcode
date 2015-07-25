import java.util.*;

public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> result = new ArrayList<Integer>(numCourses);
        int[] array = new int[0];
        if (numCourses <= 0) return array;
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) {
        	array = new int[numCourses];
        	for (int i = 0; i < numCourses; i++) array[i] = i;
        	return array;
        }
        /* construct adjacency list and indegree */
        List<Integer>[] adj = (List<Integer>[]) new LinkedList[numCourses];
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) adj[i] = new LinkedList();
        for (int i = 0; i < prerequisites.length; i++) {
        	adj[prerequisites[i][1]].add(prerequisites[i][0]);
        	indegree[prerequisites[i][0]]++;
        }
        /* use a queue to store 0 indegree vertices */
        Deque<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
        	if (indegree[i] == 0) queue.add(i);
        }
        /* bfs */
        while (!queue.isEmpty()) {
        	int n = queue.remove();
        	result.add(n);
        	for (int neighbor : adj[n]) {
        		indegree[neighbor]--;
        		if (indegree[neighbor] == 0) queue.add(neighbor);
        	}
        }
        /* check if DAG */
        for (int i = 0; i < numCourses; i++) {
        	if (indegree[i] != 0) return array;
        }
        array = new int[numCourses];
        int index = 0;
        for (int it : result) {
        	array[index++] = it;
        }
        return array;
    }

    public static void main(String[] args) {
    	int[][] t = {{1,0},{2,0},{3,1},{3,2}};
    	Solution sol = new Solution();
    	int[] result = sol.findOrder(4, t);
    	for (int it : result) {
    		System.out.print(it + " ");
    	}
    	System.out.println();
    }
}