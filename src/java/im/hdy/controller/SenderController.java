package im.hdy.controller;

import com.alibaba.fastjson.JSON;
import im.hdy.exception.Status;
import im.hdy.model.SenderEntity;
import im.hdy.rsa.utils.Constants;
import im.hdy.service.SenderService;
import im.hdy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Map;

/**
 * Created by hdy on 2017/6/27.
 */
@Controller
@RequestMapping("/sender")
public class SenderController {

    @Autowired
    private SenderService service;
    @Autowired
    private UserService userService;

//    @RequestMapping("/getAll")
//    @ResponseBody
//    public String getAll() {
//        Iterable<SenderEntity> all = service.getAll();
//        return JSON.toJSONString(all);
//    }

    @RequestMapping(value = "/addSender", method = RequestMethod.POST)
    @ResponseBody
    public String addSender(Map<String, Object> requests, @RequestParam(required = true) String sendName, @RequestParam(required = true) String senderPhone, @RequestParam(required = true) String senderIDCard, @RequestParam(required = true) Integer senderLocation1, @RequestParam(required = true) Integer senderLocation2, @RequestParam(required = true) Integer senderLocation3, @RequestParam(required = true) Integer senderPackageCompany, @RequestParam(required = true) Integer senderPackageSize, String description) {
        SenderEntity entity = new SenderEntity();
        entity.setUserByUserId(userService.getOne((Long) requests.get(Constants.REQUEST_USER_KEY)));
        entity.setSenderPackageSize(senderPackageSize);
        entity.setSenderPackageCompany(senderPackageCompany);
        entity.setSenderLocation1(senderLocation1);
        entity.setSenderLocation2(senderLocation2);
        entity.setSenderLocation3(senderLocation3);
        entity.setSenderPhone(senderPhone);
        entity.setSenderName(sendName);
        entity.setSenderIdcard(senderIDCard);
        entity.setSenderPackageDescription(description);
        entity.setSenderCreateDate(new Timestamp(System.currentTimeMillis()));
        entity.setSenderIscomplete(0);
        service.addSender(entity);
        return JSON.toJSONString(new Status(200, "add,success"));
    }

    @RequestMapping(value = "/getSender", method = RequestMethod.GET)
    @ResponseBody
    public String getSender(Map<String, Object> requests, Integer page) {
        Page<SenderEntity> entities = service.getSenderByUserid((Long) requests.get(Constants.REQUEST_USER_KEY), 0);
        return JSON.toJSONString(entities);
    }

    @RequestMapping(value = "/updateSenderSuccess", method = RequestMethod.POST)
    @ResponseBody
    public String updateSenderSuccess(Long id) {
        int i = service.updateSenderSuccess(id);
        if (i > 0) {
            return JSON.toJSONString(new Status(200, "update,success"));
        } else {
            return JSON.toJSONString(new Status(500, "update,error"));
        }

    }

    @RequestMapping(value = "/updateSenderError", method = RequestMethod.POST)
    public String updateSenderCancle(Long id) {
        int i = service.updateSenderCancle(id);
        if (i > 0) {
            return JSON.toJSONString(new Status(200, "update,success"));
        } else {
            return JSON.toJSONString(new Status(500, "update,error"));
        }
    }
}
