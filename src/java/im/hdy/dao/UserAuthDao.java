package im.hdy.dao;

import im.hdy.model.UserAuthrityEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by hdy on 2017/7/5.
 */
public interface UserAuthDao extends JpaRepository<UserAuthrityEntity, Long> {
}
