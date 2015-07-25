/* BFS based solution 

L ← Empty list that will contain the sorted elements
S ← Set of all nodes with no incoming edges
while S is non-empty do
    remove a node n from S
    add n to tail of L
    for each node m with an edge e from n to m do
        remove edge e from the graph
        if m has no other incoming edges then
            insert m into S
if graph has edges then
    return error (graph has at least one cycle)
else 
    return L (a topologically sorted order)

 */

import java.util.*;

public class Solution2 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) return true;
    	/* construct adjacency list and count indegree */
    	List<Integer>[] adj = (List<Integer>[]) new LinkedList[numCourses];
    	int[] indegree = new int[numCourses];
    	for (int i = 0; i < numCourses; i++) adj[i] = (List<Integer>) new LinkedList();
    	for (int i = 0; i < prerequisites.length; i++) {
    		adj[prerequisites[i][1]].add(prerequisites[i][0]);
    		indegree[prerequisites[i][0]]++;
    	}
    	/* use queue as set, add 0 indegree vertices to the queue */
    	Deque<Integer> queue = new LinkedList();
    	for (int i = 0; i < numCourses; i++) {
    		if (indegree[i] == 0) queue.add(i);
    	}
    	/* while set is not empty */
    	while (!queue.isEmpty()) {
    		int n = queue.remove();
    		for (int neighbor : adj[n]) {
    			indegree[neighbor]--;
    			if (indegree[neighbor] == 0) queue.add(neighbor);
    		}
    	}
    	for (int i = 0; i < numCourses; i++) {
    		if (indegree[i] > 0) return false;
    	}
    	return true;
    }

    public static void main(String[] args) {
    	Solution2 sol = new Solution2();
    	int[][] p = {
    		{0, 1},
    		{1, 0}
    	};
    	System.out.println(sol.canFinish(2, p));
    }
}