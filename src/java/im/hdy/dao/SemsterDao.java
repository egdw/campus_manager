package im.hdy.dao;

import im.hdy.model.SemesterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hdy on 2017/7/2.
 * 学年
 */
public interface SemsterDao extends JpaRepository<SemesterEntity, Integer> {
}
