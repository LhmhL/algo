package direct;

import graph.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 深度优先遍历
public class GraphDFS {
    private Graph g;
    private List<Integer> res;
    // 用于防止一个节点被重复访问
    private boolean[] visited;

    public GraphDFS(Graph g) {
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
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        visited[v] = true;
        while (!stack.isEmpty()) {
            int curr = stack.pop();
            res.add(curr);
            for (int w : g.adj(curr)) { // 升序排列
                // 如果已经访问过了，就不压入栈，就不会再次访问了
                if (!visited[w]) {
                    stack.push(w);
                    visited[w] = true;
                }
            }
        }
    }

    public List<Integer> getRes() {
        return res;
    }

    public static void main(String[] args) {
        Graph g1 = new GraphImpl("graph/graph-dfs.txt", false);
        GraphDFS graphDFSR1 = new GraphDFS(g1);
        System.out.println(graphDFSR1.getRes());
        Graph g2 = new GraphImpl("graph/graph-dfs.txt", true);
        GraphDFS graphDFSR2 = new GraphDFS(g2);
        System.out.println(graphDFSR2.getRes());
    }
}
