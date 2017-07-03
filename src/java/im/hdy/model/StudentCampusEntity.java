package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/2.
 */
@Entity
@Table(name = "STUDENT_CAMPUS", schema = "campus_travle", catalog = "")
public class StudentCampusEntity {
    private int campusId;
    private String campusName;

    @Id
    @Column(name = "CAMPUS_ID", nullable = false)
    public int getCampusId() {
        return campusId;
    }

    public void setCampusId(int campusId) {
        this.campusId = campusId;
    }

    @Basic
    @Column(name = "CAMPUS_NAME", nullable = true, length = 255)
    public String getCampusName() {
        return campusName;
    }

    public void setCampusName(String campusName) {
        this.campusName = campusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCampusEntity that = (StudentCampusEntity) o;

        if (campusId != that.campusId) return false;
        if (campusName != null ? !campusName.equals(that.campusName) : that.campusName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = campusId;
        result = 31 * result + (campusName != null ? campusName.hashCode() : 0);
        return result;
    }
}
