package com.vti.mock.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "job", schema = "recruitment_db", catalog = "")
public class JobEntity {
    private Long id;
    private int jobId;
    private int companyId;
    private int positionId;
    private String city;
    private String jobType;
    private String experience;
    private int skillId;
    private int salary;
    private int currency;
    private String requirement;
    private String description;
    private String otherBenefit;
    private Integer gender;
    private int quantity;
    private int jobLevelId;
    private Timestamp deadline;
    private Timestamp createdDate;
    private String createdBy;
    private Timestamp lastModifiedDate;
    private String lastModifiedBy;
    private int deleteFlag;
    private Collection<FavoriteJobEntity> favoriteJobsByJobId;
    private CompanyEntity companyByCompanyId;
    private PositionEntity positionByPositionId;
    private SkillEntity skillBySkillId;
    private JobLevelEntity jobLevelByJobLevelId;
    private Collection<UserAppliedJobEntity> userAppliedJobsByJobId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "job_id")
    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    @Basic
    @Column(name = "company_id")
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "position_id")
    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    @Basic
    @Column(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "job_type")
    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    @Basic
    @Column(name = "experience")
    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    @Basic
    @Column(name = "skill_id")
    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    @Basic
    @Column(name = "salary")
    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Basic
    @Column(name = "currency")
    public int getCurrency() {
        return currency;
    }

    public void setCurrency(int currency) {
        this.currency = currency;
    }

    @Basic
    @Column(name = "requirement")
    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "other_benefit")
    public String getOtherBenefit() {
        return otherBenefit;
    }

    public void setOtherBenefit(String otherBenefit) {
        this.otherBenefit = otherBenefit;
    }

    @Basic
    @Column(name = "gender")
    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "job_level_id")
    public int getJobLevelId() {
        return jobLevelId;
    }

    public void setJobLevelId(int jobLevelId) {
        this.jobLevelId = jobLevelId;
    }

    @Basic
    @Column(name = "deadline")
    public Timestamp getDeadline() {
        return deadline;
    }

    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
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
        JobEntity jobEntity = (JobEntity) o;
        return jobId == jobEntity.jobId && companyId == jobEntity.companyId && positionId == jobEntity.positionId && skillId == jobEntity.skillId && salary == jobEntity.salary && currency == jobEntity.currency && quantity == jobEntity.quantity && jobLevelId == jobEntity.jobLevelId && deleteFlag == jobEntity.deleteFlag && Objects.equals(city, jobEntity.city) && Objects.equals(jobType, jobEntity.jobType) && Objects.equals(experience, jobEntity.experience) && Objects.equals(requirement, jobEntity.requirement) && Objects.equals(description, jobEntity.description) && Objects.equals(otherBenefit, jobEntity.otherBenefit) && Objects.equals(gender, jobEntity.gender) && Objects.equals(deadline, jobEntity.deadline) && Objects.equals(createdDate, jobEntity.createdDate) && Objects.equals(createdBy, jobEntity.createdBy) && Objects.equals(lastModifiedDate, jobEntity.lastModifiedDate) && Objects.equals(lastModifiedBy, jobEntity.lastModifiedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobId, companyId, positionId, city, jobType, experience, skillId, salary, currency, requirement, description, otherBenefit, gender, quantity, jobLevelId, deadline, createdDate, createdBy, lastModifiedDate, lastModifiedBy, deleteFlag);
    }

    @OneToMany(mappedBy = "jobByJobId")
    public Collection<FavoriteJobEntity> getFavoriteJobsByJobId() {
        return favoriteJobsByJobId;
    }

    public void setFavoriteJobsByJobId(Collection<FavoriteJobEntity> favoriteJobsByJobId) {
        this.favoriteJobsByJobId = favoriteJobsByJobId;
    }

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "company_id", nullable = false)
    public CompanyEntity getCompanyByCompanyId() {
        return companyByCompanyId;
    }

    public void setCompanyByCompanyId(CompanyEntity companyByCompanyId) {
        this.companyByCompanyId = companyByCompanyId;
    }

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "position_id", nullable = false)
    public PositionEntity getPositionByPositionId() {
        return positionByPositionId;
    }

    public void setPositionByPositionId(PositionEntity positionByPositionId) {
        this.positionByPositionId = positionByPositionId;
    }

    @ManyToOne
    @JoinColumn(name = "skill_id", referencedColumnName = "skill_id", nullable = false)
    public SkillEntity getSkillBySkillId() {
        return skillBySkillId;
    }

    public void setSkillBySkillId(SkillEntity skillBySkillId) {
        this.skillBySkillId = skillBySkillId;
    }

    @ManyToOne
    @JoinColumn(name = "job_level_id", referencedColumnName = "job_level_id", nullable = false)
    public JobLevelEntity getJobLevelByJobLevelId() {
        return jobLevelByJobLevelId;
    }

    public void setJobLevelByJobLevelId(JobLevelEntity jobLevelByJobLevelId) {
        this.jobLevelByJobLevelId = jobLevelByJobLevelId;
    }

    @OneToMany(mappedBy = "jobByJobId")
    public Collection<UserAppliedJobEntity> getUserAppliedJobsByJobId() {
        return userAppliedJobsByJobId;
    }

    public void setUserAppliedJobsByJobId(Collection<UserAppliedJobEntity> userAppliedJobsByJobId) {
        this.userAppliedJobsByJobId = userAppliedJobsByJobId;
    }
}
