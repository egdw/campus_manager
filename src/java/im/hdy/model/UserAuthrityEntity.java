package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/6.
 */
@Entity
@Table(name = "USER_AUTHRITY", schema = "campus_travle", catalog = "")
public class UserAuthrityEntity {
    private long userId;
    private int authId;

    @Id
    @Column(name = "USER_ID", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "AUTH_ID", nullable = false)
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

        UserAuthrityEntity that = (UserAuthrityEntity) o;

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
