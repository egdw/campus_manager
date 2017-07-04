package im.hdy.service;

import im.hdy.dao.ProvicesLocationDao;
import im.hdy.model.ProvicesLocationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hdy on 2017/6/27.
 */
@Service
@Transactional
public class ProviceLocationService {
    @Autowired
    private ProvicesLocationDao locationDao;

    public List<ProvicesLocationEntity> getAll() {
        return locationDao.findAll();
    }

    /**
     * 获取所有的省
     *
     * @return
     */
    public List<ProvicesLocationEntity> getAllProvice() {
        List<ProvicesLocationEntity> provices = locationDao.findProvicesLocationEntityByTypeEquals(0);
        return provices;
    }

    /**
     * @param pid 上级省份的id号
     *            市级
     */
    public List<ProvicesLocationEntity> getAllCity(long pid) {
        List<ProvicesLocationEntity> provicesLocationEntityByPidEqualsAndTypeEquals = locationDao.findProvicesLocationEntityByPidEqualsAndTypeEquals(pid, 1);
        return provicesLocationEntityByPidEqualsAndTypeEquals;
    }


    /**
     * 上级城市的id
     *
     * @return
     */
    public List<ProvicesLocationEntity> getAllCountry(long pid) {
        List<ProvicesLocationEntity> provicesLocationEntityByPidEqualsAndTypeEquals = locationDao.findProvicesLocationEntityByPidEqualsAndTypeEquals(pid, 2);
        return provicesLocationEntityByPidEqualsAndTypeEquals;
    }
}
