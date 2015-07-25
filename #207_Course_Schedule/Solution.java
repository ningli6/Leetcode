import java.util.*;

public class Solution {

	boolean[] isVisited;
	List<Integer>[] adj;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true;
    	adj = (List<Integer>[]) new LinkedList[numCourses];
    	for (int i = 0; i < numCourses; i++)
    		adj[i] = (List<Integer>) new LinkedList();
    	isVisited = new boolean[numCourses];
    	for (int i = 0; i < prerequisites.length; i++) {
    		adj[prerequisites[i][1]].add(prerequisites[i][0]);
    	}
    	for (int i = 0; i < numCourses; i++) {
    		if (adj[i].isEmpty()) continue;
    		if (dfs(i)) return false;
    	}
    	return true;
    }

    // true if is visited before
    private boolean dfs(int i) {
    	if (isVisited[i]) return true;
    	isVisited[i] = true;
    	for (int neighbor : adj[i]) {
    		if (dfs(neighbor)) return true;
    	}
    	isVisited[i] = false;
    	return false;
    }

    public static void main(String[] args) {
    	Solution sol = new Solution();
    	int[][] p = {
    		{0, 1}
    	};
    	System.out.println(sol.canFinish(2, p));
    }
}