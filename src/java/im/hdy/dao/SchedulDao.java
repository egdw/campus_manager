package im.hdy.dao;

import im.hdy.model.CourseSchedulingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by hdy on 2017/7/2.
 * 课表
 */
public interface SchedulDao extends JpaRepository<CourseSchedulingEntity, Long> {

    List<CourseSchedulingEntity> findCourseSchedulingEntityByClassIdEquals(Long id);
}
