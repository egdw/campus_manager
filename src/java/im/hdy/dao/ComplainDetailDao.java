package im.hdy.dao;

import im.hdy.model.ComplainDetailEntity;
import im.hdy.model.ComplainEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by hdy on 2017/7/7.
 */
public interface ComplainDetailDao extends JpaRepository<ComplainDetailEntity, Long> {

    @Modifying
    @Query("update ComplainDetailEntity as c set c.complainLove = ?1 where c.complainId = ?2")
    int updateLove(Integer love, long entity);

    @Modifying
    @Query("update ComplainDetailEntity as c set c.complainWatch = :watch where c.complainId = :id")
    int updateWatch(@Param("watch") Long watch, @Param("id") long id);

    ComplainDetailEntity findByComplainIdEquals(Long complainId);
}
