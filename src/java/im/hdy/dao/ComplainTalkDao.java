package im.hdy.dao;

import im.hdy.model.ComplainTalkEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by hdy on 2017/7/7.
 */
public interface ComplainTalkDao extends JpaRepository<ComplainTalkEntity, Long> {

    List<ComplainTalkEntity> findAllByComplainIdEquals(Long complainId, Pageable pageable);
}
