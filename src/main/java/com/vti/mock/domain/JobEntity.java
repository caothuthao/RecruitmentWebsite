package com.vti.mock.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.vti.mock.constants.JobTypeConstants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "job", schema = "public")
public class JobEntity extends AbstractAuditingEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7527384453785372162L;

	@Id
	@Column(name = "job_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer jobId;

	@Basic
	@Column(name = "job_title")
	private String jobTitle;

	@Basic
	@Column(name = "location")
	private String location;

	@Basic
	@Column(name = "job_type", length = 45)
	@Enumerated(EnumType.STRING)
	private JobTypeConstants jobType;

	@Basic
	@Column(name = "experience")
	private String experience;

	@Basic
	@Column(name = "salary")
	private String salary;

	@Basic
	@Column(name = "qualification")
	private String qualification;

	@Basic
	@Column(name = "gender")
	private String gender;

	@Basic
	@Column(name = "description")
	private String description;

	@Basic
	@Column(name = "responsibility")
	private String responsibility;

	@ManyToOne
	@JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
	private CategoryEntity category;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "candidate_job", joinColumns = @JoinColumn(name = "job_id"), inverseJoinColumns = @JoinColumn(name = "candidate_id"))
	private Set<CandidateEntity> listCandidate = new HashSet<>(0);

	public Integer getJobId() {
		return jobId;
	}

	public void setJobId(Integer jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public JobTypeConstants getJobType() {
		return jobType;
	}

	public void setJobType(JobTypeConstants jobType) {
		this.jobType = jobType;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResponsibility() {
		return responsibility;
	}

	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public Set<CandidateEntity> getListCandidate() {
		return listCandidate;
	}

	public void setListCandidate(Set<CandidateEntity> listCandidate) {
		this.listCandidate = listCandidate;
	}

}
