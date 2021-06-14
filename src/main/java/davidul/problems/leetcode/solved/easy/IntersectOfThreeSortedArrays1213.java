package davidul.problems.leetcode.solved.easy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order,
 * return a sorted array of only the integers that appeared in all three arrays.
 *
 *
 *
 * Example 1:
 *
 * Input: arr1 = [1,2,3,4,5], arr2 = [1,2,5,7,9], arr3 = [1,3,4,5,8]
 * Output: [1,5]
 * Explanation: Only 1 and 5 appeared in the three arrays.
 * Example 2:
 *
 * Input: arr1 = [197,418,523,876,1356], arr2 = [501,880,1593,1710,1870], arr3 = [521,682,1337,1395,1764]
 * Output: []
 */
public class IntersectOfThreeSortedArrays1213 {
    public static void main(String[] args) {
        final IntersectOfThreeSortedArrays1213 intersectOfThreeSortedArrays1213 = new IntersectOfThreeSortedArrays1213();
        final List<Integer> integers = intersectOfThreeSortedArrays1213.arraysIntersection(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 5, 7, 9}, new int[]{1, 3, 4, 5, 8});
        System.out.println("");
    }

    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr1.length; i++){
            countFrequency(arr1, map, i);
            countFrequency(arr2, map, i);
            countFrequency(arr3, map, i);
        }

        final Set<Integer> integers = map.keySet();
        return integers.stream().filter(key -> map.get(key) == 3).collect(Collectors.toList());
    }

    private void countFrequency(int[] arr, Map<Integer, Integer> map, int i) {
        if(map.containsKey(arr[i])){
            Integer integer = map.get(arr[i]);
            integer++;
            map.put(arr[i], integer);
        }else {
            map.put(arr[i],1);
        }
    }
}
