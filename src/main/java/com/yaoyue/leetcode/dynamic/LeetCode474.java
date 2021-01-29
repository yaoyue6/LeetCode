package com.yaoyue.leetcode.dynamic;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 一和零
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/25 14:46
 **/
public class LeetCode474 {

    List<List<String>> list = new ArrayList<>();

    /**
     * 穷举法
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm1(String[] strs, int m, int n) {
        if(strs == null || strs.length == 0) {
            return 0;
        }

        List<String> path = new ArrayList<>();
        process(strs, 0, m, n, path);

        int max = 0;
        for(List<String> p : list) {
            max = Math.max(max, p.size());
        }

        return max;
    }

    public void process(String[] strs, int index, int m, int n, List<String> path) {
        if(strs.length == index) {
            if(m >= 0 && n >= 0) {
                list.add(new ArrayList<>(path));
            }
            return;
        }
        // 不添加当前元素
        process(strs, index + 1, m, n, path);

        // 添加当前元素
        for(char ch : strs[index].toCharArray()) {
            if(ch - '0' == 0) {
                m--;
            } else {
                n--;
            }
        }
        if(m >= 0 && n >= 0) {
            path.add(strs[index]);
            process(strs, index + 1, m, n, path);
            path.remove(path.size() - 1);
        }
    }

    /**
     * dp解法
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        for(int i = 0; i < strs.length; i++) {
            int[] count = cal(strs[i]);
            // 如果j < count[0]或者k < count[1]，则无法继续遍历，因此直接默认即可
            for(int j = m; j >= count[0]; j--) {
                for(int k = n; k >= count[1]; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - count[0]][k - count[1]] + 1);
                }
            }
        }

        return dp[m][n];
    }

    public int[] cal(String str) {
        // 计算字符串中0和1的个数
        int[] count = new int[2];
        for(char ch : str.toCharArray()) {
            count[ch - '0']++;
        }
        return count;
    }
}
