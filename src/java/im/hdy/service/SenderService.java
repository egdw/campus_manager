package im.hdy.service;

import im.hdy.dao.SenderDao;
import im.hdy.model.SenderEntity;
import im.hdy.rsa.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hdy on 2017/6/27.
 */
@Service
@Transactional
public class SenderService {

    @Autowired
    private SenderDao dao;

    /**
     * 添加sender
     * 预约快递添加
     */
    public SenderEntity addSender(SenderEntity entity) {
        SenderEntity senderEntity = dao.save(entity);
        return senderEntity;
    }

    /**
     * 预约交易成功
     * SENDER_ISCOMPLETE = 1
     */
    public int updateSenderSuccess(Long id) {
        int i = dao.addSenderSuccess(1, id);
        return i;
    }

    /**
     * 预约交易取消
     * SENDER_ISCOMPLETE = 2
     */
    public int updateSenderCancle(Long id) {
        int i = dao.addSenderCancle(2, id);
        return i;
    }


    /**
     * 根据用户id获取到相应的预约情况
     */
    public Page<SenderEntity> getSenderByUserid(Long userid, int page) {
        PageRequest pageRequest = new PageRequest(page, Constants.SENDER_SERVICE_QUERY_NUM);
        Page<SenderEntity> all = dao.findAll(pageRequest);
        return all;
    }


    public Iterable<SenderEntity> getAll() {
        Iterable<SenderEntity> all = dao.findAll();
        return all;
    }

}
