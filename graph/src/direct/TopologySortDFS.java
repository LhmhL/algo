package direct;

import java.util.Arrays;

// 有向图环检测实现拓扑排序 不能有环
public class TopologySortDFS {
    private GraphImpl g;
    // 用于防止一个节点被重复访问
    private boolean[] visited;
    private boolean[] isOnPath;
    private int[] res;
    private int index;
    private boolean hasCycle = false;

    public TopologySortDFS(GraphImpl g) {
        if (!g.isDirected()) {
            throw new IllegalArgumentException("只能对有向图进行拓扑排序");
        }
        this.g = g;
        if (g == null) return;
        this.visited = new boolean[g.getV()];
        this.isOnPath = new boolean[g.getV()];
        this.res = new int[g.getV()];
        this.index = this.res.length - 1;
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
        res[index--] = v;
        return false;
    }

    public boolean isHasCycle() {
        return hasCycle;
    }

    public int[] getRes() {
        if (hasCycle) {
            return new int[res.length];
        }
        return res;
    }

    public static void main(String[] args) {
        GraphImpl g = new GraphImpl("graph/graph-dfs.txt", true);
        TopologySortDFS topologySortDFS = new TopologySortDFS(g);
        System.out.println(topologySortDFS.isHasCycle());
        System.out.println(Arrays.toString(topologySortDFS.getRes()));
    }
}
