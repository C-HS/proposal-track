package com.indic.proposal.service.controller;

import java.text.SimpleDateFormat;
import java.util.*;

import com.indic.proposal.service.model.Project;
import com.indic.proposal.service.response.ProposalResponse;
import com.indic.proposal.service.response.StatusResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/listProposal", produces="application/json")
	public ResponseEntity<ProposalResponse> listProposal(){
    	ProposalResponse proposalResponse = new ProposalResponse();
    	List<Proposal> listProposal = proposalService.fetchAllProposal();
    	proposalResponse.setCount((long) listProposal.size());
    	proposalResponse.setData(listProposal);
    	return ResponseEntity.ok(proposalResponse);
	}
	@GetMapping(value= "/listComponent",  produces = "application/json")
	public ResponseEntity<List<Component>> listComponent(){
    	return ResponseEntity.ok(componentService.fetchAllComponent());
	}
	@GetMapping(value = "/listProject",  produces= "application/json")
	public ResponseEntity<List<Project>> listProjects(){
    	return ResponseEntity.ok(projectService.fetchAllProject());
	}
    @PostMapping(value = "/addProposal", consumes = "application/json", produces = "application/json")
    public ResponseEntity<StatusResponse> addProposal(@RequestBody Proposal proposal){
    	proposal.setDateOfSubmission(new Date());
    	proposal.setDateLastUpdate(new Date());
    	proposal.setAmountApprove("0.0");
    	proposal.setProposalStatus("SUBMITTED");
       // return ResponseEntity.ok(proposalService.addProposal(proposal));
    	
    	String str = proposalService.addProposal(proposal);
    	StatusResponse resp = new StatusResponse();
         if("success".equals(str))
         {
        	resp.setMessage("CREATED");
         	resp.setStatus("SUCCESS");
         }
         else
         {
            resp.setMessage(str);
          	resp.setStatus("FAIL");
         }
    	 return ResponseEntity.ok(resp);
    }
    
    @GetMapping(value = "/getProposal/{id}")
	public ResponseEntity<Proposal> getProposal(@PathVariable Long id){
    	
    	Proposal p = null;
    	try
    	{
    		p =proposalService.fetchProposalById(id);
    	}
    	catch(Exception e)
    	{
    		System.out.println("Exception  "+e.getMessage());
    	}
    
         return ResponseEntity.ok(p);
	}
    
    @PutMapping(value = "/updateProposal/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Proposal> updateProposal(@PathVariable Long id, @RequestBody Proposal proposal){
    	proposal.setDateLastUpdate(new Date());
         return ResponseEntity.ok(proposalService.updateProposal(id, proposal));
    	
        //return ResponseEntity.ok(proposalService.updateProposal(proposalId, proposal));
    }
    @DeleteMapping(value = "/deleteProposal/{id}")
	public ResponseEntity<StatusResponse> deleteProposal(@PathVariable Long id){
    	
    	String str = proposalService.deleteProposalById(id);
    	StatusResponse resp = new StatusResponse();
         if("success".equals(str))
         {
        	resp.setMessage("DELETED");
         	resp.setStatus("SUCCESS");
         }
         else
         {
            resp.setMessage(str);
          	resp.setStatus("FAIL");
         }
         return ResponseEntity.ok(resp);
    	
    	//proposalService.deleteProposalById(proposalId);
    	//return ResponseEntity.ok("Proposal Deleted : " + proposalId);
	}
	@PostMapping(value = "/addComponents/{proposalId}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Component> addComponents(@PathVariable long proposalId, @RequestBody Component component){
		
		component.setDateCreated(new Date());
		component.setDateLastUpdate(new Date());
		
		Proposal prop = proposalService.fetchProposalById(proposalId);
		prop.addComponent(component);
		componentService.addComponent(component);
//		proposalService.updateProposal(proposalId, prop);
		return ResponseEntity.ok(component);
	}
	@PostMapping(value = "/addProject/{componentId}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Project> addProjecct(@PathVariable long componentId, @RequestBody Project project){
		Component comp = componentService.fetchComponentById(componentId);
		project.setDateCreated(new Date());
		project.setDateLastUpdate(new Date());
		comp.addProject(project);
		return ResponseEntity.ok(projectService.addProject(project));
	}
	@DeleteMapping(value = "/deleteComponent/{componentId}")
	public ResponseEntity<StatusResponse> deleteComponent(@PathVariable Long componentId){
		
    	String str = componentService.deleteComponentById(componentId);
    	StatusResponse resp = new StatusResponse();
         if("success".equals(str))
         {
        	resp.setMessage("DELETED");
         	resp.setStatus("SUCCESS");
         }
         else
         {
            resp.setMessage(str);
          	resp.setStatus("FAIL");
         }
         return ResponseEntity.ok(resp);
		
			/*
			 * componentService.deleteComponentById(componentId); return
			 * ResponseEntity.ok("Deleted Component : " + componentId);
			 */
	}
	@PutMapping(value = "/updateComponent/{componentId}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Component> updateComponent(@PathVariable Long componentId, @RequestBody Component component){
		component.setDateLastUpdate(new Date());
    	return ResponseEntity.ok(componentService.updateComponent(componentId, component));
	}
	
    @GetMapping(value = "/getComponentList/{id}")
	public ResponseEntity<Set<Component>> getComponentList(@PathVariable Long id){
    	
    	Proposal p =null;

    	try
    	{
    		p =proposalService.fetchProposalById(id);
    	}
    	catch(Exception e)
    	{
    		System.out.println("Exception  "+e.getMessage());
    	}
    	
    	if(p!=null && p.getId()!=0)
    	{
    		return ResponseEntity.ok(p.getComponentList());
    	}
    	else
    	{
    		return ResponseEntity.ok(new HashSet<>());
    	}
    
         
	}
	
	@DeleteMapping(value = "/deleteProject/{projectId}")
	public ResponseEntity<StatusResponse> deleteProject(@PathVariable Long projectId){
		/*
		 * projectService.deleteProjectById(projectId); return
		 * ResponseEntity.ok("Deleted Project : " + projectId);
		 */
    	
    	String str = projectService.deleteProjectById(projectId);
    	StatusResponse resp = new StatusResponse();
         if("success".equals(str))
         {
        	resp.setMessage("DELETED");
         	resp.setStatus("SUCCESS");
         }
         else
         {
            resp.setMessage(str);
          	resp.setStatus("FAIL");
         }
         return ResponseEntity.ok(resp);
	}
	@PutMapping(value = "/updateProject/{projectId}", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Project> updateProject(@PathVariable Long projectId, @RequestBody Project project){
		project.setDateLastUpdate(new Date());
    	return ResponseEntity.ok(projectService.updateProject(projectId, project));
	}
	@PutMapping("/setProposalStatus")
	public ResponseEntity<String> setProposalStatus(@RequestBody ProposalStatus proposalStatus) {
		String response ="error";
		try {
		response = proposalService.setProposalStatus(proposalStatus);
		}catch(Exception e){
		 response ="error "+e.getMessage();
		}
		return ResponseEntity.ok(response);
	}
    @PostMapping(value = "/searchProposals", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Set<Proposal>> searhProposal(@RequestBody ProposalFilter proposalFilter) {
		Set<Proposal> proposalSet = new HashSet();
		try{
			List<Long> ids=null;
			Date fromDate =null;
			Date toDate =null;
			String status =null;
				if(!"NA".equals(proposalFilter.getComponentType())){
					proposalSet = componentService.filterByComponentType(proposalFilter.getComponentType());
				}else{
					List<Proposal> proposalList = proposalService.fetchAllProposal();
					proposalSet.addAll(proposalList);
				}
				if(!"NA".equals(proposalFilter.getFromDate()) && !"NA".equals(proposalFilter.getToDate()) && proposalSet.size()>0){
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					 fromDate =sdf.parse(proposalFilter.getFromDate()+" 00:00:00");
					 toDate =sdf.parse(proposalFilter.getToDate()+" 23:59:59");
					 proposalSet = componentService.filterByBetweenDates(fromDate, toDate, proposalSet);
				}
				if(!"NA".equals(proposalFilter.getStatus())){
					 proposalSet = componentService.filterByStatus(proposalFilter.getStatus(), proposalSet);
				}
				log.info("proposalSet  "+proposalSet);
		}catch(Exception e){}
		return ResponseEntity.ok(proposalSet);
	}
}