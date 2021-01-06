import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseSchedule207 {
    int[]visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int[] edge : prerequisites) graph.get(edge[0]).add(edge[1]);
        visited = new int[numCourses];
        for(int i=0; i<numCourses; i++) {
            if (!dfs(i,graph)) return false;
        }
        return true;
    }
    public boolean dfs(int course, List<List<Integer>> graph){
        visited[course] = 1; // mark it being visited
        List<Integer> eligibleCourses = graph.get(course); // get its children
        for (int eligibleCourse : eligibleCourses) {
            if (visited[eligibleCourse] == 1) return false; // has been visited while visiting its children - cycle !!!!
            if (visited[eligibleCourse] == 0) { // not visited
                if (!dfs(eligibleCourse, graph)) return false;
            }
        }
        visited[course] = 2; // mark it done visiting
        return true;
    }
}
