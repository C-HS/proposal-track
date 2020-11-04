package com.indic.proposal.service.repository;

import com.indic.proposal.service.model.Dumpsite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DumpSiteRepository extends JpaRepository<Dumpsite, Long> {
}
