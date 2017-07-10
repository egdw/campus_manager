package im.hdy.controller;

import com.alibaba.fastjson.JSON;
import im.hdy.exception.Status;
import im.hdy.model.StudentScoreEntity;
import im.hdy.rsa.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

/**
 * Created by hdy on 2017/7/7.
 */
@RestController
@RequestMapping("/score")
public class CourseAndScoreController {

    /**
     * 获得学分
     */
    @RequestMapping(value = "/getCourseNum", method = RequestMethod.GET)
    public String getCourseum(Map<String, Object> map) {
        Random random = new Random();
        return JSON.toJSONString(new Status(200, random.nextInt(30) + ""));
    }

    /**
     * 获得成绩
     */
    @RequestMapping(value = "/getScore", method = RequestMethod.GET)
    public String getScore(Map<String, Object> map) {
        ArrayList<StudentScoreEntity> lists = new ArrayList<StudentScoreEntity>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            StudentScoreEntity entity = new StudentScoreEntity();
            entity.setScoreId(i);
            entity.setScoreNum(random.nextInt(100));
            entity.setSemesterId(1);
            entity.setStudentProfessionId((long) random.nextInt(17));
            entity.setStudentUserId((Long) map.get(Constants.REQUEST_USER_KEY));
            lists.add(entity);
        }
        return JSON.toJSONString(lists);
    }
}
