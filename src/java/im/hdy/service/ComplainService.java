package im.hdy.service;

import im.hdy.dao.ComplainDao;
import im.hdy.dao.ComplainDetailDao;
import im.hdy.dao.ComplainTalkDao;
import im.hdy.dao.ComplainTypeDao;
import im.hdy.model.ComplainDetailEntity;
import im.hdy.model.ComplainEntity;
import im.hdy.model.ComplainTalkEntity;
import im.hdy.model.ComplainTypeEntity;
import im.hdy.rsa.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hdy on 2017/7/7.
 */
@Service
@Transactional
public class ComplainService {

    @Autowired
    private ComplainDao complainDao;

    @Autowired
    private ComplainDetailDao complainDetailDao;

    @Autowired
    private ComplainTalkDao complainTalkDao;

    @Autowired
    private ComplainTypeDao complainTypeDao;


    /**
     * 获取所有的投诉类型
     */
    public List<ComplainTypeEntity> getAllComplainType() {
        List<ComplainTypeEntity> all = complainTypeDao.findAll();
        return all;
    }

    /**
     * 获取所有的服务监督
     * 获取最新的数据
     * 分页
     */
    public Page<ComplainEntity> getAllComplainByNew(Integer page) {
        Sort sort = new Sort(Sort.Direction.DESC, "complainDate");
        PageRequest request = new PageRequest(page, Constants.COMPLAIN_QUERTY_NUM);
        Page<ComplainEntity> all = complainDao.findAll(request);
        return all;
    }


    /**
     * 根据热度显示
     *
     * @param page
     * @return
     */
    public Page<ComplainDetailEntity> getAllComplainByHot(Integer page) {
        Sort sort = new Sort(Sort.Direction.DESC, "complainWatch");
        PageRequest request = new PageRequest(page, Constants.COMPLAIN_QUERTY_NUM);
        Page<ComplainDetailEntity> all =
                complainDetailDao.findAll(request);
        return all;
    }


    /**
     * 根据服务监督id获取相应的评论
     */
    public List<ComplainTalkEntity> getTalkByComplainId(Long complainId, Integer page) {
        Sort sort = new Sort(Sort.Direction.DESC, "complainTalkDate");
        PageRequest request = new PageRequest(page, Constants.COMPLAIN_QUERTY_NUM);
        List<ComplainTalkEntity> all = complainTalkDao.findAllByComplainIdEquals(complainId, request);
        addWatch(complainDao.findOne(complainId));
        return all;
    }

    /**
     * 用于显示我的请求
     */
    public List<ComplainEntity> getComplainByUserId(Long userId, Integer page) {
        Sort sort = new Sort(Sort.Direction.DESC, "complainDate");
        PageRequest request = new PageRequest(page, Constants.COMPLAIN_QUERTY_NUM);
        List<ComplainEntity> equals = complainDao.findAllByComplainUserIdEquals(userId, request);
        return equals;
    }

    /**
     * 管理员用于移除请求
     */
    public void removeComplain(Long complainId) {
        complainDao.delete(complainId);
    }

    /**
     * 添加请求
     *
     * @param entity
     * @return
     */
    public ComplainEntity addComplain(ComplainEntity entity) {
        ComplainEntity save = complainDao.save(entity);
        return save;

    }

    /**
     * 添加评论
     */
    public ComplainTalkEntity addComplainTalk(ComplainTalkEntity entity) {
        ComplainTalkEntity save = complainTalkDao.save(entity);
        return save;
    }

    /**
     * 点赞
     *
     * @param entity
     */
    public boolean addLove(Long entity) {
        ComplainEntity entity1 = complainDao.findOne(entity);
        ComplainDetailEntity detailEntity = complainDetailDao.findByComplainByComplainIdEquals(entity1);
        int love = detailEntity.getComplainLove() + 1;
        int i = complainDetailDao.updateLove(love, entity1);
        if(i>0){
            return true;
        }
        return false;
    }

    /**
     * watch
     */
    public void addWatch(ComplainEntity entity) {
        ComplainDetailEntity detailEntity = complainDetailDao.findByComplainByComplainIdEquals(entity);
        int love = (int) (detailEntity.getComplainWatch() + 1);
        complainDetailDao.updateWatch(love, entity);
    }

}
