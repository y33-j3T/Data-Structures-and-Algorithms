import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BFS {

    public static void _BFS(int source, int[] parent, int[] visited, ArrayList<ArrayList<IntegerPair>> adjList) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        visited[source] = 1;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (IntegerPair v : adjList.get(u)) {
                int val = v.first();
                if (visited[val] == 0) {
                    visited[val] = 1;
                    parent[val] = u;
                    q.add(val);
                }
            }
        }

        // after BFS stops, we can use info stored in visited / parent
    }
}
