package com.vti.mock.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "company", schema = "recruitment_db", catalog = "")
public class CompanyEntity {
    private Long id;
    private int companyId;
    private String name;
    private String address;
    private String type;
    private Timestamp createdDate;
    private String createdBy;
    private Timestamp lastModifiedDate;
    private String lastModifiedBy;
    private int deleteFlag;
    private Collection<JobEntity> jobsByCompanyId;
    private Collection<ReviewEntity> reviewsByCompanyId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "company_id")
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "created_date")
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "created_by")
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Basic
    @Column(name = "last_modified_date")
    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Basic
    @Column(name = "last_modified_by")
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Basic
    @Column(name = "delete_flag")
    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyEntity that = (CompanyEntity) o;
        return companyId == that.companyId && deleteFlag == that.deleteFlag && Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(type, that.type) && Objects.equals(createdDate, that.createdDate) && Objects.equals(createdBy, that.createdBy) && Objects.equals(lastModifiedDate, that.lastModifiedDate) && Objects.equals(lastModifiedBy, that.lastModifiedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, name, address, type, createdDate, createdBy, lastModifiedDate, lastModifiedBy, deleteFlag);
    }

    @OneToMany(mappedBy = "companyByCompanyId")
    public Collection<JobEntity> getJobsByCompanyId() {
        return jobsByCompanyId;
    }

    public void setJobsByCompanyId(Collection<JobEntity> jobsByCompanyId) {
        this.jobsByCompanyId = jobsByCompanyId;
    }

    @OneToMany(mappedBy = "companyByCompanyId")
    public Collection<ReviewEntity> getReviewsByCompanyId() {
        return reviewsByCompanyId;
    }

    public void setReviewsByCompanyId(Collection<ReviewEntity> reviewsByCompanyId) {
        this.reviewsByCompanyId = reviewsByCompanyId;
    }
}
