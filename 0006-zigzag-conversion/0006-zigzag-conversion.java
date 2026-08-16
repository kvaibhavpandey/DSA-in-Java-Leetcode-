class Solution {
    public String convert(String s, int numRows) {
        // If only one row, there is no zigzag
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];

        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int row = 0;
        int direction = 1; // 1 = down, -1 = up

        for (char c : s.toCharArray()) {
            rows[row].append(c);

            // Change direction at top or bottom
            if (row == 0) {
                direction = 1;
            } else if (row == numRows - 1) {
                direction = -1;
            }

            row += direction;
        }

        // Combine all rows
        StringBuilder result = new StringBuilder();

        for (StringBuilder r : rows) {
            result.append(r);
        }

        return result.toString();
    }
}