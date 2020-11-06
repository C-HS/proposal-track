package com.indic.proposal.service.controller;

import com.indic.proposal.service.dto.ComponentDTO;
import com.indic.proposal.service.dto.ProposalDTO;
import com.indic.proposal.service.model.Component;
import com.indic.proposal.service.model.Proposal;
import com.indic.proposal.service.request.ComponentList;
import com.indic.proposal.service.service.ProposalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.config.Configuration;
import org.modelmapper.convention.NamingConventions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequestMapping("/api/proposal")
@RequiredArgsConstructor
public class ProposalController {
    private final ProposalService proposalService;
    private final ModelMapper modelMapper;
    @GetMapping
    public ResponseEntity<List<Proposal>> getAllProposal(){
        modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(Configuration.AccessLevel.PRIVATE)
                .setSourceNamingConvention(NamingConventions.JAVABEANS_MUTATOR);
        List<Proposal> proposal = proposalService.fetchAllProposal();
        List<ProposalDTO> propDTO = proposal
                .stream()
                .map(e ->modelMapper.map(e,ProposalDTO.class))
                .collect(Collectors.toList());
        propDTO
                .stream()
                .forEach(e -> log.info("Proposal: {}", e));
        return ResponseEntity.ok(proposal);
    }
    @PostMapping(value = "/addProposal", consumes = "application/json", produces = "application/json")
    public ResponseEntity<ProposalDTO> addProposal(@RequestBody Proposal proposal){
        return ResponseEntity.ok(modelMapper.map(proposalService.addProposal(proposal), ProposalDTO.class));
    }
    @PostMapping(value = "/addComponents/{proposalId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addComponents(@PathVariable long proposalId,
                                                            @RequestBody ComponentList componentList){
        Proposal prop = proposalService.fetchProposalById(proposalId);
        log.info("Fetched Proposal: {}", prop);
        componentList.getComponentList()
                .stream()
                .forEach(compo -> {
                    prop.addComponent(compo);
                });
        proposalService.updateProposal(proposalId, prop);
        return ResponseEntity.ok("OK");
    }
}
