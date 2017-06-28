package im.hdy.controller;

import com.alibaba.fastjson.JSON;
import im.hdy.model.UniversitysEntity;
import im.hdy.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by hdy on 2017/6/26.
 */
@Controller
@RequestMapping("/universitys")
public class UniversityController {

    @Autowired
    private UniversityService universityService;

    @RequestMapping(value = "/getAllUniversity", method = RequestMethod.GET)
    @ResponseBody
    public String getAllUniversity() {
        List<UniversitysEntity> all = universityService.getAll();
        return JSON.toJSONString(all);
    }

    @RequestMapping(value = "/getUniversityByPid", method = RequestMethod.GET)
    @ResponseBody
    public String getUniversityByPid(@RequestParam(required = true) Integer pid) {
        List<UniversitysEntity> universityByPid = universityService.getUniversityByPid(pid);
        return JSON.toJSONString(universityByPid);
    }

    @RequestMapping(value = "/getUniversityByName", method = RequestMethod.GET)
    @ResponseBody
    public String getUniversityByName(@RequestParam(required = true) String name) {
        List<UniversitysEntity> list = universityService.getUniversityByName("%" + name + "%");
        return JSON.toJSONString(list);
    }
}
