package dfs;

import graph.AdjSet;
import graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 连通分量的个数
// 每个连通分量包含的顶点
public class ConnectedCV {
    private Graph g;
    private List<Integer> res;
    // 用于防止一个节点被重复访问
    // 用于求解每个连通分量包含的顶点
    private int[] visited;
    // 连通分量的个数
    private int ccCount = 0;

    public ConnectedCV(Graph g) {
        this.g = g;
        if (g == null) return;
        this.res = new ArrayList<>();
        this.visited = new int[g.getV()];
        Arrays.fill(visited, -1);
        // 遍历图中每个顶点
        for (int v = 0; v < g.getV(); v++) {
            // 先判断，没有遍历的顶点才能进行深度优先遍历
            if (visited[v] == -1) {
                ccCount++;
                dfs(v, ccCount);
            }
        }
    }

    private void dfs(int v, int ccId) {
        res.add(v);
        visited[v] = ccId;
        for (int w : g.adj(v)) {
            if (visited[w] == -1) {
                dfs(w, ccId);
            }
        }
    }

    public List<Integer> getRes() {
        return res;
    }

    public int getCcCount() {
        return ccCount;
    }

    private List<Integer>[] components1() {
        List<Integer>[] res = new ArrayList[ccCount];
        for (int i = 0; i < ccCount; i++) {
            res[i] = new ArrayList<>();
            for (int j = 0; j < visited.length; j++) {
                if (visited[j] == i + 1) {
                    res[i].add(j);
                }
            }
        }
        return res;
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
        //return g.adj(v).contains(w);
        return visited[v] == visited[w];
    }

    private void validateVertex(int v) {
        if (v < 0 && v >= g.getV()) {
            throw new IllegalArgumentException("顶点不合法，超出范围");
        }
    }

    public static void main(String[] args) {
        Graph g = new AdjSet("graph/graph-dfs.txt");
        ConnectedCV connectedCV = new ConnectedCV(g);
        System.out.println(Arrays.toString(connectedCV.components()));
        System.out.println(connectedCV.isConnected(0, 4));
    }
}
