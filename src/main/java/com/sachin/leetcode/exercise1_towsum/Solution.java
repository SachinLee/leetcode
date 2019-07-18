package com.sachin.leetcode.exercise1_towsum;

import java.util.HashMap;
import java.util.Map;

/**
 * 计算两数之和
 *
 * @author sachin
 * @create 2019-07-17 22:34
 */
public class Solution {

    /**
     * Given an array of integers,
     * return indices of the two numbers such that they add up to a specific target.
     * 给定一个整数数组，返回两个数字的索引，使它们相加到特定目标。
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] rwoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) {
            return result;
        }
        Map<Integer, Integer> tmp = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (tmp.containsKey(num)) {
                result[0] = tmp.get(num);
                result[1] = i;
            }
            tmp.put(nums[i], i);
        }
        return result;
    }

}
