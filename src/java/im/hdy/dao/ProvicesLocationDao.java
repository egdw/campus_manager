package im.hdy.dao;

import im.hdy.model.ProvicesLocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by hdy on 2017/6/27.
 */
public interface ProvicesLocationDao extends JpaRepository<ProvicesLocationEntity, Long> {

    public List<ProvicesLocationEntity> findProvicesLocationEntityByTypeEquals(Integer type);

    public List<ProvicesLocationEntity> findProvicesLocationEntityByPidEqualsAndTypeEquals(long pid, Integer type);
}
