package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/5.
 */
@Entity
@Table(name = "USER_AUTHRITY", schema = "campus_travle", catalog = "")
@IdClass(UserAuthrityEntityPK.class)
public class UserAuthrityEntity {
    private long userId;
    private int authId;
    private AuthorityEntity authorityByAuthId;

    @Id
    @Column(name = "USER_ID", nullable = false)
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    @Id
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

    @ManyToOne
    @JoinColumn(name = "AUTH_ID", referencedColumnName = "AUTH_ID", nullable = false)
    public AuthorityEntity getAuthorityByAuthId() {
        return authorityByAuthId;
    }

    public void setAuthorityByAuthId(AuthorityEntity authorityByAuthId) {
        this.authorityByAuthId = authorityByAuthId;
    }
}
