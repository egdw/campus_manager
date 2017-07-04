package im.hdy.controller;

import com.alibaba.fastjson.JSON;
import im.hdy.model.*;
import im.hdy.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by hdy on 2017/7/2.
 * 课程表控制器
 */
@Controller
@RequestMapping("/schedual")
public class SchedulingController {
    @Autowired
    private ScheduleService service;


    @RequestMapping("/getSchedulByClassId")
    @ResponseBody
    public String getAllSchedul(Long id) {
        List<CourseSchedulingEntity> schedul = service.getAllSchedul(id);
        return JSON.toJSONString(schedul);
    }

    @RequestMapping("/getAllClassByColleage")
    @ResponseBody
    public String getAllClassByColleage(Integer id) {
        List<ClazzEntity> colleage = service.getAllClassByColleage(id);
        return JSON.toJSONString(colleage);
    }

    //根据校区获取校区内相应区域
    @RequestMapping("/getStudentCampusAreaByStudentCampusId")
    @ResponseBody
    public String getStudentCampusAreaByStudentCampusId(Integer id) {
        List<StudentCampusAreaEntity> studentCampusAreaByStudentCampusId =
                service.getStudentCampusAreaByStudentCampusId(id);
        return JSON.toJSONString(studentCampusAreaByStudentCampusId);
    }

    @RequestMapping("/getTeacherNameById")
    @ResponseBody
    public String getTeacherName(Long id) {
        //返回老师姓名
        String teacherName = service.getTeacherName(id);
        return teacherName;
    }

    @RequestMapping("/getClassDetailById")
    @ResponseBody
    public String getClassDetailById(Long id) {
        StudentProfessionEntity entity = service.getClassDetailById(id);
        return JSON.toJSONString(entity);
    }


    @RequestMapping("/getAllSemster")
    @ResponseBody
    public String getAllSemster() {
        List<SemesterEntity> semster = service.getAllSemster();
        return JSON.toJSONString(semster);
    }


    @RequestMapping("/getAllColleage")
    @ResponseBody
    public String getAllColleage() {
        List<StudentCollegeEntity> colleage = service.getAllColleage();
        return JSON.toJSONString(colleage);
    }

    @RequestMapping("/getAllStudentCampus")
    @ResponseBody
    public String getAllStudentCampus() {
        List<StudentCampusEntity> campus = service.getAllStudentCampus();
        return JSON.toJSONString(campus);
    }


}
