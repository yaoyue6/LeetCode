package com.yaoyue.leetcode.string;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 字符串中的第一个唯一字符
 * @author: WangDongXu (15224931482)
 * @date: 2020/12/23 14:05
 **/
public class LeetCode387 {

    @Test
    public void test() {
        String s = "loveleetcode";

        System.out.println(firstUniqChar(s));
    }

    /**
     * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }

        }

        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    /**
     *
     * @param s
     * @return
     */
    public int firstUniqChar1(String s) {
        // 模拟字典数组
        int[] dictionary = new int[26];

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            dictionary[c - 'a']++;
        }

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(dictionary[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
