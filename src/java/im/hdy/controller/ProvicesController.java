package im.hdy.controller;

import com.alibaba.fastjson.JSON;
import im.hdy.exception.Status;
import im.hdy.model.ProvicesEntity;
import im.hdy.service.ProvicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by hdy on 2017/6/26.
 */
@RequestMapping("/provices")
@Controller
public class ProvicesController {
    @Autowired
    private ProvicesService provicesService;

    /**
     * 编码格式转换
     */
    @ModelAttribute
    public void typeChange() {

    }

    /**
     * 获取到所有的省份.
     */
    @RequestMapping(value = "/getAllProvice", method = RequestMethod.GET)
    @ResponseBody
    public String getAllProvices() {
        List<ProvicesEntity> provices = provicesService.getAllProvices();
        String s = JSON.toJSONString(provices);
        return s;
    }

    /**
     * 通过省份信息获取到相应的省份
     */
    @RequestMapping(value = "/getProviceByName", method = RequestMethod.GET)
    @ResponseBody
    public String getProvicesByName(@RequestParam(required = true) String name) {
        System.out.println(name);
        try {
            name = new String(name.getBytes("iso-8859-1"), "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        ProvicesEntity entity = provicesService.findProvicesByName(name);
        if (entity == null) {
            Status status = new Status(404, "not found provice");
            return JSON.toJSONString(status);
        } else {
            String jsonString = JSON.toJSONString(entity);
            return jsonString;
        }
    }

}
