package bfs;

import graph.AdjSet;
import graph.Graph;

import java.util.*;

// 两点最短路径，只能用 bfs 实现
public class TwoVertexShortestPath {
    private Graph g;
    private int source;
    private int target;
    private boolean[] visited;
    private int[] prevs;
    private int[] distance;

    public TwoVertexShortestPath(Graph g, int source, int target) {
        this.g = g;
        this.source = source;
        this.target = target;
        this.visited = new boolean[g.getV()];
        this.prevs = new int[g.getV()];
        this.distance = new int[g.getV()];
        Arrays.fill(this.prevs, -1);
        Arrays.fill(this.distance, -1);
        bfs(source);
    }

    private void bfs(int v) {
        if (g == null) return;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);
        visited[v] = true;
        // 维护顶点的前一个顶点
        prevs[v] = v;
        distance[v] = 0;
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
                    // 维护顶点 w 的距离为前一个顶点的距离 +1
                    distance[w] = distance[curr] + 1;
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

    // O(n)
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

    // 返回从 source 到 target 两点之间的距离
    // O(n) -> O(1)
    public int distance() {
        validateVertex(target);
        return distance[target];
    }

    public static void main(String[] args) {
        Graph g = new AdjSet("graph/graph-bfs.txt");
        TwoVertexShortestPath path = new TwoVertexShortestPath(g, 0, 6);
        System.out.println(path.path());
        System.out.println(path.distance());
    }
}
