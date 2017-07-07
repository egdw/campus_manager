package im.hdy.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by hdy on 2017/7/7.
 */
@Entity
@Table(name = "COMPLAIN", schema = "campus_travle", catalog = "")
public class ComplainEntity {
    private long complainId;
    private String complainTitle;
    private String complainDescription;
    private Integer complainType;
    private Timestamp complainDate;
    private Long complainUserId;
    private Long complainBigSupervisionId;
    private Long complainSmallSupervisionId;

    @Id
    @Column(name = "COMPLAIN_ID", nullable = false)
    public long getComplainId() {
        return complainId;
    }

    public void setComplainId(long complainId) {
        this.complainId = complainId;
    }

    @Basic
    @Column(name = "COMPLAIN_TITLE", nullable = true, length = 255)
    public String getComplainTitle() {
        return complainTitle;
    }

    public void setComplainTitle(String complainTitle) {
        this.complainTitle = complainTitle;
    }

    @Basic
    @Column(name = "COMPLAIN_DESCRIPTION", nullable = true, length = 255)
    public String getComplainDescription() {
        return complainDescription;
    }

    public void setComplainDescription(String complainDescription) {
        this.complainDescription = complainDescription;
    }

    @Basic
    @Column(name = "COMPLAIN_TYPE", nullable = true)
    public Integer getComplainType() {
        return complainType;
    }

    public void setComplainType(Integer complainType) {
        this.complainType = complainType;
    }

    @Basic
    @Column(name = "COMPLAIN_DATE", nullable = true)
    public Timestamp getComplainDate() {
        return complainDate;
    }

    public void setComplainDate(Timestamp complainDate) {
        this.complainDate = complainDate;
    }

    @Basic
    @Column(name = "COMPLAIN_USER_ID", nullable = true)
    public Long getComplainUserId() {
        return complainUserId;
    }

    public void setComplainUserId(Long complainUserId) {
        this.complainUserId = complainUserId;
    }

    @Basic
    @Column(name = "COMPLAIN_BIG_SUPERVISION_ID", nullable = true)
    public Long getComplainBigSupervisionId() {
        return complainBigSupervisionId;
    }

    public void setComplainBigSupervisionId(Long complainBigSupervisionId) {
        this.complainBigSupervisionId = complainBigSupervisionId;
    }

    @Basic
    @Column(name = "COMPLAIN_SMALL_SUPERVISION_ID", nullable = true)
    public Long getComplainSmallSupervisionId() {
        return complainSmallSupervisionId;
    }

    public void setComplainSmallSupervisionId(Long complainSmallSupervisionId) {
        this.complainSmallSupervisionId = complainSmallSupervisionId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplainEntity that = (ComplainEntity) o;

        if (complainId != that.complainId) return false;
        if (complainTitle != null ? !complainTitle.equals(that.complainTitle) : that.complainTitle != null)
            return false;
        if (complainDescription != null ? !complainDescription.equals(that.complainDescription) : that.complainDescription != null)
            return false;
        if (complainType != null ? !complainType.equals(that.complainType) : that.complainType != null) return false;
        if (complainDate != null ? !complainDate.equals(that.complainDate) : that.complainDate != null) return false;
        if (complainUserId != null ? !complainUserId.equals(that.complainUserId) : that.complainUserId != null)
            return false;
        if (complainBigSupervisionId != null ? !complainBigSupervisionId.equals(that.complainBigSupervisionId) : that.complainBigSupervisionId != null)
            return false;
        if (complainSmallSupervisionId != null ? !complainSmallSupervisionId.equals(that.complainSmallSupervisionId) : that.complainSmallSupervisionId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (complainId ^ (complainId >>> 32));
        result = 31 * result + (complainTitle != null ? complainTitle.hashCode() : 0);
        result = 31 * result + (complainDescription != null ? complainDescription.hashCode() : 0);
        result = 31 * result + (complainType != null ? complainType.hashCode() : 0);
        result = 31 * result + (complainDate != null ? complainDate.hashCode() : 0);
        result = 31 * result + (complainUserId != null ? complainUserId.hashCode() : 0);
        result = 31 * result + (complainBigSupervisionId != null ? complainBigSupervisionId.hashCode() : 0);
        result = 31 * result + (complainSmallSupervisionId != null ? complainSmallSupervisionId.hashCode() : 0);
        return result;
    }
}
