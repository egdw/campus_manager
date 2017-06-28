package im.hdy.controller;

import com.alibaba.fastjson.JSON;
import im.hdy.exception.Status;
import im.hdy.model.UserEntity;
import im.hdy.rsa.utils.Md5Utils;
import im.hdy.rsa.utils.RsaUtil;
import im.hdy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.UUID;

/**
 * Created by hdy on 2017/6/22.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserService userService;


    //登录
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam(required = true) Long id, @RequestParam(required = true) String password, @RequestParam(required = true) String publicKey) {
        System.out.println("获取到的加密后的密码:" + password);
        String privateKey = userService.getPrivateKey(String.valueOf(id));
        System.out.println("获取私钥:" + privateKey);
        if (privateKey != null) {
            String passwd = RsaUtil.decryptData(password, privateKey);
            System.out.println(passwd);
            boolean flag = userService.login(id, passwd);
            if (flag) {
                //说明密码和账户正确
                //确定用户可以登录后，生成sessionId和token
                try {
                    String md5 = id + UUID.randomUUID().toString() + passwd;
                    String s = Md5Utils.EncoderByMd5(md5);
                    System.out.println("生成的Md5:" + s);
                    String token = RsaUtil.encryptData(s, publicKey);
                    System.out.println("客户端的公钥:" + publicKey);
                    System.out.println("加密后的Md5:" + token);
                    userService.saveUserTokenByToken(String.valueOf(id), s);
                    userService.saveUserTokenById(String.valueOf(id), s);
                    Status status = new Status(200, token);
                    return JSON.toJSONString(status);
                } catch (Exception e) {
                    Status status = new Status(500, e.getMessage());
                    return JSON.toJSONString(status);
                }
            } else {
                //说明账户密码错误,或者加密错误
                Status status = new Status(401, "账户或密码或加密错误");
                return JSON.toJSONString(status);
            }
        } else {
            Status status = new Status(401, "服务器私钥不存在");
            return JSON.toJSONString(status);
        }
    }

    //用户注册
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public String registerUser(@RequestParam(required = true) Long id, @RequestParam(required = true) String password, @RequestParam(required = true) String publicKey) {
        String privateKey = userService.getPrivateKey(String.valueOf(id));
        String s = RsaUtil.decryptData(password, privateKey);
        if (s != null) {
            if (s.length() < 6) {
                Status status = new Status(500, "密码太短");
                return JSON.toJSONString(status);
            }
            if (s.length() > 17) {
                Status status = new Status(500, "密码太长");
                return JSON.toJSONString(status);
            }
            UserEntity entity = new UserEntity();
            entity.setUserid(id);
            //先随机生成用户名
            entity.setUsername(UUID.randomUUID().toString());
            entity.setPassword(s);
            if (null == userService.getEntity(id)) {
                //说明已经可以开始注册了!
                UserEntity userEntity = userService.saveEntity(entity);
                String md5 = id + UUID.randomUUID().toString() + s;
                try {
                    String s1 = Md5Utils.EncoderByMd5(md5);
                    String token = RsaUtil.encryptData(s1, publicKey);
                    userService.saveUserTokenByToken(String.valueOf(id), s1);
                    Status status = new Status(200, token);
                    return JSON.toJSONString(status);
                } catch (Exception e) {
                    Status status = new Status(500, e.getMessage());
                    return JSON.toJSONString(status);
                }
            } else {
                Status status = new Status(500, "该ID已被注册");
                return JSON.toJSONString(status);
            }
        } else {
            Status status = new Status(500, "密码不能为空");
            return JSON.toJSONString(status);
        }
    }

    //忘记密码
    @RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
    public void forgetPassword(String username, String password) {

    }

    /**
     * 用于app端的登录请求
     * 生成RSA的公钥和密钥.返回给客户端
     */
    @RequestMapping(value = "/getPublicKey", method = RequestMethod.POST)
    @ResponseBody
    public String getPublicKey(@RequestParam(required = true) Long id) {
        String[] pairs = RsaUtil.createKeyPairs();
        Status publicKey = null;
        if (pairs != null) {
            publicKey = new Status(200, pairs[0]);
            userService.savePrivateKey(String.valueOf(id), pairs[1]);
        } else {
            publicKey = new Status(500, "服务器错误");
        }
        return JSON.toJSONString(publicKey);
    }
}
