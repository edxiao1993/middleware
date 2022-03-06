### start at March 5, 2022

no matter what happens, it starts anyway.   
BTW, just write, and code.


84. 柱状图中最大的矩形 Largest Rectangle in Histogram
n = [6,7,5,2,4,5,9,3]
    

solution 1: violence.
最大的矩形面积，可以从某一个矩形的高度开始，向左向右扩展，所能取得的最大值。
从头到尾遍历一遍之后，就可以求处最大的值。  
因此，先从暴力的解法开始。  
tips：没什么思路时，暴力的解法是最好的开始。观察特点，再把这些特点与大脑中的各种数据结构和算法相联系。
    能找到当然很好，找不到就先把基础的解决了再说。

第二个解法：paragon(), 是先遍历出每个矩形的左右边界，最后再用一个for循环把每个高度的矩形所能达到的最大的面积计算出来。

第三个解法：anotherSolution(), 则必须要用到一个辅助的元素 -1，充当矩形最左边界。
  因为当数组是递减的时候，比如 5，4，1。
  遇到 4 时，5 会被弹出来，此时面积是 5。
  遇到 1 时，4 会被弹出来，如果栈内没有元素，便无法确定它是不是一直都是递减的。比如：5，4，3，5，4，1。
  第一个 4 的左边界应该是数组的起始位置，就是 0。而第二个元素的起始位置应该是 3，即第三个元素，下标是
  所以必须先存储一个 -1 充当元素的左边界，并且是无论如何也不会被栈弹出来的。计算长度时，用到的是 peek 弹出栈内的下一个元素。
done

第四个解法：advanceSolution()，有了上面两个算法，这个算是一个改进。
  哨兵：即增加元素，以确定不会越界，或者确定不会被计算，充当边界。
  前后多加两个 0，即以为着以出栈计算面积的算法，可以确保所有的高度大于 0 的矩形都会被计算。
  而且，因为第一个元素是 0，也可以确保每次弹出元素，计算以它为高度的最大面积的时候，都可以从栈内取出一个元素，充当它的左边界。

```java
import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    /**
     * 暴力解法的解析：
     * 1. 每个矩形所能形成的最大的面积，就是看以这个矩形为高度的矩形，
     * 向左向右所能到达的最远的边界。
     *   以 6，7，5 为例。
     *   6 为高度时，左边没有矩形，因此往左所能到达的最远的距离就是它自己。
     *     因此这里用的循环是 for，因此跳出这个循环的条件是下标 -1。
     *   往右，7 比 6 大，5 比它小。因此，下标即为 2。
     *   所以它为高度的矩形的面积就是 6 * (2 - （-1） - 1)
     *   减 1 是为什么，好好想想
     */
    private int violence(int[] heights) {
        int area = -1; // the largest area.
        for (int i = 0; i < heights.length; i++) {
            // starts from current position.
            // if find any heights is low than the current height. stop.
            int left = i;
            for (int j = i; j >= 0; j--) {
                if (heights[j] < heights[i]) {
                    left = j;
                    break;
                }
            }

            // starts from current position.
            // if find any heights is low than the current height, stop
            int right = i;
            for (int j = i; j < heights.length; j++) {
                if (heights[j] < heights[i]) {
                    right = j;
                    break;
                }
            }

            area = Math.max(area, heights[i] * (right - left));
        }

        return area;
    }

    /**
     * 在上面的基础上，观察到一个特点：就是遇到一个比它小的矩形，就跳出循环：
     *   栈的特点是后进先出，加上满足一个特性：单调性。
     */
    private int paragon(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] left = new int[heights.length];
        Arrays.fill(left, -1); // 设想超出数组最左边的，即是它的边界。所以是 -1；
        // 从数组最后一个开始，往前判断
        for (int i = hegihts.length; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int top = stack.pop();
                left[top] = i;
            }
            stack.push(i);
        }
        
        stack.clear();
        int[] right = new int[heights.length]; 
        Arrays.fill(right, heights.length); // 数组的右边界，即数组的长度
        for (int i = 0; i < heights.length; i++) {
            // 栈内的元素要满足单调性，因此用 while 循环。
            // 从左向右遍历，遇到比它小的即出栈，记录下使它出栈的下标：这个下标就是它往右所能扩展的边界。
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int top = stack.pop();
                right[top] = i;
            }
            stack.push(i);
        }

        int area = -1;
        // 最后用一个 for 循环，遍历出所有矩形的最大矩形面积。
        for (int i = 0; i < heights.length; i++) {
            int width = right[i] - left[i] - 1;
            area = Math.max(area, heights[i] * width);
        }
        
        return area;
    }
    
    /**
     * 想法同上，每次出栈都记录下以它为高度的矩形所能形成的最大矩形面积。
     * 最后再用一个 while 循环，弹出站内剩余元素，计算面积同上，因此所有的矩形的面积就都计算过了。
     */
    private int anotherSolution(int[] heights) {
        int area = -1;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); // 辅助元素。如果没有这个元素充当左边界，遇到递减的矩形就会失败。
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[i] < heights[stakck.peek()]) {
                int top = stack.pop();
                // 这里要详细说明一下，否则会看不懂，明天的我再回顾的话。
                // 还是以 6，7，5 为例子。
                // 到 i = 2 时，栈内有两个元素：0，1——分别代表 6，7
                // 到第三个元素的时候，不满足单调性，因此需要出栈。
                // 这时，下面的 top = 1，stack.peek() = 0;
                // 于是， width = 2 - 0 - 1. 以 7 为高度的矩形的面积就是 7 * 1。
                // 接着，top=0，stack.peek()=-1; 于是以 6 为高度的面积就是 6 * (2 - -1 -1)
                // 栈内只剩一个元素 -1，因此不再循环。
                int width = i - stack.peek() - 1;
                area = Math.max(area, heights[top] * width);
            }
            stack.push(i);
        }
        
        while (stack.peek() != -1) {
            int top = stack.pop();
            int width = top - stack.peek() - 1;
            area = Math.max(area, heights[top] * width);
        }
    }

    /**
     * 再高级一点的解决：哨兵。
     * 如果在数组的前后个给一个哨兵，就省去了前面再用一个 while 循环去解决剩余元素的代码。
     * 因为要满足单调性，而算法是遇到递减的元素时就出栈，并计算面积。
     * 于是乎，前后各自给一个高度为 0 的矩形，便解决了可能遗漏的计算
     * @param heights
     * @return
     */
    private int advanceSolution(int[] heights) {
        int area = -1;
        Deque<Integer> stack = new ArrayDeque<>();
        // 局部变量的数组，默认是 0；因为第一个和最后一个也可以不用去管它。
        int[] newHeights = new int[heights.length + 2];
        System.arraycopy(heights, 0, newHeights, 1, heights.length);

        for (int i = 1; i < newHeights.length; i++) {
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {
                int top = stack.pop();
                int width = i - stack.peek() - 1;
                area = Math.max(area, heights[top] * width);
            }
            stack.push(i);
        }
        
        return area;
    }
}
```