package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        ArrayList<Integer> bfs = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        boolean visited[] = new boolean[V];
        visited[0] = true;
        q.add(0);
        while (!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);

            for(Integer it : adj.get(node)){
                if(visited[it] ==false){
                    visited[it] = true;
                    bfs.add(it);
                }
            }
        }
        return bfs;
    }
}
