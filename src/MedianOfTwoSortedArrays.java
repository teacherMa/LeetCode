/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * <p>
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * <p>
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * <p>
 * You may assume nums1 and nums2 cannot be both empty.
 * <p>
 * Example 1:
 * <p>
 * nums1 = [1, 3]
 * nums2 = [2]
 * <p>
 * The median is 2.0
 * Example 2:
 * <p>
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * <p>
 * The median is (2 + 3)/2 = 2.5
 *
 * @author mabenteng
 * @since 2019/2/26
 * Created by Intellij IDEA
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }


    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length < nums2.length) {
            int[] temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        if (nums2.length == 0) {
            nums2 = nums1;
        }
        int n1Size = nums1.length;
        int n2Size = nums2.length;

        int lowBound = 0;
        int heightBound = n1Size - 1;

        int n1Left = (lowBound + heightBound) / 2;
        int n1Right = n1Left + 1;
        int n2Left = (n1Size + n2Size - n1Left - 3) / 2;
        int n2Right = n2Left + 1;


        while (true) {
            n1Right = n1Left + 1 >= n1Size ? n1Size - 1 : n1Left + 1;
            n2Right = n2Left + 1 >= n2Size ? n2Size - 1 : n2Left + 1;
            if (nums1[n1Left] > nums2[n2Right]) {
                if (heightBound > lowBound) {
                    heightBound = n1Left;
                } else {
                    return (Math.max(nums1[n1Left], nums2[n2Left]) + Math.min(nums1[n1Right], nums2[n2Right])) / 2d;
                }
            } else if (nums2[n2Left] > nums1[n1Right]) {
                if (lowBound < heightBound) {
                    lowBound = n1Left + 1;
                } else {
                    return (Math.max(nums1[n1Left], nums2[n2Left]) + Math.min(nums1[n1Right], nums2[n2Right])) / 2d;
                }
            } else {
                return (Math.max(nums1[n1Left], nums2[n2Left]) + Math.min(nums1[n1Right], nums2[n2Right])) / 2d;
            }
            n1Left = (lowBound + heightBound) / 2;
        }
    }

}
