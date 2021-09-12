package floodfill;

import graph.AdjSet;
import graph.Graph;

// 最大连通分量的顶点数
public class ConnectedCVM {
    private Graph g;
    // 用于防止一个节点被重复访问
    private boolean[] visited;
    private int maxVertexNum = 0;

    public ConnectedCVM(Graph g) {
        this.g = g;
        if (g == null) return;
        this.visited = new boolean[g.getV()];
        // 遍历图中每个顶点
        for (int v = 0; v < g.getV(); v++) {
            // 先判断，没有遍历的顶点才能进行深度优先遍历
            if (!visited[v]) {
                maxVertexNum = Math.max(dfs(v), maxVertexNum);
            }
        }
    }

    private int dfs(int v) {
        visited[v] = true;
        int res = 1;
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                res += dfs(w);
            }
        }
        return res;
    }

    public int getMaxVertexNum() {
        return maxVertexNum;
    }

    public static void main(String[] args) {
        Graph g = new AdjSet("graph/graph-dfs.txt");
        ConnectedCVM connectedCVM = new ConnectedCVM(g);
        System.out.println(connectedCVM.getMaxVertexNum());
    }
}
