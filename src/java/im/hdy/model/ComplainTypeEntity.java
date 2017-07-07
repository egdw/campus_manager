package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/7.
 */
@Entity
@Table(name = "COMPLAIN_TYPE", schema = "campus_travle", catalog = "")
public class ComplainTypeEntity {
    private int complainTypeId;
    private String complainName;

    @Id
    @Column(name = "COMPLAIN_TYPE_ID", nullable = false)
    public int getComplainTypeId() {
        return complainTypeId;
    }

    public void setComplainTypeId(int complainTypeId) {
        this.complainTypeId = complainTypeId;
    }

    @Basic
    @Column(name = "COMPLAIN_NAME", nullable = true, length = 255)
    public String getComplainName() {
        return complainName;
    }

    public void setComplainName(String complainName) {
        this.complainName = complainName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplainTypeEntity that = (ComplainTypeEntity) o;

        if (complainTypeId != that.complainTypeId) return false;
        if (complainName != null ? !complainName.equals(that.complainName) : that.complainName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = complainTypeId;
        result = 31 * result + (complainName != null ? complainName.hashCode() : 0);
        return result;
    }
}
