package im.hdy.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by hdy on 2017/7/6.
 */
@Entity
@Table(name = "ONE_CARD_CONSUME", schema = "campus_travle", catalog = "")
public class OneCardConsumeEntity {
    private long cardConsumeId;
    private Double comsumeMoney;
    private Timestamp consumeTime;
    private Long consumeLocation;
    private Long workerid;
    private Long userId;

    @Id
    @Column(name = "CARD_CONSUME_ID", nullable = false)
    public long getCardConsumeId() {
        return cardConsumeId;
    }

    public void setCardConsumeId(long cardConsumeId) {
        this.cardConsumeId = cardConsumeId;
    }

    @Basic
    @Column(name = "COMSUME_MONEY", nullable = true, precision = 2)
    public Double getComsumeMoney() {
        return comsumeMoney;
    }

    public void setComsumeMoney(Double comsumeMoney) {
        this.comsumeMoney = comsumeMoney;
    }

    @Basic
    @Column(name = "CONSUME_TIME", nullable = true)
    public Timestamp getConsumeTime() {
        return consumeTime;
    }

    public void setConsumeTime(Timestamp consumeTime) {
        this.consumeTime = consumeTime;
    }

    @Basic
    @Column(name = "CONSUME_LOCATION", nullable = true)
    public Long getConsumeLocation() {
        return consumeLocation;
    }

    public void setConsumeLocation(Long consumeLocation) {
        this.consumeLocation = consumeLocation;
    }

    @Basic
    @Column(name = "WORKERID", nullable = true)
    public Long getWorkerid() {
        return workerid;
    }

    public void setWorkerid(Long workerid) {
        this.workerid = workerid;
    }

    @Basic
    @Column(name = "USER_ID", nullable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OneCardConsumeEntity that = (OneCardConsumeEntity) o;

        if (cardConsumeId != that.cardConsumeId) return false;
        if (comsumeMoney != null ? !comsumeMoney.equals(that.comsumeMoney) : that.comsumeMoney != null) return false;
        if (consumeTime != null ? !consumeTime.equals(that.consumeTime) : that.consumeTime != null) return false;
        if (consumeLocation != null ? !consumeLocation.equals(that.consumeLocation) : that.consumeLocation != null)
            return false;
        if (workerid != null ? !workerid.equals(that.workerid) : that.workerid != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cardConsumeId ^ (cardConsumeId >>> 32));
        result = 31 * result + (comsumeMoney != null ? comsumeMoney.hashCode() : 0);
        result = 31 * result + (consumeTime != null ? consumeTime.hashCode() : 0);
        result = 31 * result + (consumeLocation != null ? consumeLocation.hashCode() : 0);
        result = 31 * result + (workerid != null ? workerid.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }
}
