package com.yaoyue.practice.dac;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 打印字符串的全部子序列
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/21 17:30
 **/
public class DacTest03 {

    List<String> list = new ArrayList<>();
    public void buildStringList(char[] chars, String path, int index) {
        if(index == chars.length) {
            // 添加沿途路径
            list.add(path);
            return;
        }
        // 不选择当前节点
        buildStringList(chars, path, index + 1);
        // 选择当前节点
        buildStringList(chars, path + chars[index], index + 1);
    }
}
