package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/5.
 */
@Entity
@Table(name = "AUTHORITY", schema = "campus_travle", catalog = "")
public class AuthorityEntity {
    private int authId;
    private String authName;

    @Id
    @Column(name = "AUTH_ID", nullable = false)
    public int getAuthId() {
        return authId;
    }

    public void setAuthId(int authId) {
        this.authId = authId;
    }

    @Basic
    @Column(name = "AUTH_NAME", nullable = true, length = 255)
    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorityEntity that = (AuthorityEntity) o;

        if (authId != that.authId) return false;
        if (authName != null ? !authName.equals(that.authName) : that.authName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = authId;
        result = 31 * result + (authName != null ? authName.hashCode() : 0);
        return result;
    }
}
