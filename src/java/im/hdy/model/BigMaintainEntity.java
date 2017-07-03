package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/2.
 */
@Entity
@Table(name = "BIG_MAINTAIN", schema = "campus_travle", catalog = "")
public class BigMaintainEntity {
    private int bigMaintainId;
    private String bigMaintainName;

    @Id
    @Column(name = "BIG_MAINTAIN_ID", nullable = false)
    public int getBigMaintainId() {
        return bigMaintainId;
    }

    public void setBigMaintainId(int bigMaintainId) {
        this.bigMaintainId = bigMaintainId;
    }

    @Basic
    @Column(name = "BIG_MAINTAIN_NAME", nullable = true, length = 255)
    public String getBigMaintainName() {
        return bigMaintainName;
    }

    public void setBigMaintainName(String bigMaintainName) {
        this.bigMaintainName = bigMaintainName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BigMaintainEntity that = (BigMaintainEntity) o;

        if (bigMaintainId != that.bigMaintainId) return false;
        if (bigMaintainName != null ? !bigMaintainName.equals(that.bigMaintainName) : that.bigMaintainName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = bigMaintainId;
        result = 31 * result + (bigMaintainName != null ? bigMaintainName.hashCode() : 0);
        return result;
    }
}
