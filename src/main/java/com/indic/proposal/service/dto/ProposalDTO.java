
package com.indic.proposal.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "proposalId",
    "proposalDocument",
    "shpcDocument",
    "totalProposalCost",
    "totalCentralShare",
    "totalStateShare",
    "totalOtherShare",
    "component"
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class ProposalDTO implements Serializable {

    private static final long serialVersionUID = -9057319436314533599L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("proposalId")
    public Long proposalId;
    @JsonProperty("proposalDocument")
    public String proposalDocument;
    @JsonProperty("shpcDocument")
    public String shpcDocument;
    @JsonProperty("totalProposalCost")
    public String totalProposalCost;
    @JsonProperty("totalCentralShare")
    public String totalCentralShare;
    @JsonProperty("totalStateShare")
    public String totalStateShare;
    @JsonProperty("totalOtherShare")
    public String totalOtherShare;
    @JsonProperty("component")
    @OneToMany(mappedBy = "proposal")
    public List<ComponentDTO> componentDTO = new ArrayList<>();

    public void addComponent(ComponentDTO componentDTO){
        this.componentDTO.add(componentDTO);
        componentDTO.setProposal(this);
    }
}
