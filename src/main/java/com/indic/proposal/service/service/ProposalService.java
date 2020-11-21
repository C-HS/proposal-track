package com.indic.proposal.service.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.indic.proposal.service.model.Proposal;
import com.indic.proposal.service.request.ProposalStatus;

public interface ProposalService {
	public String addProposal(Proposal proposal);
    public Proposal fetchProposalById(long proposalId);
    public List<Proposal> fetchAllProposal();
    public String deleteProposalById(long id);
    public Proposal updateProposal(long id, Proposal proposal);
    public String setProposalStatus(ProposalStatus proposalStatus);

}
