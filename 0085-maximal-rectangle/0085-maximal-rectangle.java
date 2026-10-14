
import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }

            Stack<Integer> stack = new Stack<>();

            for (int j = 0; j <= cols; j++) {
                int currentHeight =
                    (j == cols) ? 0 : heights[j];

                while (!stack.isEmpty()
                        && heights[stack.peek()] > currentHeight) {

                    int height = heights[stack.pop()];

                    int width = stack.isEmpty()
                        ? j
                        : j - stack.peek() - 1;

                    maxArea = Math.max(maxArea, height * width);
                }

                stack.push(j);
            }
        }

        return maxArea;
    }
}
