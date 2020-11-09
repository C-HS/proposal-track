package com.indic.proposal.service.controller;

import com.indic.proposal.service.model.Component;
import com.indic.proposal.service.model.Proposal;
import com.indic.proposal.service.request.ComponentList;
import com.indic.proposal.service.request.ProjectList;
import com.indic.proposal.service.service.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/proposal")
@RequiredArgsConstructor
public class ProposalController {
    private final ProposalService proposalService;
    private final ComponentService componentService;
    private final ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Proposal>> getAllProposal(){
        List<Proposal> proposal = proposalService.fetchAllProposal();
        return ResponseEntity.ok(proposal);
    }
    @PostMapping(value = "/addProposal", consumes = "application/json", produces = "application/json")
    public ResponseEntity<HttpStatus> addProposal(@RequestBody Proposal proposal){
        proposalService.addProposal(proposal);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
    @PostMapping(value = "/addComponents/{proposalId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<HttpStatus> addComponents(@PathVariable long proposalId, @RequestBody ComponentList componentList){
        Proposal prop = proposalService.fetchProposalById(proposalId);
        componentList.getComponentList().stream().forEach(prop::addComponent);
        proposalService.updateProposal(proposalId, prop);
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
        return ResponseEntity.ok(HttpStatus.CREATED);
    }
}