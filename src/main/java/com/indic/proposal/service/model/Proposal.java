
package com.indic.proposal.service.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.hibernate.metamodel.model.domain.IdentifiableDomainType;

import javax.persistence.*;

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
public class Proposal implements Serializable {

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
    public List<Component> component = new ArrayList<>();

    public void addComponent(Component component){
        this.component.add(component);
        component.setProposal(this);
    }
}
