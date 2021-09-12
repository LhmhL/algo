package dfs;

import graph.AdjSet;
import graph.Graph;

import java.util.ArrayList;
import java.util.List;

// 深度优先遍历 单点
public class GraphDFSR {
    private Graph g;

    public GraphDFSR(Graph g) {
        this.g = g;
    }

    public List<Integer> dfs(int v) {
        List<Integer> res = new ArrayList<>();
        if (g == null) return res;
        // 用于防止一个节点被重复访问
        boolean[] visited = new boolean[g.getV()];
        dfs(v, res, visited);
        return res;
    }

    private void dfs(int v, List<Integer> res, boolean[] visited) {
        res.add(v);
        visited[v] = true;
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                dfs(w ,res, visited);
            }
        }
    }

    public static void main(String[] args) {
        Graph g = new AdjSet("graph/graph-dfs.txt");
        GraphDFSR graphDFSR2 = new GraphDFSR(g);
        System.out.println(graphDFSR2.dfs(0));
    }
}
