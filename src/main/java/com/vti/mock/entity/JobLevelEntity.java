package com.vti.mock.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "job_level", schema = "recruitment_db", catalog = "")
public class JobLevelEntity {
    private Long id;
    private int jobLevelId;
    private String name;
    private int deleteFlag;
    private Timestamp createdDate;
    private String createdBy;
    private String lastModifiedBy;
    private Timestamp lastModifiedDate;
    private Collection<JobEntity> jobsByJobLevelId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "job_level_id")
    public int getJobLevelId() {
        return jobLevelId;
    }

    public void setJobLevelId(int jobLevelId) {
        this.jobLevelId = jobLevelId;
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
    @Column(name = "delete_flag")
    public int getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(int deleteFlag) {
        this.deleteFlag = deleteFlag;
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
    @Column(name = "last_modified_by")
    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    @Basic
    @Column(name = "last_modified_date")
    public Timestamp getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Timestamp lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JobLevelEntity that = (JobLevelEntity) o;
        return jobLevelId == that.jobLevelId && deleteFlag == that.deleteFlag && Objects.equals(name, that.name) && Objects.equals(createdDate, that.createdDate) && Objects.equals(createdBy, that.createdBy) && Objects.equals(lastModifiedBy, that.lastModifiedBy) && Objects.equals(lastModifiedDate, that.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobLevelId, name, deleteFlag, createdDate, createdBy, lastModifiedBy, lastModifiedDate);
    }

    @OneToMany(mappedBy = "jobLevelByJobLevelId")
    public Collection<JobEntity> getJobsByJobLevelId() {
        return jobsByJobLevelId;
    }

    public void setJobsByJobLevelId(Collection<JobEntity> jobsByJobLevelId) {
        this.jobsByJobLevelId = jobsByJobLevelId;
    }
}
