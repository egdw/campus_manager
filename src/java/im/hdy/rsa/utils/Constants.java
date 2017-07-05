package im.hdy.rsa.utils;

import com.alibaba.fastjson.JSON;
import im.hdy.exception.Status;

/**
 * Created by hdy on 2017/6/27.
 * 存放常量
 */
public class Constants {

    //快递预约每次查询的限制数量
    public static final int SENDER_SERVICE_QUERY_NUM = 10;

    //维修数据返回数量
    public static final int REPAIR_SERVICE_QURTY_NUM = 10;

    //request中存放的用户信息
    public static final String REQUEST_USER_KEY = "currentUser";

    public static final int RECIVER_SERVICE_QUERT_NUM = 10;

    public static final String USER_AUTH = "USER_AUTH";


    public static String noAuth(){
        return JSON.toJSONString(new Status(401,"没有权限"));
    }
}
