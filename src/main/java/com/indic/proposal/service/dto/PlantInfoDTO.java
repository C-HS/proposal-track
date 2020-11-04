
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
public class PlantInfoDTO implements Serializable {
    private static final long serialVersionUID = 2734121425430750485L;
    public Long stateId;
    public Integer districtId;
    public Integer ulbId;
    public String stateName;
    public String districtName;
    public String ulbName;
    public String misPlantId;
    public String facilityTypeId;
    public String facilityTypeName;
    public String facilityLabel;
    public Integer facilityId;
    public Integer wardId;
    public String name;
    public String plantTypeId;
    public String plantType;
    public String subCategoryId;
    public String address;
    public String landmark;
    public String pinCode;
    public String latitude;
    public String longitude;
    public Double projectCost;
    public String fundedBy;
    public String technology;
    public Boolean isIntegrated;
    public Boolean isCentralised;
    public String ownedBy;
    public List<MediaDTO> mediaDTOS = new ArrayList<>();
    public List<OtherULBDTO> otherULBDTOS = new ArrayList<>();
    public String plantStatus;
    public String statusDetail;
    public String operatedBy;
    public String ownedByPrivate;
    public String operatedByPrivate;
    public String inputs;
    public String wardName;
    public String dPRFile;
    public String actualStartDate;
    public String sanctionId;
//    public ProjectDTO projectDTO;

}
