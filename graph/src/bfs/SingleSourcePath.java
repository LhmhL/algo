package bfs;

import graph.AdjSet;
import graph.Graph;

import java.util.*;

// 单源路径
public class SingleSourcePath {
    private Graph g;
    private int source;
    private boolean[] visited;
    private int[] prevs;

    public SingleSourcePath(Graph g, int source) {
        this.g = g;
        this.source = source;
        this.visited = new boolean[g.getV()];
        this.prevs = new int[g.getV()];
        Arrays.fill(this.prevs, -1);
        bfs(source);
    }

    private void bfs(int v) {
        if (g == null) return;
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
                }
            }
        }
    }

    public boolean isConnected(int target) {
        validateVertex(target);
        return visited[target];
    }

    private void validateVertex(int v) {
        if (v < 0 && v >= g.getV()) {
            throw new IllegalArgumentException("顶点不合法，超出范围");
        }
    }

    public List<Integer> path(int target) {
        List<Integer> res = new ArrayList<>();
        // 1. 如果源顶点到不了目标顶点，直接返回
        if (!isConnected(target)) {
            return res;
        }
        // 2. 根据 prevs 信息找到路径
        while (target != source) {
            res.add(target);
            target = prevs[target];
        }
        res.add(source);
        // 3. 翻转
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Graph g = new AdjSet("graph/graph-bfs.txt");
        SingleSourcePath path = new SingleSourcePath(g, 0);
        System.out.println(path.path(6));
    }
}
