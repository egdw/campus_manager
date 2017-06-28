package im.hdy.service;

import im.hdy.dao.PackageSizeDao;
import im.hdy.model.PackageSizeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hdy on 2017/6/28.
 */
@Service
@Transactional
public class PackageSizeService {

    @Autowired
    private PackageSizeDao sizeDao;

    public List<PackageSizeEntity> getAll() {
        List<PackageSizeEntity> all = sizeDao.findAll();
        return all;
    }
}
