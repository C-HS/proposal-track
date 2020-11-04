
package com.indic.proposal.service.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import org.omg.CORBA.IdentifierHelper;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "componentTypeId",
    "componentType",
    "unit",
    "projectCost",
    "installment",
    "firstInstallment",
    "stateShare",
    "otherShare",
    "actionPlanDocument",
    "projects"
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Component implements Serializable {
    private static final long serialVersionUID = 8533818105839237447L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("componentTypeId")
    public Long componentTypeId;
    @JsonProperty("componentType")
    public String componentType;
    @JsonProperty("unit")
    public String unit;
    @JsonProperty("projectCost")
    public String projectCost;
    @JsonProperty("installment")
    public String installment;
    @JsonProperty("firstInstallment")
    public String firstInstallment;
    @JsonProperty("stateShare")
    public String stateShare;
    @JsonProperty("otherShare")
    public String otherShare;
    @JsonProperty("actionPlanDocument")
    public String actionPlanDocument;
    @JsonProperty("projects")
    @OneToMany(mappedBy = "component")
    public List<Project> projects = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "fk_proposal")
    private Proposal proposal;

}
