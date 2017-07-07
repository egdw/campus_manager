package im.hdy.dao;

import im.hdy.model.OneCardConsumeEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by hdy on 2017/7/6.
 */
public interface OneCardConsumeDao extends JpaRepository<OneCardConsumeEntity, Long> {

    @Query("select o from OneCardConsumeEntity as o where o.userId = l1")
    List<OneCardConsumeEntity> getAllByUserId(Long userId, Pageable pageable);
}
