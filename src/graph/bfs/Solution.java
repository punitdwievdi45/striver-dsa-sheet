package graph.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
       Queue<Integer> queue = new LinkedList<>();
       boolean visited[] = new boolean[V];
       ArrayList<Integer> result= new ArrayList<>();
       queue.add(0);
       visited[0] = true;
       while (!queue.isEmpty()){
           Integer node = queue.poll();
           result.add(node);
           for (Integer i : adj.get(node)){
               if (visited[i] == false){
                   visited[i] = true;
                   result.add(i);
               }
           }
       }
       return result;
    }
}
