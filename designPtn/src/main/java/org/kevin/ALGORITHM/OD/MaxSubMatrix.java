package org.kevin.ALGORITHM.OD;

/**
 * @author Kevin.Zng
 * @date 2022/4/16 00:11
 */
public class MaxSubMatrix {
    public static void main(String[] args) {
        int[][] n = new int[][]{
                {-1, -1, -1, -1},
                {-1, 4, 4, -1},
                {-1, 4, 4, -1},
                {-1, -1, -1, -1},
        };

//        n = new int[][]{
//                {0, -2, -7, 0},
//                {9, 2, -6, 2},
//                {-4, 1, -4, 1},
//                {-1, 8, 0, -2}
//        };

        System.out.println("maxSubMatrix(n) = " + maxSubMatrix(n));
    }

    private static int maxSubMatrix(int[][] nums) {
        int r = nums.length;
        int c = nums[0].length;
        int[][] preSum = new int[r + 1][c + 1];
        for (int i = 1; i < r + 1; i++) {
            for (int j = 1; j < c + 1; j++) {
                preSum[i][j] = preSum[i][j - 1] + preSum[i - 1][j] - preSum[i - 1][j - 1] + nums[i - 1][j - 1];
            }
        }

        int max = firstTry(preSum);
        return max;
    }

    // 下面这种方式行不通哟！
    // 以 preSum[3][3] 为例。前三列前三行的和，
    //  1. 先减去前一行前三列：preSum[1][3]，
    //      结果为 cur， 即 preSum[3][3] - preSum[1][3] => 后两行前三列的和
    //  2. 再减去前三行前一列的和：cur - preSum[3][1] =>
    //      本意是想减去前一列与前一行后，得出的矩阵的和，但这里多减了一个数字：preSum[1][1], 即左上角。
    //  3. 结论就是，这种算法每次都会多减一个数，failed~
    // 要用前缀和的话，目前来看只能是：前缀和 + 动态规划。不然复杂度太高，大脑运转不过来。。。。。。
    // DAMN IT! - April 15, 2022
    private static int firstTry(int[][] preSum) {
        // 原数组的大小
        int r = preSum.length - 1;
        int c = preSum[0].length - 1;

        int max = preSum[1][1];
        int cur;
        int temp;
        for (int i = 1; i < r + 1; i++) {
            for (int j = 1; j < c + 1; j++) {

                cur = preSum[i][j];
                int row = 1;
                int column = 1;
                while (row < i) {
                    temp = preSum[row++][j];
                    max = Math.max(max, cur - temp);

                    column = 1;
                    cur -= temp;
                    while (column < j) {
                        temp = preSum[row][column] + preSum[row - 1][column];
                        max = Math.max(max, cur - temp);
                        column++;
                    }
                }

                column = 1;
                while (column < j) {
                    temp = preSum[i][column++];
                    max = Math.max(max, cur - temp);

                    cur -= temp;
                    row = 1;
                    while (row < i) {
                        temp = preSum[row][column] + preSum[row][column - 1];
                        max = Math.max(max, cur - temp);
                        row++;
                    }
                }

            }
        }

        return max;
    }
}
