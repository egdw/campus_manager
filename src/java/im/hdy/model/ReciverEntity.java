package im.hdy.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by hdy on 2017/6/27.
 */
@Entity
@Table(name = "RECIVER", schema = "campus_travle", catalog = "")
public class ReciverEntity {
    private long reciverId;
    private String postCode;
    private String postMessage;
    private Timestamp postCreatedate;
    private String postLocation;
    private PackageCompanyEntity packageCompanyByPostCompany;
    private PostHouseEntity postHouseByPostHouse;

    @Id
    @Column(name = "RECIVER_ID", nullable = false)
    public long getReciverId() {
        return reciverId;
    }

    public void setReciverId(long reciverId) {
        this.reciverId = reciverId;
    }

    @Basic
    @Column(name = "POST_CODE", nullable = false, length = 255)
    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    @Basic
    @Column(name = "POST_MESSAGE", nullable = true, length = 255)
    public String getPostMessage() {
        return postMessage;
    }

    public void setPostMessage(String postMessage) {
        this.postMessage = postMessage;
    }

    @Basic
    @Column(name = "POST_CREATEDATE", nullable = true)
    public Timestamp getPostCreatedate() {
        return postCreatedate;
    }

    public void setPostCreatedate(Timestamp postCreatedate) {
        this.postCreatedate = postCreatedate;
    }

    @Basic
    @Column(name = "POST_LOCATION", nullable = true, length = 255)
    public String getPostLocation() {
        return postLocation;
    }

    public void setPostLocation(String postLocation) {
        this.postLocation = postLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReciverEntity that = (ReciverEntity) o;

        if (reciverId != that.reciverId) return false;
        if (postCode != null ? !postCode.equals(that.postCode) : that.postCode != null) return false;
        if (postMessage != null ? !postMessage.equals(that.postMessage) : that.postMessage != null) return false;
        if (postCreatedate != null ? !postCreatedate.equals(that.postCreatedate) : that.postCreatedate != null)
            return false;
        if (postLocation != null ? !postLocation.equals(that.postLocation) : that.postLocation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (reciverId ^ (reciverId >>> 32));
        result = 31 * result + (postCode != null ? postCode.hashCode() : 0);
        result = 31 * result + (postMessage != null ? postMessage.hashCode() : 0);
        result = 31 * result + (postCreatedate != null ? postCreatedate.hashCode() : 0);
        result = 31 * result + (postLocation != null ? postLocation.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "POST_COMPANY", referencedColumnName = "PACKAGE_COMPANY_ID")
    public PackageCompanyEntity getPackageCompanyByPostCompany() {
        return packageCompanyByPostCompany;
    }

    public void setPackageCompanyByPostCompany(PackageCompanyEntity packageCompanyByPostCompany) {
        this.packageCompanyByPostCompany = packageCompanyByPostCompany;
    }

    @ManyToOne
    @JoinColumn(name = "POST_HOUSE", referencedColumnName = "POST_HOUSE_ID")
    public PostHouseEntity getPostHouseByPostHouse() {
        return postHouseByPostHouse;
    }

    public void setPostHouseByPostHouse(PostHouseEntity postHouseByPostHouse) {
        this.postHouseByPostHouse = postHouseByPostHouse;
    }
}
