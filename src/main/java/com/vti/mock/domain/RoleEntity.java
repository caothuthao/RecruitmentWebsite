package com.vti.mock.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.vti.mock.constants.RoleConstants;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "role", schema = "public")
public class RoleEntity extends AbstractAuditingEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3436061723015515020L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer roleId;

	@Basic
	@Column(name = "role_name")
	private String roleName;

	@Column(name = "role_code", length = 45)
	@Enumerated(EnumType.STRING)
	private RoleConstants roleConstants;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
	private Set<CandidateRoleEntity> listCandidateRole = new HashSet<>(0);

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public RoleConstants getRoleConstants() {
		return roleConstants;
	}

	public void setRoleConstants(RoleConstants roleConstants) {
		this.roleConstants = roleConstants;
	}

	public Set<CandidateRoleEntity> getListCandidateRole() {
		return listCandidateRole;
	}

	public void setListCandidateRole(Set<CandidateRoleEntity> listCandidateRole) {
		this.listCandidateRole = listCandidateRole;
	}

}
