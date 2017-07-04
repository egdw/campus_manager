package im.hdy.controller;

import com.alibaba.fastjson.JSON;
import im.hdy.model.ReapirStatusEntity;
import im.hdy.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by hdy on 2017/7/4.
 */
@RestController
@RequestMapping("/repair")
public class RepairController {

    @Autowired
    private RepairService repairService;

    @RequestMapping(value = "/getAllRepairStatus", method = RequestMethod.GET)
    public String getAllRepairStatus() {
        List<ReapirStatusEntity> status = repairService.getRepairStatus();
        return JSON.toJSONString(status);
    }

}
