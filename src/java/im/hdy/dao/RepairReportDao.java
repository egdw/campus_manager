package im.hdy.dao;

import im.hdy.model.RepairReportEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by hdy on 2017/7/4.
 */
public interface RepairReportDao extends PagingAndSortingRepository<RepairReportEntity, Long> {

    List<RepairReportEntity> findAllByRepairUserIdEquals(Long userId);

    //通过状态检索需要的内容
    List<RepairReportEntity> findAllByRepairStatusEquals(Integer status);

    @Modifying
    @Query("update RepairReportEntity as re set re.repairStatus= ?2 where re.repairid = ?1")
    int aceptOrComplete(Long repairId, Integer status);

    @Modifying
    @Query("update RepairReportEntity as pe set pe.repairStatus=?1,pe.repairWorkerId = ?2 where pe.repairid= ?3 ")
    int updateRepairWorker(Integer status, Long userId, Long repairId);
}
