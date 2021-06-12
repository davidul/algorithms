package davidul.problems.leetcode.unsolved.medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Given an array arr.  You can choose a set of integers and remove all the occurrences of these integers in the array.
 *
 * Return the minimum size of the set so that at least half of the integers of the array are removed.
 *
 * Example 1:
 *
 * Input: arr = [3,3,3,3,5,5,5,2,2,7]
 * Output: 2
 * Explanation: Choosing {3,7} will make the new array [5,5,5,2,2] which has size 5 (i.e equal to half of the size of the old array).
 * Possible sets of size 2 are {3,5},{3,2},{5,2}.
 * Choosing set {2,7} is not possible as it will make the new array [3,3,3,3,5,5,5] which has size greater than half of the size of the old array.
 * Example 2:
 *
 * Input: arr = [7,7,7,7,7,7]
 * Output: 1
 * Explanation: The only possible set you can choose is {7}. This will make the new array empty.
 * Example 3:
 *
 * Input: arr = [1,9]
 * Output: 1
 * Example 4:
 *
 * Input: arr = [1000,1000,3,7]
 */
public class ReduceArraySizeToHalf1338 {
    public static void main(String[] args) {
        final ReduceArraySizeToHalf1338 reduceArraySizeToHalf1338 = new ReduceArraySizeToHalf1338();
        System.out.println(reduceArraySizeToHalf1338.minSetSize(new int[]{3,3,3,3,5,5,5,2,2,7}));
        System.out.println(reduceArraySizeToHalf1338.minSetSize(new int[]{7,7,7,7,7,7}));
        System.out.println(reduceArraySizeToHalf1338.minSetSize(new int[]{1,9}));
        System.out.println(reduceArraySizeToHalf1338.minSetSize(new int[]{1000,1000,3,7}));
        System.out.println(reduceArraySizeToHalf1338.minSetSize(new int[]{1,2,3,4,5,6,7,8,9,10}));
        System.out.println("");
    }

    public int minSetSize(int[] arr) {

        final int halfSize = arr.length / 2;

        final Map<Integer, Integer> frequency = countFrequency(arr);
        final List<Integer> collect = new ArrayList<>(frequency.values());
        collect.sort(Integer::compareTo);
        int counter = 0;
        int cumulativeSize = 0;
        for(int i = collect.size() - 1; i >= 0; i--) {
            //final Integer integer = collect.get(i);
            cumulativeSize = cumulativeSize + collect.get(i);
            if(cumulativeSize < halfSize){
                counter++;
            }else{
                return ++counter;
            }
        }
        return 1;
    }

    private Map<Integer, Integer> countFrequency(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                Integer integer = map.get(arr[i]);
                integer++;
                map.put(arr[i], integer);
            } else {
                map.put(arr[i], 1);
            }
        }

        return map;
    }
}
