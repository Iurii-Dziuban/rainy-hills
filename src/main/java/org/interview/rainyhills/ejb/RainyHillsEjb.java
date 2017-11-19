package org.interview.rainyhills.ejb;

import org.interview.rainyhills.contract.RainyHillsContract;

import javax.ejb.Stateless;

/**
 * CRX Markets logic ejb 3.2 bean
 *
 * There is an array of integers that represents hills.
 * If there was a rain on these hills, calculate how much water will remain inside
 *
 * Example [2, 0, 0, 3] - 4 is the answer because wall on the left = 2, right = 3.
 * 2 units of water will remain on 1 position as well as on the second position. Sum up = 4.
 *
 * An element of array can store water if there are higher bars on left and right.
 * We can find amount of water to be stored in every element by finding the heights of bars on left and right sides.
 * The idea is to compute amount of water that can be stored in every element of array.
 * For example, consider the array {2, 0, 0, 3}, we can store two units of water at indexes 1 and 2.
 *
 * A brute force solution is to traverse every hills array element and find the highest bars on left and right sides of it.
 * Take the smaller of two heights.
 * Take the difference between taken smaller height and height of current element.
 * Time complexity of this solution is O(n2) because for each of n elements find highest left and right element in linear search n.
 *
 * The better solution is to precompute highest bar on left and right of every bar in O(n) time and have auxiliary O(n) space complexity
 * Then use these precomputed values to find the amount of water in every hills array element in O(n) time
 *
 * Even better solution to save space and instead of two arrays of size n for storing left and right max of each element,
 * we will just maintain two variables to store the maximum till current point.
 * Since water trapped at any element = min( max_left, max_right) – arr[i]
 * we will calculate water trapped on smaller element out of A[lo] and A[hi] first and move the pointers till lo doesn’t cross hi.
 *
 * So in the end the complexity is the following
 * Time Complexity: O(n)
 * Auxiliary Space: O(1)
 *
 * Created by iurii.dziuban on 06/11/2017.
 */
@Stateless
public class RainyHillsEjb implements RainyHillsContract {

    /**
     *
     * @param hills input array representing hills (any int values are possible = negatives, zero, positives)
     * @return volume = number of water units inside the hills (long type is chosen because result can easily exceed int)
     */
    @Override
    public long findWaterVolume(int[] hills) {
        // check null
        if (hills == null) {
            return 0;
        }
        // initialize output
        long volume = 0;

        // maximum hills element on left and right
        // (long is chosen so that overflow will not happen on arithmetic operations further)
        long leftMax = Integer.MIN_VALUE;
        long rightMax = Integer.MIN_VALUE;

        // indices to traverse the hills
        int lowerIndex = 0;
        int higherIndex = hills.length - 1;

        while (lowerIndex <= higherIndex) {
            if (hills[lowerIndex] < hills[higherIndex]) {
                // lower bar on the left
                if (hills[lowerIndex] > leftMax) {
                    // update left maximum
                    leftMax = hills[lowerIndex];
                } else {
                    // water on current element = smaller max (left) - current
                    volume += leftMax - hills[lowerIndex];
                }
                lowerIndex++;
            } else {
                // lower bar on the right
                if (hills[higherIndex] > rightMax) {
                    // update right maximum
                    rightMax = hills[higherIndex];
                } else {
                    // water on current element = smaller max (right) - current
                    volume += rightMax - hills[higherIndex];
                }
                higherIndex--;
            }
        }
        return volume;
    }
}
