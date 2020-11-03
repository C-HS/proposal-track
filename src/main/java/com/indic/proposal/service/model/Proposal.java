package com.indic.proposal.service.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Proposal {
    private String proposalId;
    private String proposalDocument;
    private String shpcDocument;
    private Double totalProposalCost;
    private Double totalStateShare;
    private Double totalOtherShare;
    private List<ComponentMetaInfo> componentsList;
}
