package im.hdy.service;

import im.hdy.dao.AuthDao;
import im.hdy.dao.UserAuthDao;
import im.hdy.model.AuthorityEntity;
import im.hdy.model.UserAuthrityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hdy on 2017/7/5.
 * 权限相关服务类
 */
@Service
public class AuthService {

    @Autowired
    private AuthDao authDao;
    @Autowired
    private UserAuthDao userAuthDao;


    /**
     * 得到所有的权限信息
     */
    public List<AuthorityEntity> getALlAuth() {
        List<AuthorityEntity> all = authDao.findAll();
        return all;
    }

    /**
     * 根据用户id获取角色权限
     *
     * @param userId 用户id
     * @return
     */
    public UserAuthrityEntity getAuthByUserId(Long userId) {
        UserAuthrityEntity one =
                userAuthDao.getOne(userId);
        return one;
    }


    /**
     * 移除用户的权限
     *
     * @param userId
     */
    public void removeAuthByUserId(Long userId) {
        userAuthDao.delete(userId);
    }

    /**
     * 添加用户和角色的关系
     *
     * @param userId 用户id
     * @param authId 角色Id
     */
    public UserAuthrityEntity addAuthAndUser(Long userId, Integer authId) {
        UserAuthrityEntity entity = new UserAuthrityEntity();
        entity.setUserId(userId);
        entity.setAuthId(authId);
        UserAuthrityEntity save = userAuthDao.save(entity);
        return save;
    }

}
