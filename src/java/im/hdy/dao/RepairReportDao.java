package im.hdy.dao;

import im.hdy.model.RepairReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by hdy on 2017/7/4.
 */
public interface RepairReportDao extends JpaRepository<RepairReportEntity, Long> {

    List<RepairReportEntity> findAllByRepairUserIdEquals(Long userId);
}
