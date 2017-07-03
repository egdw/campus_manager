package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/3.
 */
@Entity
@Table(name = "STUDENT_PROFESSION", schema = "campus_travle", catalog = "")
public class StudentProfessionEntity {
    private long professionId;
    private String professionName;
    private Integer collegeId;

    @Id
    @Column(name = "PROFESSION_ID", nullable = false)
    public long getProfessionId() {
        return professionId;
    }

    public void setProfessionId(long professionId) {
        this.professionId = professionId;
    }

    @Basic
    @Column(name = "PROFESSION_NAME", nullable = true, length = 255)
    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    @Basic
    @Column(name = "COLLEGE_ID", nullable = true)
    public Integer getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(Integer collegeId) {
        this.collegeId = collegeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentProfessionEntity that = (StudentProfessionEntity) o;

        if (professionId != that.professionId) return false;
        if (professionName != null ? !professionName.equals(that.professionName) : that.professionName != null)
            return false;
        if (collegeId != null ? !collegeId.equals(that.collegeId) : that.collegeId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (professionId ^ (professionId >>> 32));
        result = 31 * result + (professionName != null ? professionName.hashCode() : 0);
        result = 31 * result + (collegeId != null ? collegeId.hashCode() : 0);
        return result;
    }
}
