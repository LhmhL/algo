package bfs;

import graph.AdjSet;
import graph.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 二分图检测
public class BipartitionDetection {
    private Graph g;
    private boolean[] visited;
    // -1 表示没有染颜色
    // 0 红色 1 蓝色
    private int[] colors;
    private boolean isBipartition = true;

    public BipartitionDetection(Graph g) {
        this.g = g;
        this.visited = new boolean[g.getV()];
        this.colors = new int[g.getV()];
        Arrays.fill(this.colors, -1);
        for (int v = 0; v < g.getV(); v++) {
            if (!visited[v]) {
                if (!bfs(v)) {
                    isBipartition = false;
                    break;
                }
            }
        }
    }

    private boolean bfs(int v) {
        if (g == null) return true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        colors[v] = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int w : g.adj(curr)) {
                // 如果 w 没有遍历过，则需要染色
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                    // 给 w 染色，和 curr 的颜色不一样
                    colors[w] = 1 - colors[curr];
                } else if (colors[w] == colors[curr]) {
                    // 如果 w 被访问过，并且它的颜色和相邻点一样
                    // 那么可以判定不是二分图
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartition() {
        return isBipartition;
    }

    public static void main(String[] args) {
        Graph g = new AdjSet("graph/graph-bfs.txt");
        BipartitionDetection bipartitionD = new BipartitionDetection(g);
        System.out.println(bipartitionD.isBipartition());
    }
}
