package im.hdy.dao;

import im.hdy.model.UniversitysEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by hdy on 2017/6/26.
 */
public interface UniversityDao extends JpaRepository<UniversitysEntity, Integer> {
    public List<UniversitysEntity> findUniversitysEntityByPid(Integer pid);

    public List<UniversitysEntity> findUniversitysEntityByNameLike(String name);

}
