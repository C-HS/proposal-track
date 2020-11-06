package com.indic.proposal.service.repository;

import com.indic.proposal.service.model.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComponentRepository extends JpaRepository<Component, Long> {
//    public List<Component> findComponentByComponentType(String componentType);
}
