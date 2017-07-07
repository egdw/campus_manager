package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/7.
 */
@Entity
@Table(name = "STUDENT_SCORE", schema = "campus_travle", catalog = "")
public class StudentScoreEntity {
    private long scoreId;
    private Long studentProfessionId;
    private Long studentUserId;
    private Integer scoreNum;
    private Integer semesterId;

    @Id
    @Column(name = "SCORE_ID", nullable = false)
    public long getScoreId() {
        return scoreId;
    }

    public void setScoreId(long scoreId) {
        this.scoreId = scoreId;
    }

    @Basic
    @Column(name = "STUDENT_PROFESSION_ID", nullable = true)
    public Long getStudentProfessionId() {
        return studentProfessionId;
    }

    public void setStudentProfessionId(Long studentProfessionId) {
        this.studentProfessionId = studentProfessionId;
    }

    @Basic
    @Column(name = "STUDENT_USER_ID", nullable = true)
    public Long getStudentUserId() {
        return studentUserId;
    }

    public void setStudentUserId(Long studentUserId) {
        this.studentUserId = studentUserId;
    }

    @Basic
    @Column(name = "SCORE_NUM", nullable = true)
    public Integer getScoreNum() {
        return scoreNum;
    }

    public void setScoreNum(Integer scoreNum) {
        this.scoreNum = scoreNum;
    }

    @Basic
    @Column(name = "SEMESTER_ID", nullable = true)
    public Integer getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Integer semesterId) {
        this.semesterId = semesterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentScoreEntity that = (StudentScoreEntity) o;

        if (scoreId != that.scoreId) return false;
        if (studentProfessionId != null ? !studentProfessionId.equals(that.studentProfessionId) : that.studentProfessionId != null)
            return false;
        if (studentUserId != null ? !studentUserId.equals(that.studentUserId) : that.studentUserId != null)
            return false;
        if (scoreNum != null ? !scoreNum.equals(that.scoreNum) : that.scoreNum != null) return false;
        if (semesterId != null ? !semesterId.equals(that.semesterId) : that.semesterId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (scoreId ^ (scoreId >>> 32));
        result = 31 * result + (studentProfessionId != null ? studentProfessionId.hashCode() : 0);
        result = 31 * result + (studentUserId != null ? studentUserId.hashCode() : 0);
        result = 31 * result + (scoreNum != null ? scoreNum.hashCode() : 0);
        result = 31 * result + (semesterId != null ? semesterId.hashCode() : 0);
        return result;
    }
}
