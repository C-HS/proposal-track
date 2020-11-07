
package com.indic.proposal.service.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.metamodel.model.domain.IdentifiableDomainType;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
/*@JsonPropertyOrder({
    "proposalId",
    "proposalDocument",
    "shpcDocument",
    "totalProposalCost",
    "totalCentralShare",
    "totalStateShare",
    "totalOtherShare",
    "component"
})*/
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
    @JsonIgnore
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
    @JsonProperty("proposalStatus")
    public String proposalStatus;
    @JsonProperty("component")
    @OneToMany(mappedBy = "proposal", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    public Set<Component> componentList = new HashSet<>();

    public void addComponent(Component component){
        if (component == null) {
            return;
        }
        component.setProposal(this);
        this.componentList.add(component);
    }
}
