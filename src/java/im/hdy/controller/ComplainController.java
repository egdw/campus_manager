package im.hdy.controller;

import com.alibaba.fastjson.JSON;
import im.hdy.exception.Status;
import im.hdy.model.ComplainEntity;
import im.hdy.model.ComplainTalkEntity;
import im.hdy.rsa.utils.Constants;
import im.hdy.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

/**
 * Created by hdy on 2017/7/7.
 */
@RestController
@RequestMapping("/complain")
public class ComplainController {
    @Autowired
    private ComplainService service;

    /**
     * 添加操作
     *
     * @param map
     * @param complainTitle
     * @param complainDescription
     * @param complainTypeId
     * @param bigSupervisionId
     * @param SmallSupervision
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public String add(Map<String, Object> map, @RequestParam(required = true) String complainTitle, @RequestParam(required = true) String complainDescription, @RequestParam(required = true) Integer complainTypeId, @RequestParam(required = true) Long bigSupervisionId, @RequestParam(required = true) Long SmallSupervision) {
        ComplainEntity entity = new ComplainEntity();
        entity.setComplainBigSupervisionId(bigSupervisionId);
        entity.setComplainDate(new Timestamp(System.currentTimeMillis()));
        entity.setComplainDescription(complainDescription);
        entity.setComplainSmallSupervisionId(SmallSupervision);
        entity.setComplainTitle(complainTitle);
        entity.setComplainUserId((Long) map.get(Constants.REQUEST_USER_KEY));
        ComplainEntity complain = service.addComplain(entity);
        if (complain == null) {
            return JSON.toJSONString(new Status(500, "添加失败"));
        }
        return JSON.toJSONString(complain);
    }

    /**
     * 工作人员删除操作
     *
     * @param map
     * @param id
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public String delete(Map<String, Object> map, @RequestParam(required = true) Long id) {
        String o = (String) map.get(Constants.USER_AUTH);
        if ("complain_worker".equals(o)) {
            //如果正确说明是是工作人员,可以进行删除操作
            service.removeComplain(id);
            return JSON.toJSONString(new Status(200, "删除成功"));
        }
        return JSON.toJSONString(new Status(500, "删除失败"));
    }

    /**
     * 获取首页的服务信息
     *
     * @param page
     * @return
     */
    @RequestMapping(method = RequestMethod.GET)
    public String get(Integer page) {
        if (page == null) {
            page = 0;
        }
        Page<ComplainEntity> entityPage = service.getAllComplainByNew(page);
        return JSON.toJSONString(entityPage);
    }


    /**
     * 添加评论
     */
    @RequestMapping(value = "/addComplainTalk", method = RequestMethod.POST)
    public String addComplainTalk(Map<String, Object> map, @RequestParam(required = true) Long complainId, @RequestParam(required = true) String description) {
        ComplainEntity one = service.getComplainOne(complainId);
        if (one == null) {
            return JSON.toJSONString(new Status(404, "没有找到"));
        }
        ComplainTalkEntity entity = new ComplainTalkEntity();
        entity.setComplainTalkDate(new Timestamp(System.currentTimeMillis()));
        entity.setComplainTalkDescription(description);
        entity.setComplainTalkLove(0l);
        entity.setTalkUserId((Long) map.get(Constants.REQUEST_USER_KEY));
        entity.setComplainId(complainId);
        ComplainTalkEntity talk = service.addComplainTalk(entity);
        return JSON.toJSONString(talk);
    }

    /**
     * 获取评论
     *
     * @param complainId
     * @param page
     * @return
     */
    @RequestMapping(value = "/getTalk", method = RequestMethod.GET)
    public String getTalk(@RequestParam(required = true) Long complainId, Integer page) {
        if (page == null) {
            page = 0;
        }
        List<ComplainTalkEntity> talkByComplainId = service.getTalkByComplainId(complainId, page);
        return JSON.toJSONString(talkByComplainId);
    }


    /**
     * 点赞
     *
     * @param complainId
     * @return
     */
    @RequestMapping(method = RequestMethod.PUT)
    public String addLove(@RequestParam(required = true) Long complainId) {
        boolean love = service.addLove(complainId);
        if (love) {
            return JSON.toJSONString(new Status(200, "点赞成功"));
        } else {
            return JSON.toJSONString(new Status(500, "点赞失败"));
        }
    }


    @RequestMapping(value = "/my", method = RequestMethod.GET)
    public String getMyComplain(Integer page, Map<String, Object> map) {
        if (page == null) {
            page = 0;
        }
        List<ComplainEntity> all = service.getComplainByUserId((Long) map.get(Constants.REQUEST_USER_KEY), page);
        return JSON.toJSONString(all);
    }
}
