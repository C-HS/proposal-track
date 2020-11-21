package com.indic.proposal.service.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.indic.proposal.service.model.Component;
import com.indic.proposal.service.model.Proposal;
import com.indic.proposal.service.repository.ComponentRepository;
import com.indic.proposal.service.service.ComponentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ComponentServiceImpl implements ComponentService {
	
private final ComponentRepository componentRepository;


@Override
public Component addComponent(Component component) {
    return componentRepository.save(component);
}

@Override
public List<Component> addComponentList(Iterable<Component> componentList) {
    return componentRepository.saveAll(componentList);
}

@Override
public Component fetchComponentById(long componentId) {
    return componentRepository.findById(componentId).get();
}

@Override
public List<Component> fetchAllComponent() {
    return componentRepository.findAll();
}

@Override
public String deleteComponentById(long componentId) {
	
	try
	{
      this.fetchComponentById(componentId).setProposal(null);
	  componentRepository.deleteById(componentId);
	  return "success";
	}
	catch(Exception e)
	{
		return "deletion_error";	
	}
}

@Override
public Component updateComponent(long componentId, Component component) {
	/*
	 * component.setComponentId(componentId);
	 * component.setProposal(this.fetchComponentById(componentId).getProposal());
	 * return componentRepository.save(component);
	 */
    
    try
	{
    	Component comp = this.fetchComponentById(componentId);
		if(comp!=null && comp.getComponentId()!=0)
		{
		    comp.setComponentTypeId(component.getComponentTypeId());
		    comp.setComponentType(component.getComponentType());
		    comp.setUnit(component.getUnit());
		    comp.setProjectCost(component.getProjectCost());
		    comp.setInstallment(component.getInstallment());
		    comp.setFirstInstallment(component.getFirstInstallment());
		    comp.setCentralShare(component.getCentralShare());
		    comp.setStateShare(component.getStateShare());
		    comp.setOtherShare(component.getOtherShare());
		    comp.setActionPlanDocument(component.getActionPlanDocument());
		    comp.setDateLastUpdate(component.getDateLastUpdate());
		
			componentRepository.save(comp);
		
		return comp;
		}
		else
		{
			return null;
		}
	}
	catch(Exception e)
	{
		System.out.println("#########################     "+e.getMessage());
		return null;	
	}
}

@Override
public Set<Proposal> filterByComponentType(String componentType) {
	
	 Set<Proposal> proposalList = new HashSet<>();
	
	 componentRepository
	 .findComponentByComponentType(componentType)
	 .stream().forEach(e->proposalList.add(e.getProposal()));
	 
	 return proposalList;
}

@Override
public Set<Proposal> filterByBetweenDates(Date fromDate, Date toDate, Set<Proposal> proposals) {
	
	 Set<Proposal> proposalList = new HashSet<>();
	
	 try
	 {
	 for(Proposal proposal: proposals)
	 {
		 
		 if(proposal.getDateOfSubmission().compareTo(fromDate)>=0 && proposal.getDateOfSubmission().compareTo(toDate)<= 0)
		 {
			 proposalList.add(proposal);
		 }
	 }
	 }
	 catch(Exception e)
	 {
		 
	 }
	 return proposalList;
}

@Override
public Set<Proposal> filterByStatus(String proposalStatus, Set<Proposal> proposals) {
	
	 Set<Proposal> proposalList = new HashSet<>();
	
	 for(Proposal proposal: proposals)
	 {
		 if(proposalStatus.equals(proposal.getProposalStatus()))
		 {
			 proposalList.add(proposal);
		 }
	 }

	 return proposalList;
}
 
}
