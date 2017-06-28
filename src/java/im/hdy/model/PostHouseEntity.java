package im.hdy.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by hdy on 2017/6/27.
 */
@Entity
@Table(name = "POST_HOUSE", schema = "campus_travle", catalog = "")
public class PostHouseEntity {
    private int postHouseId;
    private String postHouseName;
    private String postHouseContact;
    private String postHouseLocation;
    private Collection<ReciverEntity> reciversByPostHouseId;

    @Id
    @Column(name = "POST_HOUSE_ID", nullable = false)
    public int getPostHouseId() {
        return postHouseId;
    }

    public void setPostHouseId(int postHouseId) {
        this.postHouseId = postHouseId;
    }

    @Basic
    @Column(name = "POST_HOUSE_NAME", nullable = true, length = 255)
    public String getPostHouseName() {
        return postHouseName;
    }

    public void setPostHouseName(String postHouseName) {
        this.postHouseName = postHouseName;
    }

    @Basic
    @Column(name = "POST_HOUSE_CONTACT", nullable = true, length = 255)
    public String getPostHouseContact() {
        return postHouseContact;
    }

    public void setPostHouseContact(String postHouseContact) {
        this.postHouseContact = postHouseContact;
    }

    @Basic
    @Column(name = "POST_HOUSE_LOCATION", nullable = true, length = 255)
    public String getPostHouseLocation() {
        return postHouseLocation;
    }

    public void setPostHouseLocation(String postHouseLocation) {
        this.postHouseLocation = postHouseLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PostHouseEntity that = (PostHouseEntity) o;

        if (postHouseId != that.postHouseId) return false;
        if (postHouseName != null ? !postHouseName.equals(that.postHouseName) : that.postHouseName != null)
            return false;
        if (postHouseContact != null ? !postHouseContact.equals(that.postHouseContact) : that.postHouseContact != null)
            return false;
        if (postHouseLocation != null ? !postHouseLocation.equals(that.postHouseLocation) : that.postHouseLocation != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = postHouseId;
        result = 31 * result + (postHouseName != null ? postHouseName.hashCode() : 0);
        result = 31 * result + (postHouseContact != null ? postHouseContact.hashCode() : 0);
        result = 31 * result + (postHouseLocation != null ? postHouseLocation.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "postHouseByPostHouse")
    public Collection<ReciverEntity> getReciversByPostHouseId() {
        return reciversByPostHouseId;
    }

    public void setReciversByPostHouseId(Collection<ReciverEntity> reciversByPostHouseId) {
        this.reciversByPostHouseId = reciversByPostHouseId;
    }
}
