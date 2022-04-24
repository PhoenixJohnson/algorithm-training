package com.josh.algorithm.solutions;

public class GBSwitch {

    /**
     * 绳子覆盖最多的点数
     */

    public static void main(String[] args) {
        String a = "GBGBBGBBGBBBBBGBGBGGGGGBGGBGBGBG";
        System.out.println(minSteps(a));
    }

    public static int minSteps(String input) {

        if (input == null || input.equals("")) {
            return 0;
        }
        char[] str = input.toCharArray();
        int step1 = 0;
        int step2 = 0;
        int gi = 0;
        int bi = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == 'G') { //当前的G， 去左边 方案一
                step1 += i - (gi++);
            } else { // 当前的B， 去左边，方案2
                step2 += i - (bi++);
            }
        }
        return Math.min(step1, step2);

    }

}
