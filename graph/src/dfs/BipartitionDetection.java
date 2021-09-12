package dfs;

import graph.AdjSet;
import graph.Graph;

import java.util.Arrays;

// 二分图检测
public class BipartitionDetection {
    private Graph g;
    // 用于防止一个节点被重复访问
    private boolean[] visited;
    // -1 表示没有染颜色
    // 0 红色 1 蓝色
    private int[] colors;
    private boolean isBipartition = true;

    public BipartitionDetection(Graph g) {
        this.g = g;
        this.visited = new boolean[g.getV()];
        this.colors = new int[g.getV()];
        Arrays.fill(colors, -1);
        // 遍历图中每个顶点
        for (int v = 0; v < g.getV(); v++) {
            // 先判断，没有遍历的顶点才能进行深度优先遍历
            if (!visited[v]) {
                if (!dfs(v, 0)) {
                    isBipartition = false;
                    break;
                }
            }
//            if (!visited[v]) {
//                dfs1(v, 0);
//            }
        }
    }

    private boolean dfs(int v, int color) {
        visited[v] = true;
        colors[v] = color;
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                // 如果 v 的颜色是 1，那么 w 的颜色就是 0
                // 如果 v 的颜色是 0，那么 w 的颜色就是 1
                if (!dfs(w, 1 - color)) return false;
            } else if (colors[w] == colors[v]) {
                // 如果相邻顶点的颜色一样的话，则不是二分图
                return false;
            }
        }
        return true;
    }

    private void dfs1(int v, int color) {
        visited[v] = true;
        colors[v] = color;
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                // 如果 v 的颜色是 1，那么 w 的颜色就是 0
                // 如果 v 的颜色是 0，那么 w 的颜色就是 1
                dfs1(w, 1 - color);
            } else if (colors[w] == colors[v]) {
                // 如果相邻顶点的颜色一样的话，则不是二分图
                isBipartition = false;
            }
        }
    }

    public boolean isBipartition() {
        return isBipartition;
    }

    public static void main(String[] args) {
        Graph g = new AdjSet("graph/graph-dfs.txt");
        BipartitionDetection bipartitionD = new BipartitionDetection(g);
        System.out.println(bipartitionD.isBipartition());
    }
}
