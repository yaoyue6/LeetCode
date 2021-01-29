package com.yaoyue.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 杨辉三角
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/25 17:50
 **/
public class LeetCode118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows <= 0) {
            return result;
        }

        int first = 1, second = 1;
        for(int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    list.add(1);
                } else {
                    list.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(list);
        }
        return result;
    }
}
