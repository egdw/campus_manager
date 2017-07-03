package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/2.
 */
@Entity
@Table(name = "STUDENT_COLLEGE", schema = "campus_travle", catalog = "")
public class StudentCollegeEntity {
    private int collegeId;
    private String collegeName;

    @Id
    @Column(name = "COLLEGE_ID", nullable = false)
    public int getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(int collegeId) {
        this.collegeId = collegeId;
    }

    @Basic
    @Column(name = "COLLEGE_NAME", nullable = true, length = 255)
    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentCollegeEntity that = (StudentCollegeEntity) o;

        if (collegeId != that.collegeId) return false;
        if (collegeName != null ? !collegeName.equals(that.collegeName) : that.collegeName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = collegeId;
        result = 31 * result + (collegeName != null ? collegeName.hashCode() : 0);
        return result;
    }
}
