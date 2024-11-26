package leetcode.top75;

/*
* You are given an integer array height of length n.
* There are n vertical lines drawn such that the two
* endpoints of the ith line are (i, 0) and (i, height[i]).

Find two lines that together with the x-axis form a container,
*such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.
* */

public class ContainerWithMaxArea {

    static int maxArea(int[] array) {

        int maxArea = 0;

        for (int left = 0; left < array.length; left++) {
            for (int right = left + 1; right < array.length; right++) {
                int width = right - left;

                maxArea = Math.max(
                        maxArea,
                        Math.max(array[left], array[right]) * width
                );
            }
        }

        return maxArea;
    }

    static int maxAreaSecond(int array[]) {
        int maxArea = 0;
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int width = right - left;

            if (array[left] < array[right]) {
                maxArea = Math.max(maxArea, array[left] * width);
                left += 1;
            } else {
                maxArea = Math.max(maxArea, array[right] * width);
                right -= 1;
            }
        }

        return maxArea;
    }

}

