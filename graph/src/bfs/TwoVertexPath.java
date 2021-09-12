package bfs;

import graph.AdjSet;
import graph.Graph;

import java.util.*;

// 两点路径
public class TwoVertexPath {
    private Graph g;
    private int source;
    private int target;
    private boolean[] visited;
    private int[] prevs;

    public TwoVertexPath(Graph g, int source, int target) {
        this.g = g;
        this.source = source;
        this.target = target;
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
            if (curr == target) {
                return;
            }
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

    public boolean isConnected() {
        validateVertex(target);
        return visited[target];
    }

    private void validateVertex(int v) {
        if (v < 0 && v >= g.getV()) {
            throw new IllegalArgumentException("顶点不合法，超出范围");
        }
    }

    public List<Integer> path() {
        List<Integer> res = new ArrayList<>();
        // 1. 如果源顶点到不了目标顶点，直接返回
        if (!isConnected()) {
            return res;
        }
        // 2. 根据 prevs 信息找到路径
        int tmp = target;
        while (tmp != source) {
            res.add(tmp);
            tmp = prevs[tmp];
        }
        res.add(source);
        // 3. 翻转
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        Graph g = new AdjSet("graph/graph-bfs.txt");
        TwoVertexPath path = new TwoVertexPath(g, 0, 6);
        System.out.println(path.path());
    }
}
