
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
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubtypeDTO implements Serializable {

    private static final long serialVersionUID = 7745758322404492880L;
    public Long projectSubTypeId;
    public String projectSubType;
    public String projectBrief;
    public String attachmentDoc;
    public List<DumpsiteDTO> dumpsiteDTOS = new ArrayList<>();
    public LandfillInfoDTO landfillInfoDTO;
    public ProjectDTO projectDTO;
}
