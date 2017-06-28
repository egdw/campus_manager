package im.hdy.service;

import im.hdy.dao.ReciverDao;
import im.hdy.model.ReciverEntity;
import im.hdy.rsa.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by hdy on 2017/6/28.
 */
@Service
@Transactional
public class ReciverService {

    @Autowired
    private ReciverDao reciverDao;

    public ReciverEntity addReciver(ReciverEntity entity) {
        ReciverEntity save = reciverDao.save(entity);
        return save;
    }

    public void updateReciver(ReciverEntity entity) {
    }

    public Page<ReciverEntity> getReciver(int page) {
        PageRequest request = new PageRequest(page, Constants.RECIVER_SERVICE_QUERT_NUM);
        Page<ReciverEntity> all = reciverDao.findAll(request);
        return all;
    }
}
