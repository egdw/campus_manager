package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/2.
 */
@Entity
@Table(name = "STUDENT_PROFESSION_DETAIL", schema = "campus_travle", catalog = "")
public class StudentProfessionDetailEntity {
    private long studentProfessionDetailId;
    private String studentProfessionDetailName;

    @Id
    @Column(name = "STUDENT_PROFESSION_DETAIL_ID", nullable = false)
    public long getStudentProfessionDetailId() {
        return studentProfessionDetailId;
    }

    public void setStudentProfessionDetailId(long studentProfessionDetailId) {
        this.studentProfessionDetailId = studentProfessionDetailId;
    }

    @Basic
    @Column(name = "STUDENT_PROFESSION_DETAIL_NAME", nullable = true, length = 255)
    public String getStudentProfessionDetailName() {
        return studentProfessionDetailName;
    }

    public void setStudentProfessionDetailName(String studentProfessionDetailName) {
        this.studentProfessionDetailName = studentProfessionDetailName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentProfessionDetailEntity that = (StudentProfessionDetailEntity) o;

        if (studentProfessionDetailId != that.studentProfessionDetailId) return false;
        if (studentProfessionDetailName != null ? !studentProfessionDetailName.equals(that.studentProfessionDetailName) : that.studentProfessionDetailName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (studentProfessionDetailId ^ (studentProfessionDetailId >>> 32));
        result = 31 * result + (studentProfessionDetailName != null ? studentProfessionDetailName.hashCode() : 0);
        return result;
    }
}
