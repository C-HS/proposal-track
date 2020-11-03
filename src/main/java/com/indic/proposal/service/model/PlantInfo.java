package com.indic.proposal.service.model;

import lombok.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PlantInfo {
    private Double stateId;
    private Double districtId;
    private Double ulbId;
    private String stateName;
    private String districtName;
    private String ulbName;
    private String misPlantId;
    private String facilityTypeId;
    private String facilityTypeName;
    private String facilityLabel;
    private Double facilityId;
    private Double wardId;
    private String name;
    private String plantTypeId;
    private String plantType;
    private String subCategoryId;
    private String address;
    private String landmark;
    private String pinCode;
    private String latitude;
    private String longitude;
    private String projectCost;
    private String fundedBy;
    private String technology;
    private boolean isIntegrated;
    private boolean isCentralised;
    private String ownedBy;
    private List<Media> mediaList;
    private List<OtherULBs> otherULBsList;
    private String plantStatus;
//    StatusDetail StatusDetailObject;
    private String operatedBy;
    private String ownedByPrivate;
    private String operatedByPrivate;
//    ArrayList < Object > inputs = new ArrayList < Object > ();
    private String wardName;
    private String DPRFile;
    private String actualStartDate;
    private String sanctionId;
}
