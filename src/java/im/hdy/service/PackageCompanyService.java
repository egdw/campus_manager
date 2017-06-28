package im.hdy.service;

import im.hdy.dao.PackageCompanyDao;
import im.hdy.model.PackageCompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hdy on 2017/6/28.
 */
@Service
@Transactional
public class PackageCompanyService {

    @Autowired
    private PackageCompanyDao companyDao;

    public List<PackageCompanyEntity> getAll() {
        return companyDao.findAll();
    }

}
