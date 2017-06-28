package im.hdy.controller;

import com.alibaba.fastjson.JSON;
import im.hdy.model.ProvicesLocationEntity;
import im.hdy.service.ProviceLocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by hdy on 2017/6/27.
 */
@Controller
@RequestMapping("/proviceslocation")
public class ProvicesLocationController {
    @Autowired
    private ProviceLocationService service;

    /**
     * 获取所有的省
     *
     * @return
     */
    @RequestMapping(value = "/getAllProvice", method = RequestMethod.GET)
    @ResponseBody
    public String getAllProvice() {
        List<ProvicesLocationEntity> provices = service.getAllProvice();
        return JSON.toJSONString(provices);
    }

    /**
     * @param type = 1
     *             市级
     * @param pid  上级省份的id号
     */
    @RequestMapping(value = "/getAllCity", method = RequestMethod.GET)
    @ResponseBody
    public String getAllCity(Long pid) {
        List<ProvicesLocationEntity> city = service.getAllCity(pid);
        return JSON.toJSONString(city);
    }


    /**
     * 上级城市的id
     *
     * @param pid
     * @return
     */
    @RequestMapping(value = "/getAllCountry", method = RequestMethod.GET)
    @ResponseBody
    public String getAllCountry(Long pid) {
        List<ProvicesLocationEntity> country = service.getAllCountry(pid);
        return JSON.toJSONString(country);
    }
}
