/**
 * https://leetcode.com/problems/add-two-numbers/
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * <p>
 * 解法：current表示当前进行"+"运算的位所在的节点，遍历完两个链表。
 * 难点在于不能在一次"+"运算完成后，提前把current移到下一位，因为最后次"+"运算完成后，不一定需要进位。
 *
 * @author mabenteng
 * @since 2019/2/25
 * Created by Intellij IDEA
 */
public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        addTwoNumbers(l1, l2);
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        result.next = new ListNode(0);
        ListNode current = result;
        int sum;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int i = l1 == null ? 0 : l1.val;
            int j = l2 == null ? 0 : l2.val;
            sum = (i + j + carry) % 10;
            carry = (i + j + carry) / 10;
            current = current.next;
            current.val = sum;
            current.next = new ListNode(0);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(carry > 0) {
            current = current.next;
            current.val = carry;
        } else {
            current.next = null;
        }
        return result.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
