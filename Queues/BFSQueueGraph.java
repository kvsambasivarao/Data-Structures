import java.util.LinkedList;
import java.util.Queue;

public class BFSQueueGraph {

    static int[][] adj = {
        {0,1,1,0,0,0,0},  // S
        {0,0,1,1,1,0,0},  // A
        {0,0,0,0,1,1,0},  // F
        {0,0,0,0,0,0,1},  // C
        {0,0,0,0,0,0,0},  // G
        {0,0,0,0,0,0,0},  // H
        {0,0,0,0,0,0,0}   // D
    };

    static char[] nodes = {'S','A','F','C','G','H','D'};
    static int V = 7;

    static void bfs(int start) {
        boolean[] visited = new boolean[V];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(nodes[v] + " ");

            for (int i = 0; i < V; i++) {
                if (adj[v][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public static void main(String[] args) {
        bfs(0);   // Start BFS from S
    }
}
