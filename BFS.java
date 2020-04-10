import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedOutputStream;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class BFS {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedOutputStream out = new BufferedOutputStream(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[][] adjMat = new int[n][n];
        ArrayList<ArrayList<IntegerPair>> adjList = new ArrayList<ArrayList<IntegerPair>>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<IntegerPair> newList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                adjMat[i][j] = temp;
                if (temp != 0) newList.add(new IntegerPair(j, temp));
            }

            adjList.add(newList);
        }


        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            visited[i] = 0;
            parent[i] = -1;
        }

        // start from a source
        q.add(0);
        visited[0] = 1;

        // BFS
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

class IntegerPair implements Comparable<IntegerPair> {
    protected Integer first;
    protected Integer second;

    public IntegerPair(Integer first, Integer second) {
        this.first = first;
        this.second = second;
    }

    public int compareTo(IntegerPair o) {
        if (!this.first().equals(o.first()))
            return this.first() - o.first();
        else
            return this.second() - o.second();
    }

    public Integer first() { return first; }
    public Integer second() { return second; }
}
