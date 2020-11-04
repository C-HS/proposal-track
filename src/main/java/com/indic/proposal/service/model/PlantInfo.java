
package com.indic.proposal.service.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;
import net.bytebuddy.build.ToStringPlugin;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "stateId",
    "districtId",
    "ulbId",
    "stateName",
    "districtName",
    "ulbName",
    "misPlantId",
    "facilityTypeId",
    "facilityTypeName",
    "facilityLabel",
    "facilityId",
    "wardId",
    "name",
    "plantTypeId",
    "plantType",
    "subCategoryId",
    "address",
    "landmark",
    "pinCode",
    "latitude",
    "longitude",
    "projectCost",
    "fundedBy",
    "technology",
    "isIntegrated",
    "isCentralised",
    "ownedBy",
    "media",
    "otherULBs",
    "plantStatus",
    "statusDetail",
    "operatedBy",
    "ownedByPrivate",
    "operatedByPrivate",
    "inputs",
    "wardName",
    "DPRFile",
    "actualStartDate",
    "sanctionId"
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class PlantInfo implements Serializable {
    private static final long serialVersionUID = 2734121425430750485L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("stateId")
    public Long stateId;
    @JsonProperty("districtId")
    public Integer districtId;
    @JsonProperty("ulbId")
    public Integer ulbId;
    @JsonProperty("stateName")
    public String stateName;
    @JsonProperty("districtName")
    public String districtName;
    @JsonProperty("ulbName")
    public String ulbName;
    @JsonProperty("misPlantId")
    public String misPlantId;
    @JsonProperty("facilityTypeId")
    public String facilityTypeId;
    @JsonProperty("facilityTypeName")
    public String facilityTypeName;
    @JsonProperty("facilityLabel")
    public String facilityLabel;
    @JsonProperty("facilityId")
    public Integer facilityId;
    @JsonProperty("wardId")
    public Integer wardId;
    @JsonProperty("name")
    public String name;
    @JsonProperty("plantTypeId")
    public String plantTypeId;
    @JsonProperty("plantType")
    public String plantType;
    @JsonProperty("subCategoryId")
    public String subCategoryId;
    @JsonProperty("address")
    public String address;
    @JsonProperty("landmark")
    public String landmark;
    @JsonProperty("pinCode")
    public String pinCode;
    @JsonProperty("latitude")
    public String latitude;
    @JsonProperty("longitude")
    public String longitude;
    @JsonProperty("projectCost")
    public Double projectCost;
    @JsonProperty("fundedBy")
    public String fundedBy;
    @JsonProperty("technology")
    public String technology;
    @JsonProperty("isIntegrated")
    public Boolean isIntegrated;
    @JsonProperty("isCentralised")
    public Boolean isCentralised;
    @JsonProperty("ownedBy")
    public String ownedBy;
    @JsonProperty("media")
    @OneToMany(mappedBy = "plantInfo")
    public List<Media> media = new ArrayList<>();
    @JsonProperty("otherULBs")
    @OneToMany(mappedBy = "plantInfo")
    public List<OtherULB> otherULBs = new ArrayList<>();
    @JsonProperty("plantStatus")
    public String plantStatus;
    @JsonProperty("statusDetail")
    public String statusDetail;
    @JsonProperty("operatedBy")
    public String operatedBy;
    @JsonProperty("ownedByPrivate")
    public String ownedByPrivate;
    @JsonProperty("operatedByPrivate")
    public String operatedByPrivate;
    @JsonProperty("inputs")
    public String inputs;
    @JsonProperty("wardName")
    public String wardName;
    @JsonProperty("DPRFile")
    public String dPRFile;
    @JsonProperty("actualStartDate")
    public String actualStartDate;
    @JsonProperty("sanctionId")
    public String sanctionId;
    @OneToOne
    @JoinColumn(name = "fk_project")
    private Project project;

}
