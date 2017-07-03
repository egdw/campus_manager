package im.hdy.dao;

import im.hdy.model.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hdy on 2017/7/2.
 */
public interface TeacherDao extends JpaRepository<TeacherEntity, Long> {
}
