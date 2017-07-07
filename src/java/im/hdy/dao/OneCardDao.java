package im.hdy.dao;

import im.hdy.model.OneCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * Created by hdy on 2017/7/6.
 */
public interface OneCardDao extends JpaRepository<OneCardEntity, Long> {

    @Modifying
    @Query("update OneCardEntity as oce set oce.payPassword = l1 where oce.userId = l2")
    public int updatePassword(String password, Long userId);

    @Modifying
    @Query("update OneCardEntity  as oce set oce.cardMoney = l1 where oce.userId = l2")
    public int updateMoney(Double money, Long userid);


    @Modifying
    @Query("update OneCardEntity as oce set oce.lose = l1 where oce.userId = l2")
    public int updateLose(Integer lose, Long userId);


    public OneCardEntity findByUserIdEquals(Long userId);
}
