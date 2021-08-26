package davidul.problems.leetcode.solved.medium;

import java.util.HashSet;
import java.util.Set;

public class ConnectedGraph323 {

    public static void main(String[] args) {
        final ConnectedGraph323 connectedGraph323 = new ConnectedGraph323();
        System.out.println(connectedGraph323.countComponents(5, new int[][]{
                {0,1},
                {1,2},
                {3,4}}));
        System.out.println(connectedGraph323.countComponents(5, new int[][]{
                {0,1},
                {1,2},
                {2,3},
                {3,4}}));
    }



    public int countComponents(int n, int[][] edges) {
        final int[] nodes = make_set(n);
        for(int i = 0; i < edges.length; i++){
            union(edges[i][0], edges[i][1], nodes);
        }

        Set<Integer> count = new HashSet<>();
        for(int i = 0; i < nodes.length; i++){
            count.add(find_set(nodes[i], nodes));
        }

        return count.size();
    }

    private void union(int a, int b, int [] parent){
        a = find_set(a, parent);
        b = find_set(b, parent);
        if( a != b ){
            parent[b] = a;
        }
    }

    private int find_set(int v, int [] parent){
        if(parent[v] == v){
            return v;
        }
        return find_set(parent[v], parent);
    }

    private int[] make_set(int n){
        int [] parent = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
        return parent;
    }
}
