package im.hdy.service;

import im.hdy.dao.ProvicesDao;
import im.hdy.model.ProvicesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hdy on 2017/6/26.
 */
@Service
@Transactional
public class ProvicesService {

    @Autowired
    private ProvicesDao provicesDao;


    public List<ProvicesEntity> getAllProvices() {
        List<ProvicesEntity> all1 = provicesDao.findAll();
        return all1;
    }

    public ProvicesEntity findProvicesByName(String name) {
        ProvicesEntity entity = provicesDao.findProviceByName(name);
        return entity;
    }

}
