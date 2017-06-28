package im.hdy.dao;

import im.hdy.model.PackageCompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hdy on 2017/6/28.
 */
public interface PackageCompanyDao extends JpaRepository<PackageCompanyEntity, Integer> {
}
