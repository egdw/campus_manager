package im.hdy.service;

import im.hdy.dao.UniversityDao;
import im.hdy.model.UniversitysEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by hdy on 2017/6/26.
 */
@Transactional
@Service
public class UniversityService {

    @Autowired
    private UniversityDao universityDao;

    public List<UniversitysEntity> getAll() {
        return universityDao.findAll();
    }

    public List<UniversitysEntity> getUniversityByPid(Integer pid) {
        List<UniversitysEntity> entity = universityDao.findUniversitysEntityByPid(pid);
        return entity;
    }

    public List<UniversitysEntity> getUniversityByName(String name) {
        try {
            name = new String(name.getBytes("iso-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        List<UniversitysEntity> list = universityDao.findUniversitysEntityByNameLike(name);
        return list;
    }

}
