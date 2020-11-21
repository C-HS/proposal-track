
package com.indic.proposal.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProposalDTO implements Serializable {

    private static final long serialVersionUID = -9057319436314533599L;
    public Long id;
    public String proposalDocument;
    public String proposalId;
    public String shpcDocument;
    public String totalProposalCost;
    public String totalCentralShare;
    public String totalStateShare;
    public String totalOtherShare;
    public String amountApprove;
    private Date dateOfSubmission;
    private Date dateLastUpdate;
    public String proposalStatus;
    public List<ComponentDTO> componentDTO = new ArrayList<>();
}
