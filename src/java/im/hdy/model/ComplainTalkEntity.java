package im.hdy.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by hdy on 2017/7/9.
 */
@Entity
@Table(name = "COMPLAIN_TALK", schema = "campus_travle", catalog = "")
public class ComplainTalkEntity {
    private long complainTalkId;
    private Long complainId;
    private Timestamp complainTalkDate;
    private String complainTalkDescription;
    private Long complainTalkLove;
    private Long talkUserId;

    @Id
    @Column(name = "COMPLAIN_TALK_ID", nullable = false)
    public long getComplainTalkId() {
        return complainTalkId;
    }

    public void setComplainTalkId(long complainTalkId) {
        this.complainTalkId = complainTalkId;
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
    @Column(name = "COMPLAIN_TALK_DATE", nullable = true)
    public Timestamp getComplainTalkDate() {
        return complainTalkDate;
    }

    public void setComplainTalkDate(Timestamp complainTalkDate) {
        this.complainTalkDate = complainTalkDate;
    }

    @Basic
    @Column(name = "COMPLAIN_TALK_DESCRIPTION", nullable = true, length = 255)
    public String getComplainTalkDescription() {
        return complainTalkDescription;
    }

    public void setComplainTalkDescription(String complainTalkDescription) {
        this.complainTalkDescription = complainTalkDescription;
    }

    @Basic
    @Column(name = "COMPLAIN_TALK_LOVE", nullable = true)
    public Long getComplainTalkLove() {
        return complainTalkLove;
    }

    public void setComplainTalkLove(Long complainTalkLove) {
        this.complainTalkLove = complainTalkLove;
    }

    @Basic
    @Column(name = "TALK_USER_ID", nullable = true)
    public Long getTalkUserId() {
        return talkUserId;
    }

    public void setTalkUserId(Long talkUserId) {
        this.talkUserId = talkUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComplainTalkEntity that = (ComplainTalkEntity) o;

        if (complainTalkId != that.complainTalkId) return false;
        if (complainId != null ? !complainId.equals(that.complainId) : that.complainId != null) return false;
        if (complainTalkDate != null ? !complainTalkDate.equals(that.complainTalkDate) : that.complainTalkDate != null)
            return false;
        if (complainTalkDescription != null ? !complainTalkDescription.equals(that.complainTalkDescription) : that.complainTalkDescription != null)
            return false;
        if (complainTalkLove != null ? !complainTalkLove.equals(that.complainTalkLove) : that.complainTalkLove != null)
            return false;
        if (talkUserId != null ? !talkUserId.equals(that.talkUserId) : that.talkUserId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (complainTalkId ^ (complainTalkId >>> 32));
        result = 31 * result + (complainId != null ? complainId.hashCode() : 0);
        result = 31 * result + (complainTalkDate != null ? complainTalkDate.hashCode() : 0);
        result = 31 * result + (complainTalkDescription != null ? complainTalkDescription.hashCode() : 0);
        result = 31 * result + (complainTalkLove != null ? complainTalkLove.hashCode() : 0);
        result = 31 * result + (talkUserId != null ? talkUserId.hashCode() : 0);
        return result;
    }
}
