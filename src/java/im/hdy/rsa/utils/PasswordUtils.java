package im.hdy.rsa.utils;

import java.util.Random;

/**
 * Created by hdy on 2017/7/6.
 */
public class PasswordUtils {

    /**
     * 获取随机长度的数字
     * 返回字符串
     */
    public static String getRandomLengthNum(int num) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

}
