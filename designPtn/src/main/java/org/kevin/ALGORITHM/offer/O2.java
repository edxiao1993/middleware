package org.kevin.ALGORITHM.offer;

import java.util.Objects;

/**
 * @author Kevin.Zng
 * @date 2022/6/11 01:51
 */
public class O2 {

    public static void main(String[] args) {
        ListNode l11 = new ListNode(9);
        ListNode l12 = new ListNode(9);
        ListNode l13 = new ListNode(9);
        ListNode l14 = new ListNode(9);
        ListNode l15 = new ListNode(9);
        ListNode l16 = new ListNode(9);
        ListNode l17 = new ListNode(9);
        l11.next = l12; l12.next = l13;
        l13.next = l14; l14.next = l15;
        l15.next = l16; l16.next = l17;

        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);
        ListNode l23 = new ListNode(9);
        ListNode l24 = new ListNode(9);
        l21.next = l22; l22.next = l23;
        l23.next = l24;

        ListNode node = addTwoNumbers(l11, l21);
        System.out.println();
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        int sum = l1.val + l2.val;
        int carry = sum > 9 ? 1 : 0;
        sum = sum > 9 ? sum - 10 : sum;
        head.val = sum;

        ListNode tail = head;
        int l1Value = 0;
        int l2Value = 0;
        while (l1.next != null || l2.next != null) {
            if (l1.next == null) {
                l1Value = 0;
            } else {
                l1 = l1.next;
                l1Value = l1.val;
            }

            if (l2.next == null) {
                l2Value = 0;
            } else {
                l2 = l2.next;
                l2Value = l2.val;
            }

            sum = l1Value + l2Value + carry;
            carry = sum > 9 ? 1 : 0;
            sum = sum > 9 ? sum - 10 : sum;

            tail.next = new ListNode(sum);
            tail = tail.next;
        }

        if (carry == 1) {
            tail.next = new ListNode(1);
        }

        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
