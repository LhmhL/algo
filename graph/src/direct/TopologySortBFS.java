package direct;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 有向图拓扑排序 不能有环
public class TopologySortBFS {
    private GraphImpl g;
    private int[] res;
    private boolean hasCycle = false;

    public TopologySortBFS(GraphImpl g) {
        if (!g.isDirected()) {
            throw new IllegalArgumentException("只能对有向图进行拓扑排序");
        }
        this.g = g;
        // 计算各顶点的入度
        int[] indegrees = new int[g.getV()];
        for (int v = 0; v < g.getV(); v++) {
            indegrees[v] = g.indegree(v);
        }
        // 将入度为 0 的入队
        Queue<Integer> queue = new LinkedList<>();
        for (int v = 0; v < g.getV(); v++) {
            if (indegrees[v] == 0) {
                queue.add(v);
            }
        }
        this.res = new int[g.getV()];
        int index = 0;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            // 将入度为 0 的输出
            res[index++] = v;
            for (int w : g.adj(v)) {
                // 修改顶点的入度
                indegrees[w]--;
                // 将入度为 0 的入队
                if (indegrees[w] == 0) {
                    queue.add(w);
                }
            }
        }
        if (index != g.getV()) {
            hasCycle = true;
        }
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
        GraphImpl g = new GraphImpl("graph/graph-bfs.txt", true);
        TopologySortBFS topologySortBFS = new TopologySortBFS(g);
        System.out.println(topologySortBFS.isHasCycle());
        System.out.println(Arrays.toString(topologySortBFS.getRes()));
    }
}
