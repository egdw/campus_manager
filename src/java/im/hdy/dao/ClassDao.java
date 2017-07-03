package im.hdy.dao;

import antlr.LexerSharedInputState;
import im.hdy.model.ClazzEntity;
import im.hdy.model.StudentClassEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by hdy on 2017/7/2.
 */
public interface ClassDao extends JpaRepository<ClazzEntity, Long> {

    List<ClazzEntity> findClazzEntityByStudentCollegeEquals(Integer colleage);
}
