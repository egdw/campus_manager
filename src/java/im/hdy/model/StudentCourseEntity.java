package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/7.
 */
@Entity
@Table(name = "STUDENT_COURSE", schema = "campus_travle", catalog = "")
public class StudentCourseEntity {
    private long courseid;
    private String courseName;
    private Integer courseCredit;

    @Id
    @Column(name = "COURSEID", nullable = false)
    public long getCourseid() {
        return courseid;
    }

    public void setCourseid(long courseid) {
        this.courseid = courseid;
    }

    @Basic
    @Column(name = "COURSE_NAME", nullable = true, length = 255)
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Basic
    @Column(name = "COURSE_CREDIT", nullable = true)
    public Integer getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(Integer courseCredit) {
        this.courseCredit = courseCredit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCourseEntity that = (StudentCourseEntity) o;

        if (courseid != that.courseid) return false;
        if (courseName != null ? !courseName.equals(that.courseName) : that.courseName != null) return false;
        if (courseCredit != null ? !courseCredit.equals(that.courseCredit) : that.courseCredit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (courseid ^ (courseid >>> 32));
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (courseCredit != null ? courseCredit.hashCode() : 0);
        return result;
    }
}
