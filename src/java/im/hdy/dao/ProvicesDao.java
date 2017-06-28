package im.hdy.dao;

import im.hdy.model.ProvicesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by hdy on 2017/6/26.
 */
public interface ProvicesDao extends JpaRepository<ProvicesEntity, Integer> {
    @Query(value = "SELECT p FROM ProvicesEntity p where name = ?1")
    public ProvicesEntity findProviceByName(String name);
}
