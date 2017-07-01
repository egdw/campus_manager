package im.hdy.dao;

import im.hdy.model.SenderEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by hdy on 2017/6/27.
 */
public interface SenderDao extends PagingAndSortingRepository<SenderEntity, Long>, JpaSpecificationExecutor<SenderEntity> {
    @Modifying
    @Query("update SenderEntity s set s.senderIscomplete = ?1 where s.senderId = ?2")
    public int addSenderSuccess(Integer senderIscomplete, Long senderId);

    @Modifying
    @Query("update SenderEntity s set s.senderIscomplete = ?1 where s.senderId = ?2")
    public int addSenderCancle(Integer senderIscomplete, Long senderId);

}
