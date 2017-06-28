package im.hdy.controller;

import com.alibaba.fastjson.JSON;
import im.hdy.model.PackageCompanyEntity;
import im.hdy.model.PackageSizeEntity;
import im.hdy.service.PackageCompanyService;
import im.hdy.service.PackageSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by hdy on 2017/6/28.
 */
@Controller
@RequestMapping("/package")
public class PackageController {


    @Autowired
    private PackageCompanyService companyService;

    @Autowired
    private PackageSizeService sizeService;

    @RequestMapping(value = "/getAllPackageCompany", method = RequestMethod.GET)
    @ResponseBody
    public String getAllPackageCompany() {
        List<PackageCompanyEntity> all = companyService.getAll();
        return JSON.toJSONString(all);

    }

    @RequestMapping(value = "/getAllPackageSize", method = RequestMethod.GET)
    @ResponseBody
    public String getAllPackageSize() {
        List<PackageSizeEntity> all = sizeService.getAll();
        return JSON.toJSONString(all);
    }
}
