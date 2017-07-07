package im.hdy.dao;

import im.hdy.model.ComplainDetailEntity;
import im.hdy.model.ComplainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by hdy on 2017/7/7.
 */
public interface ComplainDetailDao extends JpaRepository<ComplainDetailEntity, Long> {

    @Modifying
    @Query("update ComplainDetailEntity as c set c.complainLove = l1 where c.complainByComplainId = l2")
    int updateLove(Integer love, ComplainEntity entity);

    @Modifying
    @Query("update ComplainDetailEntity as c set c.complainWatch = l1 where c.complainByComplainId = l2")
    int updateWatch(Integer watch, ComplainEntity entity);

    ComplainDetailEntity findByComplainByComplainIdEquals(ComplainEntity entity);
}
