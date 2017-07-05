package im.hdy.service;

import im.hdy.dao.RepairReportDao;
import im.hdy.dao.RepairStatusDao;
import im.hdy.model.ReapirStatusEntity;
import im.hdy.model.RepairReportEntity;
import im.hdy.rsa.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by hdy on 2017/7/4.
 * 维修服务
 */
@Service
@Transactional
public class RepairService {

    @Autowired
    private RepairStatusDao statusDao;
    @Autowired
    private RepairReportDao reportDao;

    /**
     * 获取维修状态
     */
    public List<ReapirStatusEntity> getRepairStatus() {
        List<ReapirStatusEntity> all = statusDao.findAll();
        return all;
    }

    /**
     * 通过相应的id获取维修状态
     *
     * @param id 维修状态id
     * @return
     */
    public ReapirStatusEntity getRepairStatusById(Integer id) {
        ReapirStatusEntity one = statusDao.findOne(id);
        return one;
    }

    public Page<RepairReportEntity> getRepairReport(Integer page) {
        PageRequest request = new PageRequest(page, Constants.REPAIR_SERVICE_QURTY_NUM);
        Page<RepairReportEntity> all =
                reportDao.findAll(request);
        return all;
    }

    /**
     * 通过传入用户id号获取到相应的数据
     *
     * @param userId
     */
    public List<RepairReportEntity> getRepairReportByUserId(Long userId) {
        List<RepairReportEntity> allByRepairUserIdEquals =
                reportDao.findAllByRepairUserIdEquals(userId);
        return allByRepairUserIdEquals;
    }


    /**
     * 通过传入维修id和申请人id删除
     *
     * @param repairId
     * @param userId
     */
    public boolean removeRepairReport(Long repairId, Long userId) {
        Long repairUserId = reportDao.findOne(repairId).getRepairUserId();
        if (repairUserId != null && repairUserId.equals(userId)) {
            //如果没有问题说明用户正确.进行删除的操作
            reportDao.delete(repairId);
            return true;
        } else {
            return false;
        }
    }


    /**
     * 添加维修
     *
     * @param entity
     * @return
     */
    public RepairReportEntity addRepairReport(RepairReportEntity entity) {
        RepairReportEntity save = reportDao.save(entity);
        return save;
    }

    /**
     * 获取待修理的请求
     */
    public List<RepairReportEntity> getWaitRepair() {
        List<RepairReportEntity> equals = reportDao.findAllByRepairStatusEquals(1);
        return equals;
    }

    /**
     * 获取到待派工的请求
     *
     * @return
     */
    public List<RepairReportEntity> getWaitWorkerRepair() {
        List<RepairReportEntity> equals = reportDao.findAllByRepairStatusEquals(2);
        return equals;
    }

    /**
     * 接受维修请求
     *
     * @param repairId
     * @return
     */
    public boolean acept(Long repairId) {
        int i = reportDao.aceptOrComplete(repairId, 2);
        if (i > 0) {
            return true;
        }
        return false;
    }

    /**
     * 派出工人
     *
     * @return
     */
    public boolean taskWorker(Long repairId, Long workerId) {
        int i = reportDao.updateRepairWorker(3, workerId, repairId);
        if (i > 0) {
            return true;
        }
        return false;
    }


    /**
     * 完成维修工作
     *
     * @return
     */
    public boolean success(Long repairId) {
        int i = reportDao.aceptOrComplete(repairId, 4);
        if (i > 0) {
            return true;
        }
        return false;
    }
}
