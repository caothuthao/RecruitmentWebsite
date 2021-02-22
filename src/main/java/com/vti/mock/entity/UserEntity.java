package com.vti.mock.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "recruitment_db", catalog = "")
public class UserEntity {
    private Long id;
    private int userId;
    private String username;
    private Integer companyId;
    private String password;
    private String fullName;
    private String phone;
    private String cvFileName;
    private String cvFilePath;
    private String email;
    private String aboutMe;
    private String expertise;
    private String address;
    private Timestamp createdDate;
    private String createdBy;
    private Timestamp lastModifiedDate;
    private String lastModifiedBy;
    private int deleteFlag;
    private Collection<FavoriteJobEntity> favoriteJobsByUserId;
    private Collection<ReviewEntity> reviewsByUserId;
    private Collection<UserAppliedJobEntity> userAppliedJobsByUserId;
    private Collection<UserRoleEntity> userRolesByUserId;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "company_id")
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "cv_file_name")
    public String getCvFileName() {
        return cvFileName;
    }

    public void setCvFileName(String cvFileName) {
        this.cvFileName = cvFileName;
    }

    @Basic
    @Column(name = "cv_file_path")
    public String getCvFilePath() {
        return cvFilePath;
    }

    public void setCvFilePath(String cvFilePath) {
        this.cvFilePath = cvFilePath;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "about_me")
    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    @Basic
    @Column(name = "expertise")
    public String getExpertise() {
        return expertise;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
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
        UserEntity that = (UserEntity) o;
        return userId == that.userId && deleteFlag == that.deleteFlag && Objects.equals(username, that.username) && Objects.equals(companyId, that.companyId) && Objects.equals(password, that.password) && Objects.equals(fullName, that.fullName) && Objects.equals(phone, that.phone) && Objects.equals(cvFileName, that.cvFileName) && Objects.equals(cvFilePath, that.cvFilePath) && Objects.equals(email, that.email) && Objects.equals(aboutMe, that.aboutMe) && Objects.equals(expertise, that.expertise) && Objects.equals(address, that.address) && Objects.equals(createdDate, that.createdDate) && Objects.equals(createdBy, that.createdBy) && Objects.equals(lastModifiedDate, that.lastModifiedDate) && Objects.equals(lastModifiedBy, that.lastModifiedBy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, username, companyId, password, fullName, phone, cvFileName, cvFilePath, email, aboutMe, expertise, address, createdDate, createdBy, lastModifiedDate, lastModifiedBy, deleteFlag);
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<FavoriteJobEntity> getFavoriteJobsByUserId() {
        return favoriteJobsByUserId;
    }

    public void setFavoriteJobsByUserId(Collection<FavoriteJobEntity> favoriteJobsByUserId) {
        this.favoriteJobsByUserId = favoriteJobsByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<ReviewEntity> getReviewsByUserId() {
        return reviewsByUserId;
    }

    public void setReviewsByUserId(Collection<ReviewEntity> reviewsByUserId) {
        this.reviewsByUserId = reviewsByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<UserAppliedJobEntity> getUserAppliedJobsByUserId() {
        return userAppliedJobsByUserId;
    }

    public void setUserAppliedJobsByUserId(Collection<UserAppliedJobEntity> userAppliedJobsByUserId) {
        this.userAppliedJobsByUserId = userAppliedJobsByUserId;
    }

    @OneToMany(mappedBy = "userByUserId")
    public Collection<UserRoleEntity> getUserRolesByUserId() {
        return userRolesByUserId;
    }

    public void setUserRolesByUserId(Collection<UserRoleEntity> userRolesByUserId) {
        this.userRolesByUserId = userRolesByUserId;
    }
}
