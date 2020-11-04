package com.indic.proposal.service.repository;

import com.indic.proposal.service.model.Subtype;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubTypeRepository extends JpaRepository<Subtype, Long> {
}
