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
    public String addProposal(Proposal proposal) {
    	
    	try
		{
    		proposalRepository.save(proposal);
			
			return "success";
		}
		catch(org.springframework.dao.DataIntegrityViolationException e)
		{
			return "already_exist";			
		}
		catch(Exception e)
		{
			return "submission_error";	
		}
    	
    }

    @Override
    public Proposal fetchProposalById(long id) {
        return proposalRepository.findById(id).get();
    }

    @Override
    public List<Proposal> fetchAllProposal() {
        return proposalRepository.findAll();
    }

    @Override
    public String deleteProposalById(long id) {
    	
    	try
		{
    		 proposalRepository.deleteById(id);
			
			return "success";
		}
		catch(Exception e)
		{
			return "deletion_error";	
		}
       
    }

    @Override
    public Proposal updateProposal(long id, Proposal proposal) {
    //public Proposal updateProposal(long proposalId, Proposal proposal) {
        
        /* prop = proposal;*/
        //proposal.setProposalId(proposalId);
    	Proposal prop =null;
    	try
		{
    		prop = this.fetchProposalById(id);
    		if(prop!=null && prop.getId()!=0)
    		{
    		prop.setProposalDocument(proposal.getProposalDocument());
    		prop.setShpcDocument(proposal.getShpcDocument());
    		prop.setTotalProposalCost(proposal.getTotalProposalCost());
    		prop.setTotalCentralShare(proposal.getTotalCentralShare());
    		prop.setTotalStateShare(proposal.getTotalStateShare());
    		prop.setTotalOtherShare(proposal.getTotalOtherShare());
    		prop.setProposalStatus(proposal.getProposalStatus());
    		prop.setDateLastUpdate(proposal.getDateLastUpdate());
    		
    		//proposal.setId(id);
            proposalRepository.save(prop);
			
			return prop;
    		}
    		else
    		{
    			return prop;
    		}
		}
		catch(Exception e)
		{
			System.out.println("#########################     "+e.getMessage());
			return prop;	
		}
    }
    
	@Override
	public String setProposalStatus(ProposalStatus proposalStatus) {
		try
		{
				Proposal proposal = proposalRepository.findById(proposalStatus.getProposalId()).get();
				
				//if(proposal!=null && proposal.getProposalId()>0)
				if(proposal!=null && proposal.getId()>0)
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
