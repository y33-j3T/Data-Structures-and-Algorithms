import java.util.ArrayList;

public class DFS {

    public static void _DFS(int source, int[] parent, int[] visited, ArrayList<ArrayList<IntegerPair>> adjList) {
        visited[source] = 1;
        
        for (IntegerPair v : adjList.get(source)) {
            int val = v.first();
            if (visited[val] == 0) {
                parent[val] = source;
                _DFS(val, parent, visited, adjList);
            }
        }

        // after DFS stops, we can use info stored in visited / parent
    }
}
