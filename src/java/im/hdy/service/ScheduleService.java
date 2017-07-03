package im.hdy.service;

import im.hdy.dao.*;
import im.hdy.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hdy on 2017/7/2.
 * 用于课程表的服务
 */
@Service
public class ScheduleService {
    @Autowired
    private SemsterDao semsterDao;

    @Autowired
    private ClassDao classDao;//班级

    @Autowired
    private StudentCampusDao studentCampusDao;

    @Autowired
    private StudentCampusAreaDao studentCampusAreaDao;

    @Autowired
    private StudentClassDao studentClassDao;//教室

    @Autowired
    private SchedulDao schedulDao;

    @Autowired
    private StudentColleageDao colleageDao;

    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private StudentProfessionDetailDao studentProfessionDetailDao;

    /**
     * 获取所有的校区
     */
    public List<StudentCampusEntity> getAllStudentCampus() {
        List<StudentCampusEntity> all = studentCampusDao.findAll();
        return all;
    }

    /**
     * 根据校区id获取相应校区下的建筑
     */
    public List<StudentCampusAreaEntity> getStudentCampusAreaByStudentCampusId(Integer campusId) {
        List<StudentCampusAreaEntity> studentCampusAreaEntityByCampusIdEquals = studentCampusAreaDao.findStudentCampusAreaEntityByCampusIdEquals(campusId);
        return studentCampusAreaEntityByCampusIdEquals;
    }

    /**
     * 获取所有的学年
     */
    public List<SemesterEntity> getAllSemster() {
        List<SemesterEntity> all = semsterDao.findAll();
        return all;
    }


    /**
     * 获取学校下所有的工程学院
     */
    public List<StudentCollegeEntity> getAllColleage() {
        List<StudentCollegeEntity> all = colleageDao.findAll();
        return all;
    }

    /**
     * 根据学院id检索下面的班级
     *
     * @param id 学院id号
     */
    public List<ClazzEntity> getAllClassByColleage(Integer id) {
        List<ClazzEntity> collegeEquals = classDao.findClazzEntityByStudentCollegeEquals(id);
        return collegeEquals;
    }


    /**
     * 根据班级id检索所有的课程表
     *
     * @param id 班级id
     *           <p>
     *           由于班级数量太多
     *           我无法完成所有的数据的填写,所以这里无论输入的是什么数据.最后都暂时返回同一个数据
     */
    public List<CourseSchedulingEntity> getAllSchedul(Long id) {
        List<CourseSchedulingEntity> equals = schedulDao.findCourseSchedulingEntityByClassIdEquals((long) 1);
        return equals;
    }

    /**
     * 获取单独的教室
     *
     * @param id 教室id
     * @return
     */
    public StudentClassEntity getStudentClassEntityById(Long id) {
        StudentClassEntity one = studentClassDao.findOne(id);
        return one;
    }

    /**
     * 通过教师id号获取教师的姓名
     * 处于隐私的目的,仅仅只能通过id获取到教师的姓名
     *
     * @param id
     * @return
     */
    public String getTeacherName(Long id) {
        String name = teacherDao.findOne(id).getTeacherName();
        return name;
    }


    /**
     * 根据id获取详细课程数据
     *
     * @param id 课程id
     * @return
     */
    public StudentProfessionEntity getClassDetailById(Long id) {
        StudentProfessionEntity one = studentProfessionDetailDao.findOne(id);
        return one;
    }
}
