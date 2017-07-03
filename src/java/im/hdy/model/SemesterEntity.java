package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/2.
 */
@Entity
@Table(name = "SEMESTER", schema = "campus_travle", catalog = "")
public class SemesterEntity {
    private int semesterId;
    private String semesterName;

    @Id
    @Column(name = "SEMESTER_ID", nullable = false)
    public int getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(int semesterId) {
        this.semesterId = semesterId;
    }

    @Basic
    @Column(name = "SEMESTER_NAME", nullable = true, length = 255)
    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SemesterEntity that = (SemesterEntity) o;

        if (semesterId != that.semesterId) return false;
        if (semesterName != null ? !semesterName.equals(that.semesterName) : that.semesterName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = semesterId;
        result = 31 * result + (semesterName != null ? semesterName.hashCode() : 0);
        return result;
    }
}
