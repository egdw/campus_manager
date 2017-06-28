package im.hdy.service;

import im.hdy.dao.UserDao;
import im.hdy.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hdy on 2017/6/22.
 */
@Transactional
@Service
public class UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RedisTemplate redisTemplate;


    public UserEntity getOne(Long id){
        return userDao.getOne(id);
    }

    public boolean login(Long id, String password) {
        UserEntity one = userDao.getOne(id);
        System.out.println(one);
        System.out.println(password);
        if (one != null) {
            String passwd = one.getPassword();
            System.out.println(passwd);
            if (passwd.equals(password)) {
                //说明密码正确
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public void updateUserEntity() {
    }

    public UserEntity getEntity(Long id) {
        UserEntity one = userDao.getOne(id);
        return one;
    }

    public UserEntity saveEntity(UserEntity userEntity) {
        UserEntity entity = userDao.saveAndFlush(userEntity);
        return entity;
    }

    public boolean savePrivateKey(String id, String privateKey) {
        redisTemplate.opsForValue().set(id + "privatekey", privateKey);
        return true;
    }

    public String getPrivateKey(String id) {
        String privateKey = (String) redisTemplate.opsForValue().get(id + "privatekey");
        return privateKey;
    }


    public void saveUserTokenByToken(String id, String token) {
        redisTemplate.opsForValue().set(token, id);
    }

    public String getUserTokenByToken(String token) {
        String id = (String) redisTemplate.opsForValue().get(token);
        return id;
    }

    public void saveUserTokenById(String id, String token) {
        redisTemplate.opsForValue().set(id + "token", token);
    }

    public String getUserTokenById(String id) {
        return (String) redisTemplate.opsForValue().get(id + "token");
    }
}
