package hcmute.team5.model;

import java.sql.Timestamp;

public class AbstractModel {
    private int id;
    private Timestamp createdDate;
    private Timestamp modifiedDate;
    private Timestamp createdBy;
    private Timestamp getModifiedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Timestamp modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Timestamp getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Timestamp createdBy) {
        this.createdBy = createdBy;
    }

    public Timestamp getGetModifiedBy() {
        return getModifiedBy;
    }

    public void setGetModifiedBy(Timestamp getModifiedBy) {
        this.getModifiedBy = getModifiedBy;
    }
}
