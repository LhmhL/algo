package dfs;

import graph.AdjSet;
import graph.Graph;

// 环检测
public class CycleDetection {
    private Graph g;
    // 用于防止一个节点被重复访问
    private boolean[] visited;
    private boolean hasCycle = false;

    public CycleDetection(Graph g) {
        this.g = g;
        this.visited = new boolean[g.getV()];
        // 遍历图中每个顶点
        for (int v = 0; v < g.getV(); v++) {
            // 先判断，没有遍历的顶点才能进行深度优先遍历
            if (!visited[v]) {
                if (dfs(v, v)) {
                    hasCycle = true;
                    break;
                }
            }
//            if (!visited[v]) {
//                dfs1(v, v);
//            }
        }
    }

    private boolean dfs(int v, int prev) {
        visited[v] = true;
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                // 后面的循环就可以不执行了
                if (dfs(w, v)) return true;
            } else {  // 否则，w 顶点已经被访问
                // 如果 w 不是 v 的前一个节点的话，那么就存在环
                if (w != prev) {
                    return true;
                }
            }
        }
        return false;
    }

    private void dfs1(int v, int prev) {
        visited[v] = true;
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                dfs1(w, v);
            } else {  // 否则，w 顶点已经被访问
                // 如果 w 不是 v 的前一个节点的话，那么就存在环
                if (w != prev) {
                    hasCycle = true;
                }
            }
        }
    }

    public boolean hasCycle() {
        return hasCycle;
    }

    public static void main(String[] args) {
        Graph g = new AdjSet("graph/graph-dfs.txt");
        CycleDetection cycleD = new CycleDetection(g);
        System.out.println(cycleD.hasCycle());
    }
}
