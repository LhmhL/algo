package bfs;

import graph.AdjSet;
import graph.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 环检测
public class CycleDetection {
    private Graph g;
    private boolean[] visited;
    private int[] prevs;
    private boolean hasCycle = false;

    public CycleDetection(Graph g) {
        this.g = g;
        this.visited = new boolean[g.getV()];
        this.prevs = new int[g.getV()];
        Arrays.fill(this.prevs, -1);
        for (int v = 0; v < g.getV(); v++) {
            if (!visited[v]) {
                if (bfs(v)) {
                    hasCycle = true;
                    break;
                }
            }
        }
    }

    private boolean bfs(int v) {
        if (g == null) return false;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        // 维护顶点的前一个顶点
        prevs[v] = v;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            for (int w : g.adj(curr)) {
                if (!visited[w]) {
                    queue.add(w);
                    visited[w] = true;
                    // 维护顶点的前一个顶点
                    prevs[w] = curr;
                } else {
                    // 到了这里，说明：当前节点 curr 的相邻顶点 w 已经被访问
                    // 如果 w 又不是 curr 的前一个节点的话，那么就存在环
                    if (w != prevs[curr]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        Graph g = new AdjSet("graph/graph-bfs.txt");
        CycleDetection cycleD = new CycleDetection(g);
        System.out.println(cycleD.hasCycle());
    }
}
