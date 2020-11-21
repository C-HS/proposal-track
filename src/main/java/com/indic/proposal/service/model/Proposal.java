
package com.indic.proposal.service.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)
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
    @JsonProperty("id")
    @JsonIgnore
    public Long id;
    @JsonProperty("proposalDocument")
    public String proposalDocument;
    @JsonProperty("proposalId")
	@Column(name = "proposalId", unique=true)
    public String proposalId;
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
    @JsonProperty("amountApprove")
    public String amountApprove;
	@Column(name = "dateOfSubmission")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateOfSubmission;
	@Column(name = "dateLastUpdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateLastUpdate;
    @JsonProperty("proposalStatus")
    public String proposalStatus;
    @JsonProperty("component")
    @OneToMany(mappedBy = "proposal", cascade = CascadeType.PERSIST, orphanRemoval = true)
    @JsonManagedReference(value = "component-list")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Set<Component> componentList = new HashSet<>();

    public void addComponent(Component component){
        if (component == null) {
            return;
        }
        component.setProposal(this);
        this.componentList.add(component);
    }
}
