package im.hdy.dao;

import im.hdy.model.ReapirStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hdy on 2017/7/4.
 */
public interface RepairStatusDao extends JpaRepository<ReapirStatusEntity, Integer> {
}
