package im.hdy.dao;

import im.hdy.model.ReciverEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by hdy on 2017/6/28.
 * 快递接收者
 */
public interface ReciverDao extends PagingAndSortingRepository<ReciverEntity, Integer>, JpaSpecificationExecutor<ReciverEntity> {
}
