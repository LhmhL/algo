package bfs;

import graph.AdjSet;
import graph.Graph;

import java.util.*;

// 连通分量的个数
// 每个连通分量包含的顶点
public class ConnectedCV {
    private Graph g;
    private int[] visited;
    private int ccCount;

    public ConnectedCV(Graph g) {
        this.g = g;
        this.visited = new int[g.getV()];
        Arrays.fill(visited, -1);
        for (int v = 0; v < g.getV(); v++) {
            if (visited[v] ==  -1) {
                ccCount++;
                bfs(v, ccCount);
            }
        }
    }

    private void bfs(int v, int ccId) {
        if (g == null) return;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = ccId;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int w : g.adj(curr)) {
                if (visited[w] == -1) {
                    queue.add(w);
                    visited[w] = ccId;
                }
            }
        }
    }

    public int getCcCount() {
        return ccCount;
    }

    public List<Integer>[] components() {
        List<Integer>[] res = new ArrayList[ccCount];
        for (int i = 0; i < ccCount; i++) {
            res[i] = new ArrayList<>();
        }
        for (int v = 0; v < g.getV(); v++) {
            int cc = visited[v];
            res[cc - 1].add(v);
        }
        return res;
    }

    public boolean isConnected(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        return visited[v] == visited[w];
    }

    private void validateVertex(int v) {
        if (v < 0 && v >= g.getV()) {
            throw new IllegalArgumentException("顶点不合法，超出范围");
        }
    }

    public static void main(String[] args) {
        Graph g = new AdjSet("graph/graph-bfs.txt");
        ConnectedCV connectedCV = new ConnectedCV(g);
        System.out.println(Arrays.toString(connectedCV.components()));
        System.out.println(connectedCV.isConnected(0, 4));
    }
}
