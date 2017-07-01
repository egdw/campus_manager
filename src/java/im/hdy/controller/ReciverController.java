package im.hdy.controller;

import com.alibaba.fastjson.JSON;
import im.hdy.exception.Status;
import im.hdy.model.ReciverEntity;
import im.hdy.rsa.utils.Constants;
import im.hdy.service.ReciverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by hdy on 2017/6/28.
 */
@RestController
@RequestMapping("/reciver")
public class ReciverController {

    @Autowired
    private ReciverService reciverService;


    /**
     * 添加收取的快递
     *
     * @param postCode     收货编码
     * @param postMessage  发货信息
     * @param postLocation 发货地址
     * @param packCompany  什么快递
     * @param postHost     存放地址
     */
    @RequestMapping(method = RequestMethod.POST)
    public String addReciver(Map<String, Object> request, String postCode, String postMessage, String postLocation, Integer packCompany, Integer postHost) {
        ReciverEntity entity = new ReciverEntity();
        entity.setPostCode(postCode);
        entity.setPostCreatedate(new Timestamp(System.currentTimeMillis()));
        entity.setPostHouse(postHost);
        entity.setPostCompany(packCompany);
        entity.setPostLocation(postLocation);
        entity.setPostMessage(postMessage);
        entity.setUserid((Long) request.get(Constants.REQUEST_USER_KEY));
        ReciverEntity reciver = reciverService.addReciver(entity);
        if (reciver != null) {
            return JSON.toJSONString(reciver);
        } else {
            Status status = new Status(500, "occur exception!");
            return JSON.toJSONString(status);
        }
    }

    /**
     * 获取收取的快递
     *
     * @param page
     */
    @RequestMapping(method = RequestMethod.GET)
    public String getReciver(Map<String, Object> map, Integer page) {
        if (page == null) {
            page = new Integer(0);
        }
        List<ReciverEntity> reciver = reciverService.getReciver(Long.valueOf(String.valueOf(map.get(Constants.REQUEST_USER_KEY))), page);
//        List<ReciverEntity> reciver = reciverService.getReciver(2015002530L, page);
        return JSON.toJSONString(reciver);
    }

    /**
     * 更新快递
     * 进行快递的更新操作
     */
    @RequestMapping(method = RequestMethod.PUT)
    public void updateReciver() {

    }

    /**
     * 进行删除的操作
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteReciver(Integer id) {
        reciverService.delReciver(id);
    }
}
