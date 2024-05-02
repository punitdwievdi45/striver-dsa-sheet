package graph.dfs;

import java.util.ArrayList;

public class GraphMain {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(0);
        adj.get(2).add(0);

        adj.get(4).add(3);
        adj.get(3).add(4);
       // System.out.println(adj);
        ArrayList<Integer> result = new ArrayList<>();
        boolean vis[] = new boolean[5];
        dfsGraph(6, adj);

    }

    private static void dfsGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean vis[] = new boolean[5];
        vis[0] = true;
        // result.add(node);
        dfs(0, adj, vis, result);
        System.out.println(result);
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis, ArrayList<Integer> result) {


        vis[node] = true;
        result.add(node);
        for (Integer i : adj.get(node)) {
            if (vis[i] == false) {
                dfs(i, adj, vis, result);
            }
        }

    }


}
