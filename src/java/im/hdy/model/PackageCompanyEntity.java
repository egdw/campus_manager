package im.hdy.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by hdy on 2017/6/27.
 */
@Entity
@Table(name = "PACKAGE_COMPANY", schema = "campus_travle")
public class PackageCompanyEntity {
    private int packageCompanyId;
    private String packageCompanyName;

    @Id
    @Column(name = "PACKAGE_COMPANY_ID", nullable = false)
    public int getPackageCompanyId() {
        return packageCompanyId;
    }

    public void setPackageCompanyId(int packageCompanyId) {
        this.packageCompanyId = packageCompanyId;
    }

    @Basic
    @Column(name = "PACKAGE_COMPANY_NAME", nullable = true, length = 255)
    public String getPackageCompanyName() {
        return packageCompanyName;
    }

    public void setPackageCompanyName(String packageCompanyName) {
        this.packageCompanyName = packageCompanyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackageCompanyEntity that = (PackageCompanyEntity) o;

        if (packageCompanyId != that.packageCompanyId) return false;
        if (packageCompanyName != null ? !packageCompanyName.equals(that.packageCompanyName) : that.packageCompanyName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = packageCompanyId;
        result = 31 * result + (packageCompanyName != null ? packageCompanyName.hashCode() : 0);
        return result;
    }

}
