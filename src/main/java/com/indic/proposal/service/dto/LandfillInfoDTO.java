
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
public class LandfillInfoDTO implements Serializable {

    private static final long serialVersionUID = -5785368962883228230L;
    public Long stateId;
    public Integer districtId;
    public Integer ulbId;
    public String stateName;
    public String districtName;
    public String ulbName;
    public Integer wardId;
    public String landFillMisId;
    public String landfillName;
    public String address;
    public String landmark;
    public String regionalSlf;
    public List<OtherULBDTO> otherULBDTOS = new ArrayList<>();
    public Boolean isNonPermeable;
    public Boolean isMechanismLaeachate;
    public Boolean isLocatedhill;
    public String nearestWaterBody;
    public Boolean isDailyCovering;
    public Boolean isQualityMonotoring;
    public Boolean isLandFillShared;
    public String wasteInspectionArea;
    public String temporaryWasteStorage;
    public String status;
    public String dateOfStart;
    public String area;
    public String heightOfDesigned;
    public String heightOfCurrent;
    public String nearestHabitation;
    public String avgWasteSlf;
    public Integer quantityDisposed;
    public Integer projectCost;
    public String yearOfOperation;
    public List<MediaDTO> mediaDTOS = new ArrayList<>();
    public String situated;
    public String latitude;
    public String longitude;
    public String wardName;
//    private SubtypeDTO subType;
}
