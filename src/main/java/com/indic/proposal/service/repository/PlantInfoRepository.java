package com.indic.proposal.service.repository;

import com.indic.proposal.service.model.PlantInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantInfoRepository extends JpaRepository<PlantInfo, Long> {
}
