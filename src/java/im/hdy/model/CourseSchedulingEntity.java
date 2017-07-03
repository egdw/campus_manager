package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/2.
 */
@Entity
@Table(name = "COURSE_SCHEDULING", schema = "campus_travle", catalog = "")
public class CourseSchedulingEntity {
    private long courseSchedulingId;
    private Long studentClassId;
    private Long classId;
    private Long teacherId;
    private String classCycle;
    private String classSelection;
    private Integer week;
    private StudentProfessionDetailEntity studentProfessionDetailByClassDetail;
    private Long classDetail;

    @Id
    @Column(name = "COURSE_SCHEDULING_ID", nullable = false)
    public long getCourseSchedulingId() {
        return courseSchedulingId;
    }

    public void setCourseSchedulingId(long courseSchedulingId) {
        this.courseSchedulingId = courseSchedulingId;
    }

    @Basic
    @Column(name = "STUDENT_CLASS_ID", nullable = true)
    public Long getStudentClassId() {
        return studentClassId;
    }

    public void setStudentClassId(Long studentClassId) {
        this.studentClassId = studentClassId;
    }

    @Basic
    @Column(name = "CLASS_ID", nullable = true)
    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "TEACHER_ID", nullable = true)
    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "CLASS_CYCLE", nullable = true, length = 255)
    public String getClassCycle() {
        return classCycle;
    }

    public void setClassCycle(String classCycle) {
        this.classCycle = classCycle;
    }

    @Basic
    @Column(name = "CLASS_SELECTION", nullable = true, length = 255)
    public String getClassSelection() {
        return classSelection;
    }

    public void setClassSelection(String classSelection) {
        this.classSelection = classSelection;
    }

    @Basic
    @Column(name = "WEEK", nullable = true)
    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CourseSchedulingEntity that = (CourseSchedulingEntity) o;

        if (courseSchedulingId != that.courseSchedulingId) return false;
        if (studentClassId != null ? !studentClassId.equals(that.studentClassId) : that.studentClassId != null)
            return false;
        if (classId != null ? !classId.equals(that.classId) : that.classId != null) return false;
        if (teacherId != null ? !teacherId.equals(that.teacherId) : that.teacherId != null) return false;
        if (classCycle != null ? !classCycle.equals(that.classCycle) : that.classCycle != null) return false;
        if (classSelection != null ? !classSelection.equals(that.classSelection) : that.classSelection != null)
            return false;
        if (week != null ? !week.equals(that.week) : that.week != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (courseSchedulingId ^ (courseSchedulingId >>> 32));
        result = 31 * result + (studentClassId != null ? studentClassId.hashCode() : 0);
        result = 31 * result + (classId != null ? classId.hashCode() : 0);
        result = 31 * result + (teacherId != null ? teacherId.hashCode() : 0);
        result = 31 * result + (classCycle != null ? classCycle.hashCode() : 0);
        result = 31 * result + (classSelection != null ? classSelection.hashCode() : 0);
        result = 31 * result + (week != null ? week.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CLASS_DETAIL", referencedColumnName = "STUDENT_PROFESSION_DETAIL_ID")
    public StudentProfessionDetailEntity getStudentProfessionDetailByClassDetail() {
        return studentProfessionDetailByClassDetail;
    }

    public void setStudentProfessionDetailByClassDetail(StudentProfessionDetailEntity studentProfessionDetailByClassDetail) {
        this.studentProfessionDetailByClassDetail = studentProfessionDetailByClassDetail;
    }

    @Basic
    @Column(name = "CLASS_DETAIL", nullable = true)
    public Long getClassDetail() {
        return classDetail;
    }

    public void setClassDetail(Long classDetail) {
        this.classDetail = classDetail;
    }
}
