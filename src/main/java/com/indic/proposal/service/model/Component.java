
package com.indic.proposal.service.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.*;
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
    @OneToMany(mappedBy = "component", fetch = FetchType.LAZY)
    @JsonManagedReference
    public Set<Project> projectList = new HashSet<>();
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "fk_proposal")
    @ToString.Exclude
    private Proposal proposal;

    public void addProject(Project project){
        if (project == null) {
            return;
        }
        project.setComponent(this);
        this.projectList.add(project);
    }

}
