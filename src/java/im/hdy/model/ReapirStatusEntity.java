package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/4.
 */
@Entity
@Table(name = "REAPIR_STATUS", schema = "campus_travle", catalog = "")
public class ReapirStatusEntity {
    private int repairStatusId;
    private String repairStatusName;

    @Id
    @Column(name = "REPAIR_STATUS_ID", nullable = false)
    public int getRepairStatusId() {
        return repairStatusId;
    }

    public void setRepairStatusId(int repairStatusId) {
        this.repairStatusId = repairStatusId;
    }

    @Basic
    @Column(name = "REPAIR_STATUS_NAME", nullable = true, length = 255)
    public String getRepairStatusName() {
        return repairStatusName;
    }

    public void setRepairStatusName(String repairStatusName) {
        this.repairStatusName = repairStatusName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ReapirStatusEntity that = (ReapirStatusEntity) o;

        if (repairStatusId != that.repairStatusId) return false;
        if (repairStatusName != null ? !repairStatusName.equals(that.repairStatusName) : that.repairStatusName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = repairStatusId;
        result = 31 * result + (repairStatusName != null ? repairStatusName.hashCode() : 0);
        return result;
    }
}
