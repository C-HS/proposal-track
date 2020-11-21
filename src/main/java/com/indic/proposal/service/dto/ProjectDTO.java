
package com.indic.proposal.service.dto;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	private Date dateCreated;
	private Date dateLastUpdate;
    public String jsonData;
    public PlantInfoDTO plantInfoDTO;
    public List<SubtypeDTO> subtypeDTOS = new ArrayList<>();
//    private ComponentDTO componentDTO;

}
