package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/9.
 */
@Entity
@Table(name = "COMPLAIN_DETAIL", schema = "campus_travle", catalog = "")
public class ComplainDetailEntity {
    private long complainDetailId;
    private Long complainId;
    private Integer complainLove;
    private Long complainWatch;

    @Id
    @Column(name = "COMPLAIN_DETAIL_ID", nullable = false)
    public long getComplainDetailId() {
        return complainDetailId;
    }

    public void setComplainDetailId(long complainDetailId) {
        this.complainDetailId = complainDetailId;
    }

    @Basic
    @Column(name = "COMPLAIN_ID", nullable = true)
    public Long getComplainId() {
        return complainId;
    }

    public void setComplainId(Long complainId) {
        this.complainId = complainId;
    }

    @Basic
    @Column(name = "COMPLAIN_LOVE", nullable = true)
    public Integer getComplainLove() {
        return complainLove;
    }

    public void setComplainLove(Integer complainLove) {
        this.complainLove = complainLove;
    }

    @Basic
    @Column(name = "COMPLAIN_WATCH", nullable = true)
    public Long getComplainWatch() {
        return complainWatch;
    }

    public void setComplainWatch(Long complainWatch) {
        this.complainWatch = complainWatch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplainDetailEntity that = (ComplainDetailEntity) o;

        if (complainDetailId != that.complainDetailId) return false;
        if (complainId != null ? !complainId.equals(that.complainId) : that.complainId != null) return false;
        if (complainLove != null ? !complainLove.equals(that.complainLove) : that.complainLove != null) return false;
        if (complainWatch != null ? !complainWatch.equals(that.complainWatch) : that.complainWatch != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (complainDetailId ^ (complainDetailId >>> 32));
        result = 31 * result + (complainId != null ? complainId.hashCode() : 0);
        result = 31 * result + (complainLove != null ? complainLove.hashCode() : 0);
        result = 31 * result + (complainWatch != null ? complainWatch.hashCode() : 0);
        return result;
    }
}
