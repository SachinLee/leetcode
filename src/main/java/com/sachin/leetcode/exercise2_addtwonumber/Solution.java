package com.sachin.leetcode.exercise2_addtwonumber;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 *
 * 您将获得两个非空链表，表示两个非负整数。
 * 数字以相反的顺序存储，每个节点包含一个数字。添加两个数字并将其作为链接列表返回。
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author sachin
 * @create 2019-07-18 21:35
 */
public class Solution {

    /**
     * 这么写总是会有问题，开始想的是先处理两个链表相同的位，最后如果有一个链表再单独处理
     * 问题1： 两个链表各个位处理完了，但是最后一位相加 还是 > 10 需要多一位 (√ 已解决)
     * 问题2： 最后剩余的链表，和剩余的进位，可能相加之后还是 > 10；
     *         进位后边可能还 > 10；还是需要循环，（未解决）
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = 0;
        ListNode result = new ListNode(0);
        ListNode node = result;
        while (l1 != null && l2 != null) {
            int val1 = l1.val;
            int val2 = l2.val;
            int val = (val1 + val2) % 10 + tmp;
            tmp = (val1 + val2) / 10;

            result.next = new ListNode(val);
            result = result.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        if (tmp > 0) {
            result.next = new ListNode(tmp);
        }

        if (l1 != null) {
            if (result.next == null) {
                result.next = l1;
            } else {
                result.next.val += l1.val;
                result.next.next = l1.next;
            }
        }
        if (l2 != null) {
            if (result.next == null) {
                result.next = l2;
            } else {
                result.next.val += l2.val;
                result.next.next = l2.next;
            }
        }

        return node.next;
    }


    /**
     * 既然，最后还是需要循环每个元素，直接写一个 while 循环就好了
     * @param l1
     * @param l2
     * @return
     */
    public ListNode beeterSolution(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode node = result;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            int sum = val1 + val2 + carry;
            node.next = new ListNode(sum % 10);
            // 加法进位
            carry = sum / 10;

            node = node.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            node.next = new ListNode(carry);
        }
        return result.next;
    }

}
