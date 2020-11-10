package com.indic.proposal.service.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indic.proposal.service.dto.ProposalDTO;
import com.indic.proposal.service.model.Component;
import com.indic.proposal.service.model.Proposal;
import com.indic.proposal.service.request.ComponentList;
import com.indic.proposal.service.request.ProjectList;
import com.indic.proposal.service.request.ProposalFilter;
import com.indic.proposal.service.request.ProposalStatus;
import com.indic.proposal.service.service.ComponentService;
import com.indic.proposal.service.service.ProjectService;
import com.indic.proposal.service.service.ProposalService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/proposal")
@RequiredArgsConstructor
public class ProposalController {
    private final ProposalService proposalService;
    private final ComponentService componentService;
    private final ProjectService projectService;

    //Logic for filtering the Proposal being fetched.
    @GetMapping
    public ResponseEntity<List<Proposal>> getAllProposal(){
        List<Proposal> proposal = proposalService.fetchAllProposal();
        return ResponseEntity.ok(proposal);
    }
    @PostMapping(value = "/addProposal", consumes = "application/json", produces = "application/json")
    public ResponseEntity<HttpStatus> addProposal(@RequestBody Proposal proposal){
    	proposal.setDateReceive(new Date());
        proposalService.addProposal(proposal);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @PostMapping(value = "/addComponents/{proposalId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<HttpStatus> addComponents(@PathVariable long proposalId, @RequestBody ComponentList componentList){
        Proposal prop = proposalService.fetchProposalById(proposalId);
        componentList.getComponentList().stream().forEach(prop::addComponent);
        proposalService.updateProposal(proposalId, prop);
        //Logic for checking for a proposal no component should come twice.
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @PostMapping(value = "/addProject/{componentId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<HttpStatus> addProjecct(@PathVariable long componentId, @RequestBody ProjectList projectList){
        Component comp = componentService.fetchComponentById(componentId);
        projectList.getProjectList()
                .stream()
                .forEach(project -> {
                        comp.addProject(project);
                        projectService.addProject(project);
                        }
                );
        // Logic for checking that only SWM should have these projects.
        // Logic for checking only Disposal should have the Subtypes [i.e. Dumpsite Remediation, Other, and Landfill].
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    
	@PutMapping("/setProposalStatus")
	public ResponseEntity<String> setProposalStatus(@RequestBody ProposalStatus proposalStatus) {

		String response ="error";
		try {
		response = proposalService.setProposalStatus(proposalStatus);
		}
		catch(Exception e)
		{
		 response ="error "+e.getMessage();
		}
		
		return ResponseEntity.ok(response);
	}
	
    @PostMapping(value = "/searchProposals", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Set<Proposal>> searhProposal(@RequestBody ProposalFilter proposalFilter) {
		Set<Proposal> proposalSet = new HashSet();
		try
		{
		
		System.out.println("component    "+proposalFilter.getComponentType());
		System.out.println("fromDate    "+proposalFilter.getFromDate());
		System.out.println("toDate    "+proposalFilter.getToDate());
		System.out.println("status    "+proposalFilter.getStatus());
		
		
		List<Long> ids=null;
		
		Date fromDate =null;
		
		Date toDate =null;
		
		String status =null;
		
		
		
					if(!"NA".equals(proposalFilter.getComponentType()))
					{
						proposalSet = componentService.filterByComponentType(proposalFilter.getComponentType());
						
					}
					else
					{
						List<Proposal> proposalList = proposalService.fetchAllProposal();
						
						proposalSet.addAll(proposalList);
					}
					if(!"NA".equals(proposalFilter.getFromDate()) && !"NA".equals(proposalFilter.getToDate()) && proposalSet.size()>0)
					{
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

						 fromDate =sdf.parse(proposalFilter.getFromDate()+" 00:00:00"); 
						 toDate =sdf.parse(proposalFilter.getToDate()+" 23:59:59"); 
						 
						 proposalSet = componentService.filterByBetweenDates(fromDate, toDate, proposalSet);
					}
					if(!"NA".equals(proposalFilter.getStatus()))
					{
						 proposalSet = componentService.filterByStatus(proposalFilter.getStatus(), proposalSet);
					}
					
					log.info("proposalSet  "+proposalSet);
		
		}
		catch(Exception e)
		{
			
		}

		return ResponseEntity.ok(proposalSet);
	}
}