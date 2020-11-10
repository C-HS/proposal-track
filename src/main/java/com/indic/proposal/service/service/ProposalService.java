package com.indic.proposal.service.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.indic.proposal.service.model.Proposal;
import com.indic.proposal.service.request.ProposalStatus;

public interface ProposalService {
    public Proposal addProposal(Proposal proposal);
    public Proposal fetchProposalById(long proposalId);
    public List<Proposal> fetchAllProposal();
    public void deleteProposalById(long proposalId);
    public Proposal updateProposal(long proposalId, Proposal proposal);
    public String setProposalStatus(ProposalStatus proposalStatus);

}
