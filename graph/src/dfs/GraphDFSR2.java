package dfs;

import graph.AdjSet;
import graph.Graph;

import java.util.ArrayList;
import java.util.List;

// 深度优先遍历
public class GraphDFSR2 {
    private Graph g;
    private List<Integer> res;
    // 用于防止一个节点被重复访问
    private boolean[] visited;

    public GraphDFSR2(Graph g) {
        this.g = g;
        if (g == null) return;
        this.res = new ArrayList<>();
        this.visited = new boolean[g.getV()];
        // 遍历图中每个顶点
        for (int v = 0; v < g.getV(); v++) {
            // 先判断，没有遍历的顶点才能进行深度优先遍历
            if (!visited[v]) {
                dfs(v);
            }
        }
    }

    private void dfs(int v) {
        res.add(v);
        visited[v] = true;
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                dfs(w);
            }
        }
    }

    public List<Integer> getRes() {
        return res;
    }

    public static void main(String[] args) {
        Graph g = new AdjSet("graph/graph-dfs.txt");
        GraphDFSR2 graphDFSR = new GraphDFSR2(g);
        System.out.println(graphDFSR.getRes());
    }
}
