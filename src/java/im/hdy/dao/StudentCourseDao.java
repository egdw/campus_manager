package im.hdy.dao;

import im.hdy.model.StudentCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hdy on 2017/7/7.
 */
public interface StudentCourseDao extends JpaRepository<StudentCourseEntity, Long> {
}
