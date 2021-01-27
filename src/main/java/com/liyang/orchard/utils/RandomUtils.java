package com.liyang.orchard.utils;

import java.awt.*;
import java.util.Random;
public class RandomUtils extends org.apache.commons.lang3.RandomUtils {

    // 设置所有字符
    private static final char[] CODE_SEQ = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
            'K', 'L', 'M', 'N', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z', '2', '3', '4', '5', '6', '7', '8', '9' };
    private static final char[] NUMBER_ARRAY = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

    // 初始化对象
    private static Random random = new Random();

    /**
     * 随机生成一段length长度的字符串
     * @param length 字符串长度
     * @return 随机字符串
     */
    public static String randomString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(String.valueOf(CODE_SEQ[random.nextInt(CODE_SEQ.length)]));
        }
        return sb.toString();
    }

    /**
     * 随机生成数字字符串
     * @param length 字符串长度
     * @return 随机字符串
     */
    public static String randomNumberString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(String.valueOf(NUMBER_ARRAY[random.nextInt(NUMBER_ARRAY.length)]));
        }
        return sb.toString();
    }

    /**
     * 随机生成颜色
     * @param fc 前景色
     * @param bc 背景色
     * @return 随机颜色
     */
    public static Color randomColor(int fc, int bc) {
        int f = fc;
        int b = bc;
        Random random = new Random();
        if (f > 255) {
            f = 255;
        }
        if (b > 255) {
            b = 255;
        }
        return new Color(f + random.nextInt(b - f), f + random.nextInt(b - f), f + random.nextInt(b - f));
    }

}