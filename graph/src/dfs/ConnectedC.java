package dfs;

import graph.AdjSet;
import graph.Graph;

import java.util.ArrayList;
import java.util.List;

// 连通分量的个数
public class ConnectedC {
    private Graph g;
    private List<Integer> res;
    // 用于防止一个节点被重复访问
    private boolean[] visited;
    // 连通分量的个数
    private int ccCount = 0;

    public ConnectedC(Graph g) {
        this.g = g;
        if (g == null) return;
        this.res = new ArrayList<>();
        this.visited = new boolean[g.getV()];
        // 遍历图中每个顶点
        for (int v = 0; v < g.getV(); v++) {
            // 先判断，没有遍历的顶点才能进行深度优先遍历
            if (!visited[v]) {
                ccCount++;
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

    public int getCcCount() {
        return ccCount;
    }

    public static void main(String[] args) {
        Graph g = new AdjSet("graph/graph-dfs.txt");
        ConnectedC connectedC = new ConnectedC(g);
        System.out.println(connectedC.getCcCount());
    }
}
