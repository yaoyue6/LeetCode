package com.yaoyue.leetcode.primary.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 有效的字母异位词
 * @author: WangDongXu (15224931482)
 * @date: 2020/11/26 20:27
 **/
public class String04Test {

    /**
     * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map1 = new HashMap<>();

        for(Character c : map1.keySet()) {
            if(map1.get(c)!= 1){

            }
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map1.containsKey(c)) {
                map1.put(c, map1.get(c) + 1);
            } else {
                map1.put(c, 1);
            }
        }

        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if(map1.containsKey(ch)) {
                map1.put(ch, map1.get(ch) - 1);

                if(map1.get(ch) < 0) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * 解题思路：构建哈希表，先存储一个字符串中出现的字符及出现次数，之后遍历第二个字符串，如果存在该字符，则将哈希表中此字符数-1，
     * 如果减到0以下，则不是，如果不存在该字符，则不是，如果两字符串长度不一致，则不是
     */

    /**
     * 解题思路：维护字典数组，如果某个字典数组的元素 < 0，则不是，否则是
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram1(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] dictionary = new int[26];
        for(int i = 0; i < s.length(); i++) {
            dictionary[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < t.length(); i++) {
            dictionary[t.charAt(i) - 'a']--;
            if(dictionary[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
