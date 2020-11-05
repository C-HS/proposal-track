package com.indic.proposal.service.service;

import com.indic.proposal.service.model.Proposal;

import java.util.List;

public interface ProposalService {
    public Proposal addProposal(Proposal proposal);
    public Proposal fetchProposalById(long proposalId);
    public List<Proposal> fetchAllProposal();
    public void deleteProposalById(long proposalId);
    public Proposal updateProposal(long proposalId, Proposal proposal);
}
