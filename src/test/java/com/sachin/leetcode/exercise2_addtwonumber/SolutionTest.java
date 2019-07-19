package com.sachin.leetcode.exercise2_addtwonumber;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void addTwoNumbers() {

        Solution solution = new Solution();
        ListNode l1 = arrayToNode(new int[]{5});
        ListNode l2 = arrayToNode(new int[]{5,9});

        ListNode node = solution.addTwoNumbers(l1, l2);
        while (node != null) {
            System.out.print(node.val);
            System.out.print(',');
            node = node.next;
        }
    }

    private ListNode arrayToNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        ListNode node = new ListNode(0);
        ListNode curr = node;
        for (int item : arr) {
            curr.next = new ListNode(item);
            curr = curr.next;
        }
        return node.next;
    }
}