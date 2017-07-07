package im.hdy.service;

import im.hdy.dao.OneCardConsumeDao;
import im.hdy.dao.OneCardDao;
import im.hdy.model.OneCardConsumeEntity;
import im.hdy.model.OneCardEntity;
import im.hdy.rsa.utils.Constants;
import im.hdy.rsa.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by hdy on 2017/7/6.
 */
@Service
@Transactional
public class OneCardService {

    @Autowired
    private OneCardConsumeDao oneCardConsumeDao;

    @Autowired
    private OneCardDao oneCardDao;

    @Autowired
    private RedisTemplate redisTemplate;


    /**
     * 获取消费记录
     */
    public List<OneCardConsumeEntity> getConsume(Integer page, Long userId) {
        PageRequest request = new PageRequest(page, Constants.ONE_CARD_CONSUME_QUERT_NUM);
        List<OneCardConsumeEntity> list = oneCardConsumeDao.getAllByUserId(userId, request);
        return list;
    }

    /**
     * 添加消费记录
     */
    public OneCardConsumeEntity addConsume(double money, Long location, Long workId, Long userId) {
        OneCardConsumeEntity entity = new OneCardConsumeEntity();
        entity.setComsumeMoney(money);
        entity.setConsumeLocation(location);
        entity.setConsumeTime(new Timestamp(System.currentTimeMillis()));
        entity.setWorkerid(workId);
        entity.setUserId(userId);
        OneCardConsumeEntity save = oneCardConsumeDao.save(entity);
        //立即修改付款码
        changePayCode(userId);
        return save;
    }

    /**
     * 消费
     * 需要客户端加密
     */
    public boolean consume(double money, Long userid) {
        int i = oneCardDao.updateMoney(money, userid);
        if (i > 0) {
            return true;
        }
        return false;
    }

    /**
     * 修改密码
     */
    public boolean changePassword(String newPasswor, Long userId) {
        int i = oneCardDao.updatePassword(newPasswor, userId);
        if (i > 0) {
            return true;
        }
        return false;
    }

    /**
     * 挂失
     */
    public boolean lose(Integer lose, Long userid) {
        int i = oneCardDao.updateLose(lose, userid);
        if (i > 0) {
            return true;
        }
        return false;
    }

    /**
     * 付款码修改
     * 需要手机传送公钥
     */
    public void changePayCode(Long userId) {
        String password = PasswordUtils.getRandomLengthNum(16);
        redisTemplate.opsForValue().set(userId + "payCode", password);
        redisTemplate.opsForValue().set(userId + "payCodeTime", System.currentTimeMillis());
    }

    public String getPayCode(Long userId) {
        String password = (String) redisTemplate.opsForValue().get(userId + "payCode");
        if (password == null) {
            changePayCode(userId);
            return (String) redisTemplate.opsForValue().get(userId + "payCode");
        }
        Long o = (Long) redisTemplate.opsForValue().get(userId + "payCodeTime");
        if (System.currentTimeMillis() - o > 1000 * 60) {
            //超过一分钟.说明失效了
            changePayCode(userId);
            return (String) redisTemplate.opsForValue().get(userId + "payCode");
        }
        return password;
    }

    public OneCardEntity getOneCard(Long id) {
        OneCardEntity one = oneCardDao.getOne(id);
        return one;
    }


    public OneCardEntity getOneCardByUserId(Long userId) {
        OneCardEntity entity = oneCardDao.findByUserIdEquals(userId);
        return entity;
    }
}
