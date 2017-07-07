package im.hdy.dao;

import im.hdy.model.ComplainEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by hdy on 2017/7/7.
 */
public interface ComplainDao extends PagingAndSortingRepository<ComplainEntity, Long> {
    List<ComplainEntity> findAllByComplainUserIdEquals(Long userId, Pageable pageable);
}
