package com.yaoyue.leetcode.primary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QueueTest {

    public static void main(String[] args) throws Exception {
        System.out.println("请输入舞曲的数量：");
        Scanner sc = new Scanner(System.in);

        // 接收舞曲数量
        int num = sc.nextInt();

        if(num <= 0) {
            throw new Exception("输入舞曲数量小于或等于0！");
        }

        // 设置男生的数量
        int boy = 8;
        int girl = 5;

        // 快慢指针
        int fast = 1;
        int slow = 1;

        // 存放男女中较少的数目
        int less = boy > girl ? girl : boy;

        // 存放总结果
        List<List<Dance>> result = new ArrayList<>();
        while(num-- > 0) {
            List<Dance> list = new ArrayList<>();
            for(int i = 0; i < less; i++) {
                // 此时已经到队列结尾，进行归零操作
                if(slow == boy + 1) {
                    slow = 1;
                }

                // 此时已经到队列结尾，进行归零操作
                if(fast == girl + 1) {
                    fast = 1;
                }

                Dance dance = new Dance();
                dance.boyNo = slow++;
                dance.girlNo = fast++;
                list.add(dance);
            }
            result.add(list);
        }

        System.out.println("男生编号：\t女生编号：");

        for (List<Dance> list : result) {
            System.out.println("第" + (++num) + "支舞曲的配对情况:");
            for(Dance dance : list) {
                System.out.println(dance.boyNo + "\t\t\t\t" + dance.girlNo);
            }
        }
    }

}

class Dance{
    int girlNo;
    int boyNo;
}
