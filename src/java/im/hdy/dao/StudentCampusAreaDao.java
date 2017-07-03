package im.hdy.dao;

import im.hdy.model.StudentCampusAreaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by hdy on 2017/7/2.
 */
public interface StudentCampusAreaDao extends JpaRepository<StudentCampusAreaEntity, Long> {

    List<StudentCampusAreaEntity> findStudentCampusAreaEntityByCampusIdEquals(Integer campusId);
}
