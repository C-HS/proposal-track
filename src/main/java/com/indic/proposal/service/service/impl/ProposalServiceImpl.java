package com.indic.proposal.service.service.impl;

import com.indic.proposal.service.model.Proposal;
import com.indic.proposal.service.repository.ProposalRepository;
import com.indic.proposal.service.service.ProposalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class ProposalServiceImpl implements ProposalService {
    private final ProposalRepository proposalRepository;
    private final ModelMapper modelMapper;

    @Override
    public Proposal addProposal(Proposal proposal) {
        return proposalRepository.save(proposal);
    }

    @Override
    public Proposal fetchProposalById(long proposalId) {
        return proposalRepository.findById(proposalId).get();
    }

    @Override
    public List<Proposal> fetchAllProposal() {
        return proposalRepository.findAll();
    }

    @Override
    public void deleteProposalById(long proposalId) {
        proposalRepository.deleteById(proposalId);
    }

    @Override
    public Proposal updateProposal(long proposalId, Proposal proposal) {
        /*Proposal prop = this.fetchProposalById(proposalId);
        prop = proposal;*/
        proposal.setProposalId(proposalId);
        return proposalRepository.save(proposal);
    }
}
