package im.hdy.dao;

import im.hdy.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hdy on 2017/6/22.
 */
public interface UserDao extends JpaRepository<UserEntity, Long> {

}
