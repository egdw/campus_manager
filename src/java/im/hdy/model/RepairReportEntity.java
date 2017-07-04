package im.hdy.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by hdy on 2017/7/4.
 */
@Entity
@Table(name = "REPAIR_REPORT", schema = "campus_travle", catalog = "")
public class RepairReportEntity {
    private long repairid;
    private Integer studentCampusId;
    private Long studentCampusArea;
    private Integer bigMaintainId;
    private Integer smallMaintainId;
    private String repairPhone;
    private String repairDetailLocation;
    private String repairDetailDescrption;
    private String repairDetailPic;
    private Long repairUserId;
    private Long repairWorkerId;
    private Timestamp repairCreatedata;
    private Integer repairStatus;

    @Id
    @Column(name = "REPAIRID", nullable = false)
    public long getRepairid() {
        return repairid;
    }

    public void setRepairid(long repairid) {
        this.repairid = repairid;
    }

    @Basic
    @Column(name = "STUDENT_CAMPUS_ID", nullable = true)
    public Integer getStudentCampusId() {
        return studentCampusId;
    }

    public void setStudentCampusId(Integer studentCampusId) {
        this.studentCampusId = studentCampusId;
    }

    @Basic
    @Column(name = "STUDENT_CAMPUS_AREA", nullable = true)
    public Long getStudentCampusArea() {
        return studentCampusArea;
    }

    public void setStudentCampusArea(Long studentCampusArea) {
        this.studentCampusArea = studentCampusArea;
    }

    @Basic
    @Column(name = "BIG_MAINTAIN_ID", nullable = true)
    public Integer getBigMaintainId() {
        return bigMaintainId;
    }

    public void setBigMaintainId(Integer bigMaintainId) {
        this.bigMaintainId = bigMaintainId;
    }

    @Basic
    @Column(name = "SMALL_MAINTAIN_ID", nullable = true)
    public Integer getSmallMaintainId() {
        return smallMaintainId;
    }

    public void setSmallMaintainId(Integer smallMaintainId) {
        this.smallMaintainId = smallMaintainId;
    }

    @Basic
    @Column(name = "REPAIR_PHONE", nullable = true, length = 255)
    public String getRepairPhone() {
        return repairPhone;
    }

    public void setRepairPhone(String repairPhone) {
        this.repairPhone = repairPhone;
    }

    @Basic
    @Column(name = "REPAIR_DETAIL_LOCATION", nullable = true, length = 255)
    public String getRepairDetailLocation() {
        return repairDetailLocation;
    }

    public void setRepairDetailLocation(String repairDetailLocation) {
        this.repairDetailLocation = repairDetailLocation;
    }

    @Basic
    @Column(name = "REPAIR_DETAIL_DESCRPTION", nullable = true, length = 255)
    public String getRepairDetailDescrption() {
        return repairDetailDescrption;
    }

    public void setRepairDetailDescrption(String repairDetailDescrption) {
        this.repairDetailDescrption = repairDetailDescrption;
    }

    @Basic
    @Column(name = "REPAIR_DETAIL_PIC", nullable = true, length = 255)
    public String getRepairDetailPic() {
        return repairDetailPic;
    }

    public void setRepairDetailPic(String repairDetailPic) {
        this.repairDetailPic = repairDetailPic;
    }

    @Basic
    @Column(name = "REPAIR_USER_ID", nullable = true)
    public Long getRepairUserId() {
        return repairUserId;
    }

    public void setRepairUserId(Long repairUserId) {
        this.repairUserId = repairUserId;
    }

    @Basic
    @Column(name = "REPAIR_WORKER_ID", nullable = true)
    public Long getRepairWorkerId() {
        return repairWorkerId;
    }

    public void setRepairWorkerId(Long repairWorkerId) {
        this.repairWorkerId = repairWorkerId;
    }

    @Basic
    @Column(name = "REPAIR_CREATEDATA", nullable = true)
    public Timestamp getRepairCreatedata() {
        return repairCreatedata;
    }

    public void setRepairCreatedata(Timestamp repairCreatedata) {
        this.repairCreatedata = repairCreatedata;
    }

    @Basic
    @Column(name = "REPAIR_STATUS", nullable = true)
    public Integer getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(Integer repairStatus) {
        this.repairStatus = repairStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RepairReportEntity that = (RepairReportEntity) o;

        if (repairid != that.repairid) return false;
        if (studentCampusId != null ? !studentCampusId.equals(that.studentCampusId) : that.studentCampusId != null)
            return false;
        if (studentCampusArea != null ? !studentCampusArea.equals(that.studentCampusArea) : that.studentCampusArea != null)
            return false;
        if (bigMaintainId != null ? !bigMaintainId.equals(that.bigMaintainId) : that.bigMaintainId != null)
            return false;
        if (smallMaintainId != null ? !smallMaintainId.equals(that.smallMaintainId) : that.smallMaintainId != null)
            return false;
        if (repairPhone != null ? !repairPhone.equals(that.repairPhone) : that.repairPhone != null) return false;
        if (repairDetailLocation != null ? !repairDetailLocation.equals(that.repairDetailLocation) : that.repairDetailLocation != null)
            return false;
        if (repairDetailDescrption != null ? !repairDetailDescrption.equals(that.repairDetailDescrption) : that.repairDetailDescrption != null)
            return false;
        if (repairDetailPic != null ? !repairDetailPic.equals(that.repairDetailPic) : that.repairDetailPic != null)
            return false;
        if (repairUserId != null ? !repairUserId.equals(that.repairUserId) : that.repairUserId != null) return false;
        if (repairWorkerId != null ? !repairWorkerId.equals(that.repairWorkerId) : that.repairWorkerId != null)
            return false;
        if (repairCreatedata != null ? !repairCreatedata.equals(that.repairCreatedata) : that.repairCreatedata != null)
            return false;
        if (repairStatus != null ? !repairStatus.equals(that.repairStatus) : that.repairStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (repairid ^ (repairid >>> 32));
        result = 31 * result + (studentCampusId != null ? studentCampusId.hashCode() : 0);
        result = 31 * result + (studentCampusArea != null ? studentCampusArea.hashCode() : 0);
        result = 31 * result + (bigMaintainId != null ? bigMaintainId.hashCode() : 0);
        result = 31 * result + (smallMaintainId != null ? smallMaintainId.hashCode() : 0);
        result = 31 * result + (repairPhone != null ? repairPhone.hashCode() : 0);
        result = 31 * result + (repairDetailLocation != null ? repairDetailLocation.hashCode() : 0);
        result = 31 * result + (repairDetailDescrption != null ? repairDetailDescrption.hashCode() : 0);
        result = 31 * result + (repairDetailPic != null ? repairDetailPic.hashCode() : 0);
        result = 31 * result + (repairUserId != null ? repairUserId.hashCode() : 0);
        result = 31 * result + (repairWorkerId != null ? repairWorkerId.hashCode() : 0);
        result = 31 * result + (repairCreatedata != null ? repairCreatedata.hashCode() : 0);
        result = 31 * result + (repairStatus != null ? repairStatus.hashCode() : 0);
        return result;
    }
}
