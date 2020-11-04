
package com.indic.proposal.service.dto;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectDTO implements Serializable {
    private static final long serialVersionUID = 4345878585547353539L;
    public Long projectTypeId;
    public String projectType;
    public String projectCost;
    public String centralShare;
    public String stateShare;
    public String otherShare;
    public String jsonData;
    public PlantInfoDTO plantInfoDTO;
    public List<SubtypeDTO> subtypeDTOS = new ArrayList<>();
//    private ComponentDTO componentDTO;

}
