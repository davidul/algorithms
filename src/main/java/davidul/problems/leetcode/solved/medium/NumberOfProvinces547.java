package davidul.problems.leetcode.solved.medium;

import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces547 {

    public static void main(String[] args) {
        final NumberOfProvinces547 numberOfProvinces547 = new NumberOfProvinces547();
        System.out.println(numberOfProvinces547.findCircleNum(new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}}));
        System.out.println(numberOfProvinces547.findCircleNum(new int[][]{
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}}));

        //0 -> 3
        //1 -> 2
        //2 -> 3
        System.out.println(numberOfProvinces547.findCircleNum(new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}}));
    }

    public int findCircleNum(int[][] isConnected) {
        int[] nodes = new int[isConnected.length];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = i;
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int k = i; k < isConnected[0].length; k++) {
                final int i1 = isConnected[i][k];
                if(i1 == 1){
                    union_set(i, k, nodes);
                }
            }
        }

        final Set<Integer> integers = new HashSet<>();
        for(int i = 0; i < nodes.length; i++){
            integers.add(find_set(nodes[i], nodes));
        }

        return integers.size();
    }

    private int find_set(int v, int [] parent){
        if(v == parent[v]){
            return v;
        }
        return find_set(parent[v], parent);
    }

    private void union_set(int a, int b, int [] parent){
        a = find_set(a, parent);
        b = find_set(b, parent);
        if(a != b){
            parent[b] = a;
        }
    }

}
