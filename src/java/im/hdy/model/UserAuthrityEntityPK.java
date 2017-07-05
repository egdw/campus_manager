package im.hdy.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by hdy on 2017/7/5.
 */
public class UserAuthrityEntityPK implements Serializable {
    private long userId;
    private int authId;

    @Column(name = "USER_ID", nullable = false)
    @Id
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Column(name = "AUTH_ID", nullable = false)
    @Id
    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAuthrityEntityPK that = (UserAuthrityEntityPK) o;

        if (userId != that.userId) return false;
        if (authId != that.authId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + authId;
        return result;
    }
}
