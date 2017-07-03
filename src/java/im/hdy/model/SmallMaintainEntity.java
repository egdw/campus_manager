package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/2.
 */
@Entity
@Table(name = "SMALL_MAINTAIN", schema = "campus_travle", catalog = "")
public class SmallMaintainEntity {
    private int smallMaintainId;
    private String smallMaintainName;
    private Integer bigMaintainId;
    private BigMaintainEntity bigMaintainByBigMaintainId;

    @Id
    @Column(name = "SMALL_MAINTAIN_ID", nullable = false)
    public int getSmallMaintainId() {
        return smallMaintainId;
    }

    public void setSmallMaintainId(int smallMaintainId) {
        this.smallMaintainId = smallMaintainId;
    }

    @Basic
    @Column(name = "SMALL_MAINTAIN_NAME", nullable = true, length = 255)
    public String getSmallMaintainName() {
        return smallMaintainName;
    }

    public void setSmallMaintainName(String smallMaintainName) {
        this.smallMaintainName = smallMaintainName;
    }

    @Basic
    @Column(name = "BIG_MAINTAIN_ID", nullable = true)
    public Integer getBigMaintainId() {
        return bigMaintainId;
    }

    public void setBigMaintainId(Integer bigMaintainId) {
        this.bigMaintainId = bigMaintainId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SmallMaintainEntity that = (SmallMaintainEntity) o;

        if (smallMaintainId != that.smallMaintainId) return false;
        if (smallMaintainName != null ? !smallMaintainName.equals(that.smallMaintainName) : that.smallMaintainName != null)
            return false;
        if (bigMaintainId != null ? !bigMaintainId.equals(that.bigMaintainId) : that.bigMaintainId != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = smallMaintainId;
        result = 31 * result + (smallMaintainName != null ? smallMaintainName.hashCode() : 0);
        result = 31 * result + (bigMaintainId != null ? bigMaintainId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "BIG_MAINTAIN_ID", referencedColumnName = "BIG_MAINTAIN_ID")
    public BigMaintainEntity getBigMaintainByBigMaintainId() {
        return bigMaintainByBigMaintainId;
    }

    public void setBigMaintainByBigMaintainId(BigMaintainEntity bigMaintainByBigMaintainId) {
        this.bigMaintainByBigMaintainId = bigMaintainByBigMaintainId;
    }
}
