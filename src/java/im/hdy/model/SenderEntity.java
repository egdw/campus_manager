package im.hdy.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by hdy on 2017/6/27.
 */
@Entity
@Table(name = "SENDER", schema = "campus_travle", catalog = "")
public class SenderEntity {
    private long senderId;
    private String senderName;
    private String senderPhone;
    private String senderIdcard;
    private long senderLocation1;
    private long senderLocation2;
    private long senderLocation3;
    private String senderLocationDescription;
    private int senderPackageSize;
    private int senderPackageCompany;
    private String senderPackageDescription;
    private Timestamp senderCreateDate;
    private Integer senderIscomplete;
    private UserEntity userByUserId;

    @Id
    @Column(name = "SENDER_ID", nullable = false)
    public long getSenderId() {
        return senderId;
    }

    public void setSenderId(long senderId) {
        this.senderId = senderId;
    }

    @Basic
    @Column(name = "SENDER_NAME", nullable = false, length = 255)
    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    @Basic
    @Column(name = "SENDER_PHONE", nullable = false, length = 255)
    public String getSenderPhone() {
        return senderPhone;
    }

    public void setSenderPhone(String senderPhone) {
        this.senderPhone = senderPhone;
    }

    @Basic
    @Column(name = "SENDER_IDCARD", nullable = false, length = 255)
    public String getSenderIdcard() {
        return senderIdcard;
    }

    public void setSenderIdcard(String senderIdcard) {
        this.senderIdcard = senderIdcard;
    }

    @Basic
    @Column(name = "SENDER_LOCATION1", nullable = false)
    public long getSenderLocation1() {
        return senderLocation1;
    }

    public void setSenderLocation1(long senderLocation1) {
        this.senderLocation1 = senderLocation1;
    }

    @Basic
    @Column(name = "SENDER_LOCATION2", nullable = false)
    public long getSenderLocation2() {
        return senderLocation2;
    }

    public void setSenderLocation2(long senderLocation2) {
        this.senderLocation2 = senderLocation2;
    }

    @Basic
    @Column(name = "SENDER_LOCATION3", nullable = false)
    public long getSenderLocation3() {
        return senderLocation3;
    }

    public void setSenderLocation3(long senderLocation3) {
        this.senderLocation3 = senderLocation3;
    }

    @Basic
    @Column(name = "SENDER_LOCATION_DESCRIPTION", nullable = true, length = 255)
    public String getSenderLocationDescription() {
        return senderLocationDescription;
    }

    public void setSenderLocationDescription(String senderLocationDescription) {
        this.senderLocationDescription = senderLocationDescription;
    }

    @Basic
    @Column(name = "SENDER_PACKAGE_SIZE", nullable = false)
    public int getSenderPackageSize() {
        return senderPackageSize;
    }

    public void setSenderPackageSize(int senderPackageSize) {
        this.senderPackageSize = senderPackageSize;
    }

    @Basic
    @Column(name = "SENDER_PACKAGE_COMPANY", nullable = false)
    public int getSenderPackageCompany() {
        return senderPackageCompany;
    }

    public void setSenderPackageCompany(int senderPackageCompany) {
        this.senderPackageCompany = senderPackageCompany;
    }

    @Basic
    @Column(name = "SENDER_PACKAGE_DESCRIPTION", nullable = true, length = 255)
    public String getSenderPackageDescription() {
        return senderPackageDescription;
    }

    public void setSenderPackageDescription(String senderPackageDescription) {
        this.senderPackageDescription = senderPackageDescription;
    }

    @Basic
    @Column(name = "SENDER_CREATE_DATE", nullable = true)
    public Timestamp getSenderCreateDate() {
        return senderCreateDate;
    }

    public void setSenderCreateDate(Timestamp senderCreateDate) {
        this.senderCreateDate = senderCreateDate;
    }

    @Basic
    @Column(name = "SENDER_ISCOMPLETE", nullable = true)
    public Integer getSenderIscomplete() {
        return senderIscomplete;
    }

    public void setSenderIscomplete(Integer senderIscomplete) {
        this.senderIscomplete = senderIscomplete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SenderEntity that = (SenderEntity) o;

        if (senderId != that.senderId) return false;
        if (senderLocation1 != that.senderLocation1) return false;
        if (senderLocation2 != that.senderLocation2) return false;
        if (senderLocation3 != that.senderLocation3) return false;
        if (senderPackageSize != that.senderPackageSize) return false;
        if (senderPackageCompany != that.senderPackageCompany) return false;
        if (senderName != null ? !senderName.equals(that.senderName) : that.senderName != null) return false;
        if (senderPhone != null ? !senderPhone.equals(that.senderPhone) : that.senderPhone != null) return false;
        if (senderIdcard != null ? !senderIdcard.equals(that.senderIdcard) : that.senderIdcard != null) return false;
        if (senderLocationDescription != null ? !senderLocationDescription.equals(that.senderLocationDescription) : that.senderLocationDescription != null)
            return false;
        if (senderPackageDescription != null ? !senderPackageDescription.equals(that.senderPackageDescription) : that.senderPackageDescription != null)
            return false;
        if (senderCreateDate != null ? !senderCreateDate.equals(that.senderCreateDate) : that.senderCreateDate != null)
            return false;
        if (senderIscomplete != null ? !senderIscomplete.equals(that.senderIscomplete) : that.senderIscomplete != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (senderId ^ (senderId >>> 32));
        result = 31 * result + (senderName != null ? senderName.hashCode() : 0);
        result = 31 * result + (senderPhone != null ? senderPhone.hashCode() : 0);
        result = 31 * result + (senderIdcard != null ? senderIdcard.hashCode() : 0);
        result = 31 * result + (int) (senderLocation1 ^ (senderLocation1 >>> 32));
        result = 31 * result + (int) (senderLocation2 ^ (senderLocation2 >>> 32));
        result = 31 * result + (int) (senderLocation3 ^ (senderLocation3 >>> 32));
        result = 31 * result + (senderLocationDescription != null ? senderLocationDescription.hashCode() : 0);
        result = 31 * result + senderPackageSize;
        result = 31 * result + senderPackageCompany;
        result = 31 * result + (senderPackageDescription != null ? senderPackageDescription.hashCode() : 0);
        result = 31 * result + (senderCreateDate != null ? senderCreateDate.hashCode() : 0);
        result = 31 * result + (senderIscomplete != null ? senderIscomplete.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USERID", nullable = false)
    public UserEntity getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(UserEntity userByUserId) {
        this.userByUserId = userByUserId;
    }
}
