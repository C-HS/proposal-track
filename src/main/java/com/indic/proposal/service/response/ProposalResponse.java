package com.indic.proposal.service.response;

import com.indic.proposal.service.model.Proposal;
import lombok.Data;


import java.util.List;
@Data
public class ProposalResponse {
    private Long count;
    private List<Proposal> data;
}
