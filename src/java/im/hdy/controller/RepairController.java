package im.hdy.controller;

import com.alibaba.fastjson.JSON;
import im.hdy.exception.Status;
import im.hdy.model.ReapirStatusEntity;
import im.hdy.model.RepairReportEntity;
import im.hdy.rsa.utils.Constants;
import im.hdy.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by hdy on 2017/7/4.
 * <p>
 * 目前还缺少维修人员的相应接口
 */
@RestController
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairService repairService;
    @Value("${repair.img.url}")
    private String img_save_url;

    /**
     * 获取所有的维修状态
     *
     * @return
     */
    @RequestMapping(value = "/getAllRepairStatus", method = RequestMethod.GET)
    public String getAllRepairStatus() {
        List<ReapirStatusEntity> status = repairService.getRepairStatus();
        return JSON.toJSONString(status);
    }


    /**
     * 普通用户分页获取所保修的维修数据
     */
    @RequestMapping(value = "/getAllRepairReport", method = RequestMethod.GET)
    public String getAllRepairReport(Integer page) {
        if (page == null) {
            page = 0;
        }
        Page<RepairReportEntity> report =
                repairService.getRepairReport(page);
        return JSON.toJSONString(report);
    }

    /**
     * 普通用户添加保修
     * private long repairid;
     * private Integer studentCampusId;
     * private Long studentCampusArea;
     * private Integer bigMaintainId;
     * private Integer smallMaintainId;
     * private String repairPhone;
     * private String repairDetailLocation;
     * private String repairDetailDescrption;
     * private String repairDetailPic;
     * private Long repairUserId;
     * private Long repairWorkerId;
     * private Timestamp repairCreatedata;
     * private Integer repairStatus;
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addRepairReport(@RequestParam(required = true) Integer studentCampusId, @RequestParam(required = true) Long studentCampusArea, @RequestParam(required = true) Integer bigMaintainId, @RequestParam(required = true) Integer smallMaintainId, @RequestParam(required = true) String repairPhone, @RequestParam(required = true) String repairDetailLocation
            , @RequestParam(required = true) String repairDetailDescrption, @RequestParam("files") List<CommonsMultipartFile> files, Map<String, Object> request) {
        //首先向将文件进行上传操作:
        File file = new File(img_save_url);
        if (!file.exists()) {
            file.mkdirs();
        }
        //存放文件地址到数据库
        String fileName = "";
        for (CommonsMultipartFile f : files) {
            try {
                String name = f.getName();
                int i = name.indexOf('.');
                String regex = name.substring(i);
                String FileName = UUID.randomUUID() + regex;
                fileName += FileName + ",";
                File saveFile = new File(file.getAbsolutePath(), FileName);
                f.transferTo(saveFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        RepairReportEntity entity = new RepairReportEntity();
        entity.setBigMaintainId(bigMaintainId);
        entity.setRepairCreatedata(new Timestamp(System.currentTimeMillis()));
        entity.setRepairDetailDescrption(repairDetailDescrption);
        entity.setRepairDetailPic(fileName);
        entity.setRepairDetailLocation(repairDetailLocation);
        entity.setRepairPhone(repairPhone);
        entity.setRepairStatus(1);
        entity.setRepairUserId((Long) request.get(Constants.REQUEST_USER_KEY));
        entity.setSmallMaintainId(smallMaintainId);
        entity.setStudentCampusArea(studentCampusArea);
        entity.setStudentCampusId(studentCampusId);
        RepairReportEntity report = repairService.addRepairReport(entity);
        if (report == null) {
            return JSON.toJSONString(new Status(500, "提交保修请求错误!"));
        }
        return JSON.toJSONString(report);
    }


    /**
     * 用户获取维修数据
     */
    @RequestMapping(method = RequestMethod.GET)
    public String userGetRepairReport(Map<String, Object> requests) {
        List<RepairReportEntity> byUserId = repairService.getRepairReportByUserId((Long) requests.get(Constants.REQUEST_USER_KEY));
        return JSON.toJSONString(byUserId);
    }


    /**
     * 用户手动删除维修数据
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public String deleteRepairReport(Map<String, Object> requests, @RequestParam(required = true) Long repairId) {
        boolean report = repairService.removeRepairReport(repairId, (Long) requests.get(Constants.REQUEST_USER_KEY));
        Status status = null;
        if (report) {
            status = new Status(200, "删除维修数据成功");
        } else {
            status = new Status(500, "删除维修数据失败");
        }
        return JSON.toJSONString(status);
    }


    /**
     * 获取代修理的请求
     */
    @RequestMapping("/getWaitRepair")
    public String getWaitRepair(Map<String, Object> map) {
        if ("repair_worker".equals(map.get(Constants.USER_AUTH))) {
            //如何是正确的,说明有维修工的权限
            List<RepairReportEntity> repair = repairService.getWaitRepair();
            return JSON.toJSONString(repair);
        }
        return Constants.noAuth();
    }

    /**
     * 获取代派工的请求
     */
    @RequestMapping("/getWaitWorkerRepair")
    public String getWaitWorkerRepair(Map<String, Object> map) {
        if ("repair_worker".equals(map.get(Constants.USER_AUTH))) {
            //如何是正确的,说明有维修工的权限
            List<RepairReportEntity> repair = repairService.getWaitRepair();
            return JSON.toJSONString(repair);
        }
        return Constants.noAuth();
    }


    /**
     * 工作人员接受维修请求
     */
    @RequestMapping("/accept")
    public String accept(@RequestParam(required = true) Long repairId, Map<String, Object> map) {
        if ("repair_worker".equals(map.get(Constants.USER_AUTH))) {
            //如何是正确的,说明有维修工的权限
            List<RepairReportEntity> repair = repairService.getWaitRepair();
            return JSON.toJSONString(repair);
        }
        boolean b = repairService.acept(repairId);
        if (b) {
            return JSON.toJSONString(new Status(200, "接受维修成功"));
        }
        return JSON.toJSONString(new Status(500, "接受维修失败"));
    }


    /**
     * 工作人员接受维修请求
     */
    @RequestMapping("/success")
    public String success(@RequestParam(required = true) Long repairId, Map<String, Object> map) {
        if ("repair_worker".equals(map.get(Constants.USER_AUTH))) {
            //如何是正确的,说明有维修工的权限
            List<RepairReportEntity> repair = repairService.getWaitRepair();
            return JSON.toJSONString(repair);
        }
        boolean b = repairService.success(repairId);
        if (b) {
            return JSON.toJSONString(new Status(200, "完成维修成功"));
        }
        return JSON.toJSONString(new Status(500, "完成维修失败"));
    }

    /**
     * 派工
     * 其实就是派自己出去修
     */
    @RequestMapping("/taskWorker")
    public String taskWorker(@RequestParam(required = true) Long repairId, Map<String, Object> map) {
        if ("repair_worker".equals(map.get(Constants.USER_AUTH))) {
            //如何是正确的,说明有维修工的权限
            List<RepairReportEntity> repair = repairService.getWaitRepair();
            return JSON.toJSONString(repair);
        }
        boolean b = repairService.taskWorker(repairId, (Long) map.get(Constants.REQUEST_USER_KEY));
        if (b) {
            return JSON.toJSONString(new Status(200, "完成派工成功"));
        }
        return JSON.toJSONString(new Status(500, "完成派工失败"));
    }
}
