package com.yaoyue.recruit.wy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @description: 网易：下厨房
 * @author: WangDongXu (15224931482)
 * @date: 2021/1/27 17:32
 **/
public class WY8 {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            set.add(sc.next());
        }

        System.out.println(set.size());
    }
}
