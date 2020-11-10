package com.indic.proposal.service.service.impl;

import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.indic.proposal.service.dto.ProposalDTO;
import com.indic.proposal.service.model.Proposal;
import com.indic.proposal.service.repository.ProposalRepository;
import com.indic.proposal.service.request.ProposalStatus;
import com.indic.proposal.service.service.ProposalService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
    
	@Override
	public String setProposalStatus(ProposalStatus proposalStatus) {
		try
		{
				Proposal proposal = proposalRepository.findById(proposalStatus.getProposalId()).get();
				
				if(proposal!=null && proposal.getProposalId()>0)
				{
					proposal.setProposalStatus(proposalStatus.getProposalStatus());
					proposal.setDateLastUpdate(new Date());
					modelMapper.map(proposalRepository.save(proposal), ProposalDTO.class);
					return "proposal_updated";
				}
				else
				{
					return "proposal_not_found";
				}
		}
		catch(Exception e)
		{
			return "error_in_updated";
		}
	}
	
	
}
