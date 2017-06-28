package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/6/27.
 */
@Entity
@Table(name = "PACKAGE_SIZE", schema = "campus_travle", catalog = "")
public class PackageSizeEntity {
    private int packageSizeId;
    private String packageSizeDescription;

    @Id
    @Column(name = "PACKAGE_SIZE_ID", nullable = false)
    public int getPackageSizeId() {
        return packageSizeId;
    }

    public void setPackageSizeId(int packageSizeId) {
        this.packageSizeId = packageSizeId;
    }

    @Basic
    @Column(name = "PACKAGE_SIZE_DESCRIPTION", nullable = true, length = 255)
    public String getPackageSizeDescription() {
        return packageSizeDescription;
    }

    public void setPackageSizeDescription(String packageSizeDescription) {
        this.packageSizeDescription = packageSizeDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PackageSizeEntity that = (PackageSizeEntity) o;

        if (packageSizeId != that.packageSizeId) return false;
        if (packageSizeDescription != null ? !packageSizeDescription.equals(that.packageSizeDescription) : that.packageSizeDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = packageSizeId;
        result = 31 * result + (packageSizeDescription != null ? packageSizeDescription.hashCode() : 0);
        return result;
    }
}
