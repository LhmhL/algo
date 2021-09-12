package direct;

import graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 广度优先遍历
public class GraphBFS {
    private Graph g;
    private boolean[] visited;
    private List<Integer> res;

    public GraphBFS(Graph g) {
        this.g = g;
        this.visited = new boolean[g.getV()];
        this.res = new ArrayList<>();
        for (int v = 0; v < g.getV(); v++) {
            if (!visited[v]) bfs(v);
        }
    }

    private void bfs(int v) {
        if (g == null) return;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            res.add(curr);
            for (int w : g.adj(curr)) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                }
            }
        }
    }

    public List<Integer> getRes() {
        return res;
    }

    public static void main(String[] args) {
        Graph g1 = new GraphImpl("graph/graph-bfs.txt", false);
        GraphBFS graphBFS1 = new GraphBFS(g1);
        System.out.println(graphBFS1.getRes());
        Graph g2 = new GraphImpl("graph/graph-bfs.txt", true);
        GraphBFS graphBFS2 = new GraphBFS(g2);
        System.out.println(graphBFS2.getRes());
    }
}
