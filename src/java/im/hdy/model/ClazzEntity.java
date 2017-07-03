package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/2.
 */
@Entity
@Table(name = "CLASS", schema = "campus_travle", catalog = "")
public class ClazzEntity {
    private long classId;
    private String className;
    private Integer studentCollege;

    @Id
    @Column(name = "CLASS_ID", nullable = false)
    public long getClassId() {
        return classId;
    }

    public void setClassId(long classId) {
        this.classId = classId;
    }

    @Basic
    @Column(name = "CLASS_NAME", nullable = true, length = 255)
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClazzEntity that = (ClazzEntity) o;

        if (classId != that.classId) return false;
        if (className != null ? !className.equals(that.className) : that.className != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (classId ^ (classId >>> 32));
        result = 31 * result + (className != null ? className.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "STUDENT_COLLEGE", nullable = true)
    public Integer getStudentCollege() {
        return studentCollege;
    }

    public void setStudentCollege(Integer studentCollege) {
        this.studentCollege = studentCollege;
    }
}
