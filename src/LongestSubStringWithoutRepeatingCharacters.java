/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Example 1:
 * <p>
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 * <p>
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 * <p>
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 * <p>
 * 思路：需要一个指向子串头和一个指向子串尾的指针，初始状态都指向0，然后逐个遍历字符串的其他字符。对于遍历到某个位置i对应的字符c，
 * 如果c没有在字串中出现，那么移动尾指针到i，同时更新字串最大长度；如果c在子串中出现了，那么移动头指针到c在子串中出现的位置的后一位，
 * 然后移动尾指针到i，同时更新字串的最大长度
 * <p>
 * 这样做的时间复杂度是O(n*n)；通过分析，遍历一遍字串是必须的，在判断维护的字串中是否存在某个位置i对应的字符c时，普通方法需要遍历整个子串，
 * 导致时间复杂度上升。根据空间换时间的思路，可以用张哈希表来记录已经遍历过的子串中每一个字符最后出现的位置，这样时间复杂度就降低到了O(n)
 *
 * @author mabenteng
 * @since 2019/2/26
 * Created by Intellij IDEA
 */
public class LongestSubStringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = " ";
        String s5 = "abba";
        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));
        System.out.println(lengthOfLongestSubstring(s4));
        System.out.println(lengthOfLongestSubstring(s5));
    }

    private static int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        if (s.isEmpty()) {
            return 0;
        }
        int p1 = 0;
        int p2 = 0;
        int maxLength = 1;
        int[] location = new int[256];
        for (int i = 0; i < 255; i++) {
            location[i] = -1;
        }
        int stringLength = s.length();
        for (int i = 0; i < stringLength; i++) {
            char c = s.charAt(i);
            if (location[c] != -1) {
                if (location[c] >= p1) {
                    p1 = location[c] + 1;
                }
            }
            location[c] = i;
            p2 = i;
            maxLength = Math.max(maxLength, p2 - p1 + 1);
        }
        return maxLength;
    }
}
