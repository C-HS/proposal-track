
package com.indic.proposal.service.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ComponentDTO implements Serializable {
    private static final long serialVersionUID = 8533818105839237447L;
    public Long componentTypeId;
    public String componentType;
    public String unit;
    public String projectCost;
    public String installment;
    public String firstInstallment;
    public String stateShare;
    public String otherShare;
    public String actionPlanDocument;
    public List<ProjectDTO> projectsDTO = new ArrayList<>();
    public ProposalDTO proposalDTO;
}
