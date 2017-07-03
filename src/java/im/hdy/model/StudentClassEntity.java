package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/2.
 */
@Entity
@Table(name = "STUDENT_CLASS", schema = "campus_travle", catalog = "")
public class StudentClassEntity {
    private long classId;
    private String className;
    private Long campusArea;
    private StudentCampusAreaEntity studentCampusAreaByCampusArea;

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

    @Basic
    @Column(name = "CAMPUS_AREA", nullable = true)
    public Long getCampusArea() {
        return campusArea;
    }

    public void setCampusArea(Long campusArea) {
        this.campusArea = campusArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentClassEntity that = (StudentClassEntity) o;

        if (classId != that.classId) return false;
        if (className != null ? !className.equals(that.className) : that.className != null) return false;
        if (campusArea != null ? !campusArea.equals(that.campusArea) : that.campusArea != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (classId ^ (classId >>> 32));
        result = 31 * result + (className != null ? className.hashCode() : 0);
        result = 31 * result + (campusArea != null ? campusArea.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "CAMPUS_AREA", referencedColumnName = "CAMPUS_AREA_ID")
    public StudentCampusAreaEntity getStudentCampusAreaByCampusArea() {
        return studentCampusAreaByCampusArea;
    }

    public void setStudentCampusAreaByCampusArea(StudentCampusAreaEntity studentCampusAreaByCampusArea) {
        this.studentCampusAreaByCampusArea = studentCampusAreaByCampusArea;
    }
}
