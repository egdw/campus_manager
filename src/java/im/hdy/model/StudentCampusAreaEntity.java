package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/2.
 */
@Entity
@Table(name = "STUDENT_CAMPUS_AREA", schema = "campus_travle", catalog = "")
public class StudentCampusAreaEntity {
    private long campusAreaId;
    private String campusAreaName;
    private Integer campusId;

    @Id
    @Column(name = "CAMPUS_AREA_ID", nullable = false)
    public long getCampusAreaId() {
        return campusAreaId;
    }

    public void setCampusAreaId(long campusAreaId) {
        this.campusAreaId = campusAreaId;
    }

    @Basic
    @Column(name = "CAMPUS_AREA_NAME", nullable = true, length = 255)
    public String getCampusAreaName() {
        return campusAreaName;
    }

    public void setCampusAreaName(String campusAreaName) {
        this.campusAreaName = campusAreaName;
    }

    @Basic
    @Column(name = "CAMPUS_ID", nullable = true)
    public Integer getCampusId() {
        return campusId;
    }

    public void setCampusId(Integer campusId) {
        this.campusId = campusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCampusAreaEntity that = (StudentCampusAreaEntity) o;

        if (campusAreaId != that.campusAreaId) return false;
        if (campusAreaName != null ? !campusAreaName.equals(that.campusAreaName) : that.campusAreaName != null)
            return false;
        if (campusId != null ? !campusId.equals(that.campusId) : that.campusId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (campusAreaId ^ (campusAreaId >>> 32));
        result = 31 * result + (campusAreaName != null ? campusAreaName.hashCode() : 0);
        result = 31 * result + (campusId != null ? campusId.hashCode() : 0);
        return result;
    }

}
