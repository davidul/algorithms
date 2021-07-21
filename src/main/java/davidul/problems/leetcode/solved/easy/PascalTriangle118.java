package davidul.problems.leetcode.solved.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 *
 * Example 1:
 *
 * Input: numRows = 5
 * Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * Example 2:
 *
 * Input: numRows = 1
 * Output: [[1]]
 *
 *
 * Constraints:
 *
 * 1 <= numRows <= 30
 */
public class PascalTriangle118 {
    public static void main(String[] args) {
        final PascalTriangle118 pascalTriangle118 = new PascalTriangle118();
        pascalTriangle118.generate(5);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        if(numRows == 1){
            return triangle;
        }
        List<Integer> secondRow = new ArrayList<>();
        secondRow.add(1);
        secondRow.add(1);
        triangle.add(secondRow);

        if(numRows == 2){
            return triangle;
        }


        for(int i = 2; i < numRows; i++){
            final List<Integer> integers = triangle.get(i-1);
            List<Integer> newRow = new ArrayList<>();
            newRow.add(1);
            for(int k = 0; k < integers.size() - 1; k++){
                newRow.add(integers.get(k) + integers.get(k + 1));
            }
            newRow.add(1);
            triangle.add(newRow);
        }

        return triangle;
    }
}
