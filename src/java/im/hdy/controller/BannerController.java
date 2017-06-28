package im.hdy.controller;

import com.alibaba.fastjson.JSON;
import im.hdy.model.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by hdy on 2017/6/27.
 */
@Controller
@RequestMapping("/banner_ad")
public class BannerController {

    @RequestMapping("/banners")
    @ResponseBody
    public String getAllBanner(HttpServletRequest request) {
        String path = request.getRealPath("/banner/");
        File file = new File(path);
        ArrayList<Banner> list = new ArrayList<Banner>();
        if (file.exists() && file.isDirectory()) {
            //文件夹如果存在的话
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                File f = files[i];
                String name = "/banner/" + f.getName();
                Banner banner = new Banner();
                banner.setUrl(name);
                list.add(banner);
            }
        }
        return JSON.toJSONString(list);
    }
}
