package com.vti.mock.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "candidate", schema = "public")
public class CandidateEntity extends AbstractAuditingEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7316691084649968609L;

	@Id
	@Column(name = "candidate_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer candidateId;

	@Basic
	@Column(name = "candidate_name")
	private String candidateName;

	@Basic
	@Column(name = "address")
	private String address;

	@Basic
	@Column(name = "age")
	private Integer age;

	@Basic
	@Column(name = "experience")
	private String experience;

	@Basic
	@Column(name = "job_type")
	private String jobType;

	@Basic
	@Column(name = "qualification")
	private String qualification;

	@Basic
	@Column(name = "gender")
	private String gender;

	@Basic
	@Column(name = "skills")
	private String skills;

	@Basic
	@Column(name = "about_candidate")
	private String aboutCandidate;

	@Basic
	@Column(name = "user_name")
	private String username;

	@Basic
	@Column(name = "password")
	private String password;

	@Basic
	@Column(name = "enable")
	private boolean enable;

	@Basic
	@Column(name = "iscandidate")
	private boolean isCandidate;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "candidate")
	private Set<CandidateRoleEntity> listCandidateRole = new HashSet<>(0);

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "candidate_job", joinColumns = @JoinColumn(name = "candidate_id"), inverseJoinColumns = @JoinColumn(name = "job_id"))
	private Set<JobEntity> listJob = new HashSet<>(0);

	@Transient
	public List<GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (CandidateRoleEntity roles : listCandidateRole) {
			authorities.add(new SimpleGrantedAuthority(roles.getRole().getRoleConstants().toString()));
		}
		return authorities;
	}

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
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

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getAboutCandidate() {
		return aboutCandidate;
	}

	public void setAboutCandidate(String aboutCandidate) {
		this.aboutCandidate = aboutCandidate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public boolean isCandidate() {
		return isCandidate;
	}

	public void setCandidate(boolean isCandidate) {
		this.isCandidate = isCandidate;
	}

	public Set<CandidateRoleEntity> getListCandidateRole() {
		return listCandidateRole;
	}

	public void setListCandidateRole(Set<CandidateRoleEntity> listCandidateRole) {
		this.listCandidateRole = listCandidateRole;
	}

	public Set<JobEntity> getListJob() {
		return listJob;
	}

	public void setListJob(Set<JobEntity> listJob) {
		this.listJob = listJob;
	}

}
