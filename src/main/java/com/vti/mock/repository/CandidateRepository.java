package com.vti.mock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vti.mock.domain.CandidateEntity;

import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<CandidateEntity, Integer> {

	Optional<CandidateEntity> findByUsername(String username);

}
