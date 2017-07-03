package im.hdy.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by hdy on 2017/7/2.
 */
@Entity
@Table(name = "TEACHER", schema = "campus_travle", catalog = "")
public class TeacherEntity {
    private long teacherId;
    private String teacherName;
    private String teacherContact;
    private String teacherHome;
    private String teacherEmail;
    private Timestamp teacherBirthday;
    private String teacherIdcard;
    private String teacherGruadl;
    private Long teacherProfession;

    @Id
    @Column(name = "TEACHER_ID", nullable = false)
    public long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(long teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "TEACHER_NAME", nullable = true, length = 255)
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Basic
    @Column(name = "TEACHER_CONTACT", nullable = true, length = 255)
    public String getTeacherContact() {
        return teacherContact;
    }

    public void setTeacherContact(String teacherContact) {
        this.teacherContact = teacherContact;
    }

    @Basic
    @Column(name = "TEACHER_HOME", nullable = true, length = 255)
    public String getTeacherHome() {
        return teacherHome;
    }

    public void setTeacherHome(String teacherHome) {
        this.teacherHome = teacherHome;
    }

    @Basic
    @Column(name = "TEACHER_EMAIL", nullable = true, length = 255)
    public String getTeacherEmail() {
        return teacherEmail;
    }

    public void setTeacherEmail(String teacherEmail) {
        this.teacherEmail = teacherEmail;
    }

    @Basic
    @Column(name = "TEACHER_BIRTHDAY", nullable = true)
    public Timestamp getTeacherBirthday() {
        return teacherBirthday;
    }

    public void setTeacherBirthday(Timestamp teacherBirthday) {
        this.teacherBirthday = teacherBirthday;
    }

    @Basic
    @Column(name = "TEACHER_IDCARD", nullable = true, length = 255)
    public String getTeacherIdcard() {
        return teacherIdcard;
    }

    public void setTeacherIdcard(String teacherIdcard) {
        this.teacherIdcard = teacherIdcard;
    }

    @Basic
    @Column(name = "TEACHER_GRUADL", nullable = true, length = 255)
    public String getTeacherGruadl() {
        return teacherGruadl;
    }

    public void setTeacherGruadl(String teacherGruadl) {
        this.teacherGruadl = teacherGruadl;
    }

    @Basic
    @Column(name = "TEACHER_PROFESSION", nullable = true)
    public Long getTeacherProfession() {
        return teacherProfession;
    }

    public void setTeacherProfession(Long teacherProfession) {
        this.teacherProfession = teacherProfession;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherEntity that = (TeacherEntity) o;

        if (teacherId != that.teacherId) return false;
        if (teacherName != null ? !teacherName.equals(that.teacherName) : that.teacherName != null) return false;
        if (teacherContact != null ? !teacherContact.equals(that.teacherContact) : that.teacherContact != null)
            return false;
        if (teacherHome != null ? !teacherHome.equals(that.teacherHome) : that.teacherHome != null) return false;
        if (teacherEmail != null ? !teacherEmail.equals(that.teacherEmail) : that.teacherEmail != null) return false;
        if (teacherBirthday != null ? !teacherBirthday.equals(that.teacherBirthday) : that.teacherBirthday != null)
            return false;
        if (teacherIdcard != null ? !teacherIdcard.equals(that.teacherIdcard) : that.teacherIdcard != null)
            return false;
        if (teacherGruadl != null ? !teacherGruadl.equals(that.teacherGruadl) : that.teacherGruadl != null)
            return false;
        if (teacherProfession != null ? !teacherProfession.equals(that.teacherProfession) : that.teacherProfession != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (teacherId ^ (teacherId >>> 32));
        result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
        result = 31 * result + (teacherContact != null ? teacherContact.hashCode() : 0);
        result = 31 * result + (teacherHome != null ? teacherHome.hashCode() : 0);
        result = 31 * result + (teacherEmail != null ? teacherEmail.hashCode() : 0);
        result = 31 * result + (teacherBirthday != null ? teacherBirthday.hashCode() : 0);
        result = 31 * result + (teacherIdcard != null ? teacherIdcard.hashCode() : 0);
        result = 31 * result + (teacherGruadl != null ? teacherGruadl.hashCode() : 0);
        result = 31 * result + (teacherProfession != null ? teacherProfession.hashCode() : 0);
        return result;
    }

}
