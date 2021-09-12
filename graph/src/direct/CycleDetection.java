package direct;

import graph.Graph;

// 有向图环检测
public class CycleDetection {
    private Graph g;
    // 用于防止一个节点被重复访问
    private boolean[] visited;
    private boolean[] isOnPath;
    private boolean hasCycle = false;

    public CycleDetection(Graph g) {
        this.g = g;
        if (g == null) return;
        this.visited = new boolean[g.getV()];
        this.isOnPath = new boolean[g.getV()];
        // 遍历图中每个顶点
        for (int v = 0; v < g.getV(); v++) {
            // 先判断，没有遍历的顶点才能进行深度优先遍历
            if (!visited[v]) {
                if (dfs(v)) {
                    hasCycle = true;
                    break;
                }
            }
        }
    }

    private boolean dfs(int v) {
        visited[v] = true;
        isOnPath[v] = true;
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                if (dfs(w)) return true;
            } else { // 否则，w 顶点已经被访问
                if (isOnPath[w]) return true;
            }
        }
        isOnPath[v] = false;
        return false;
    }

    public boolean isHasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        Graph g = new GraphImpl("graph/graph-dfs.txt", true);
        CycleDetection cycleD = new CycleDetection(g);
        System.out.println(cycleD.isHasCycle());
    }
}
