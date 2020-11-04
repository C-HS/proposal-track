package com.indic.proposal.service.repository;

import com.indic.proposal.service.model.LandfillInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandfillInfoRepository extends JpaRepository<LandfillInfo, Long> {
}
