package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/6.
 */
@Entity
@Table(name = "ONE_CARD", schema = "campus_travle", catalog = "")
public class OneCardEntity {
    private long cardId;
    private Long userId;
    private Double cardMoney;
    private String payPassword;
    private Integer lose;

    @Id
    @Column(name = "CARD_ID", nullable = false)
    public long getCardId() {
        return cardId;
    }

    public void setCardId(long cardId) {
        this.cardId = cardId;
    }

    @Basic
    @Column(name = "USER_ID", nullable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "CARD_MONEY", nullable = true, precision = 2)
    public Double getCardMoney() {
        return cardMoney;
    }

    public void setCardMoney(Double cardMoney) {
        this.cardMoney = cardMoney;
    }

    @Basic
    @Column(name = "PAY_PASSWORD", nullable = true, length = 255)
    public String getPayPassword() {
        return payPassword;
    }

    public void setPayPassword(String payPassword) {
        this.payPassword = payPassword;
    }

    @Basic
    @Column(name = "LOSE", nullable = true)
    public Integer getLose() {
        return lose;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OneCardEntity that = (OneCardEntity) o;

        if (cardId != that.cardId) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (cardMoney != null ? !cardMoney.equals(that.cardMoney) : that.cardMoney != null) return false;
        if (payPassword != null ? !payPassword.equals(that.payPassword) : that.payPassword != null) return false;
        if (lose != null ? !lose.equals(that.lose) : that.lose != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (cardId ^ (cardId >>> 32));
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (cardMoney != null ? cardMoney.hashCode() : 0);
        result = 31 * result + (payPassword != null ? payPassword.hashCode() : 0);
        result = 31 * result + (lose != null ? lose.hashCode() : 0);
        return result;
    }
}
