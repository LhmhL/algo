package weighted;

import java.util.Arrays;

// 最短路径
// 时间复杂度：O(V * (V + E))
public class Dijkstra {
    private WeightedAdjMap g;
    private int source;
    private int[] distance;
    private boolean[] visited;

    public Dijkstra(WeightedAdjMap g, int source) {
        this.g = g;
        this.source = source;
        distance = new int[g.getV()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;
        visited = new boolean[g.getV()];
        while (true) { // O(V)
            // 1. 找到当前没有访问的最短路径节点
            int curDis = Integer.MAX_VALUE;
            int curr = -1;
            for (int v = 0; v < g.getV(); v++) { // O(V)
                if (!visited[v] && distance[v] < curDis) {
                    curDis = distance[v];
                    curr = v;
                }
            }
            if (curr == -1) break;
            // 2. 确认这个节点的最短路径就是当前大小
            visited[curr] = true;
            // 3. 根据这个节点的最短路径大小，更新其他节点的路径长度
            for (int w : g.adj(curr)) { // O(E)
                if (!visited[w]) {
                    if (distance[curr] + g.getWeight(curr, w) < distance[w]) {
                        distance[w] = distance[curr] + g.getWeight(curr, w);
                    }
                }
            }
        }
    }

    public int minDistanceTo(int v) {
        validateVertex(v);
        return distance[v];
    }

    public void validateVertex(int v) {
        if (v < 0 || v >= g.getV()) {
            throw new IllegalArgumentException(String.format("顶点 %d 不合格", v));
        }
    }

    public static void main(String[] args) {
        WeightedAdjMap g = new WeightedAdjMap("graph/dijkstra.txt");
        Dijkstra dijkstra = new Dijkstra(g, 0);
        System.out.println(dijkstra.minDistanceTo(3));
    }
}
