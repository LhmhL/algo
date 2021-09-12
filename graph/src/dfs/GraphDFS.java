package dfs;

import graph.AdjSet;
import graph.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 深度优先遍历 单点
public class GraphDFS {
    private Graph g;

    public GraphDFS(Graph g) {
        this.g = g;
    }

    public List<Integer> dfs(int v) {
        List<Integer> res = new ArrayList<>();
        if (g == null) return res;
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        // 用于防止一个节点被重复访问
        boolean[] visited = new boolean[g.getV()];
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
        return res;
    }

    public static void main(String[] args) {
        Graph g = new AdjSet("graph/graph-dfs.txt");
        GraphDFS graphDFS2 = new GraphDFS(g);
        System.out.println(graphDFS2.dfs(0));
    }
}
