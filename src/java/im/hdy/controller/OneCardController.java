package im.hdy.controller;

import com.alibaba.fastjson.JSON;
import im.hdy.exception.Status;
import im.hdy.model.OneCardConsumeEntity;
import im.hdy.rsa.utils.Constants;
import im.hdy.rsa.utils.RsaUtil;
import im.hdy.service.OneCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by hdy on 2017/7/6.
 * 一卡通控制器
 */
@RestController
@RequestMapping("/oneCard")
public class OneCardController {
    @Autowired
    private OneCardService oneCardService;

    @Value("${repair.decypt.privateKey}")
    private String privateKey;

    /**
     * 获取消费记录
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getConsume(@RequestParam(required = true) Integer page, Map<String, Object> map) {
        if (map.get(Constants.USER_AUTH) == null) {
            //是用户
            List<OneCardConsumeEntity> consume = oneCardService.getConsume(page, (Long) map.get(Constants.REQUEST_USER_KEY));
            return JSON.toJSONString(consume);
        }
        return null;
    }


    /**
     * 工作人员添加消费记录
     * 应该不需要客户端上传上来吧
     * 暂定
     */
//    @RequestMapping(value = "/addConsume", method = RequestMethod.POST)
//    public String addConsume(@RequestParam(required = true) String money, @RequestParam(required = true) Long location, @RequestParam(required = true) String userId, Map<String, Object> map) {
//        money = RsaUtil.decryptData(money, privateKey);
//        userId = RsaUtil.decryptData(userId, privateKey);
//        if ("mess_worker".equals(map.get(Constants.USER_AUTH)) || "supermarker_worker".equals(map.get(Constants.USER_AUTH))) {
//            //是食堂人员或者是超市人员
//            OneCardConsumeEntity entity = oneCardService.addConsume(Double.valueOf(money), location, (Long) map.get(Constants.REQUEST_USER_KEY), Long.valueOf(userId));
//            return JSON.toJSONString(entity);
//        } else {
//            return Constants.noAuth();
//        }
//    }

    /**
     * 消费
     * 需要客户端加密
     * 消费非常重要!!
     */
    @RequestMapping(method = RequestMethod.POST)
    public String consume(@RequestParam(required = true) String money, @RequestParam(required = true) Long location, @RequestParam(required = true) String userid, Map<String, Object> map, @RequestParam(required = true) String payCode) {
        money = RsaUtil.decryptData(money, privateKey);
        userid = RsaUtil.decryptData(userid, privateKey);
        payCode = RsaUtil.decryptData(payCode, privateKey);
        if ("mess_worker".equals(map.get(Constants.USER_AUTH)) || "supermarker_worker".equals(map.get(Constants.USER_AUTH))) {
            Integer lose = oneCardService.getOneCardByUserId((Long) map.get(Constants.REQUEST_USER_KEY)).getLose();
            if (lose == 1) {
                //说明用户已经挂失.无法使用
                return JSON.toJSONString(new Status(500, "账户挂失,无法消费"));
            }
            if (oneCardService.getPayCode((Long) map.get(Constants.REQUEST_USER_KEY)).equals(payCode)) {
                //判断付款码和数据库里的是否相同
                //是食堂人员或者是超市人员
                boolean consume = oneCardService.consume(Double.valueOf(money), Long.valueOf(userid));
                if (consume) {
                    OneCardConsumeEntity entity = oneCardService.addConsume(Double.valueOf(money), location, (Long) map.get(Constants.REQUEST_USER_KEY), Long.valueOf(userid));
                    return JSON.toJSONString(entity);
                }
            } else {
                //付款码失效:
                return JSON.toJSONString(new Status(500, "付款码失效,无法消费"));
            }
        } else {
            return Constants.noAuth();
        }
        return JSON.toJSONString(new Status(500, "账户无法消费"));
    }

    /**
     * 修改密码
     * 要判断是否为首次登录.如果为首次登录.那么直接设置密码就可以了
     */
    @RequestMapping(value = "/changePassword", method = RequestMethod.PUT)
    public String changePassword(@RequestParam(required = true) String newPassword, Map<String, Object> map, @RequestParam(required = true) String oldPassword) {
        newPassword = RsaUtil.decryptData(newPassword, privateKey);
        oldPassword = RsaUtil.decryptData(oldPassword, privateKey);
        String password = oneCardService.getOneCardByUserId((Long) map.get(Constants.REQUEST_USER_KEY)).getPayPassword();
        if (password == null) {
            //如果没有说明是第一次进入,需要修改
            boolean b = oneCardService.changePassword(newPassword, (Long) map.get(Constants.REQUEST_USER_KEY));
            if (b) {
                return JSON.toJSONString(new Status(200, "密码修改成功"));
            } else {
                return JSON.toJSONString(new Status(500, "密码修改失败"));
            }
        } else {
            //说明已经设置好密码了
            if (password.equals(oldPassword)) {
                //判断密码是否正确
                boolean b = oneCardService.changePassword(newPassword, (Long) map.get(Constants.REQUEST_USER_KEY));
                if (b) {
                    return JSON.toJSONString(new Status(200, "密码修改成功"));
                } else {
                    return JSON.toJSONString(new Status(500, "密码修改失败"));
                }
            } else {
                return JSON.toJSONString(new Status(500, "原始密码错误!请重试"));
            }
        }
    }

    /**
     * 挂失
     */
    @RequestMapping(value = "/lose", method = RequestMethod.PUT)
    public String lose(@RequestParam(required = true) Integer lose, @RequestParam(required = true) String oldPassword, Map<String, Object> map) {
        oldPassword = RsaUtil.decryptData(oldPassword, privateKey);
        String password = oneCardService.getOneCardByUserId((Long) map.get(Constants.REQUEST_USER_KEY)).getPayPassword();
        if (password == null) {
            return JSON.toJSONString(new Status(500, "请先设置好密码!"));
        }
        if (password.equals(oldPassword)) {
            //说明密码正确
            if (lose == 0 || lose == 1) {

            } else {
                //说明用户提交的有误
                lose = 1;
            }
            boolean b = oneCardService.lose(lose, (Long) map.get(Constants.REQUEST_USER_KEY));
            if (b) {
                return JSON.toJSONString(new Status(200, "挂失成功!"));
            } else {
                return JSON.toJSONString(new Status(500, "挂失失败!"));
            }
        } else {
            return JSON.toJSONString(new Status(500, "原始密码错误!请重试"));
        }
    }

    /**
     * 付款码修改
     * 需要手机传送公钥
     */
    public void changePayCode(Long userId) {
        oneCardService.changePayCode(userId);
    }


    /**
     * 获取付款码
     */
    @RequestMapping(value = "/getPayCode", method = RequestMethod.GET)
    public String getPayCode(String publicKey, Map<String, Object> map) {
        String payCode = oneCardService.getPayCode((Long) map.get(Constants.REQUEST_USER_KEY));
        return RsaUtil.encryptData(payCode, publicKey);
    }
}
