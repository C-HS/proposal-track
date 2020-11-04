
package com.indic.proposal.service.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    "wardId",
    "landFillMisId",
    "landfillName",
    "address",
    "landmark",
    "regionalSlf",
    "otherULBs",
    "isNonPermeable",
    "isMechanismLaeachate",
    "isLocatedhill",
    "nearestWaterBody",
    "isDailyCovering",
    "isQualityMonotoring",
    "isLandFillShared",
    "wasteInspectionArea",
    "temporaryWasteStorage",
    "status",
    "dateOfStart",
    "area",
    "heightOfDesigned",
    "heightOfCurrent",
    "nearestHabitation",
    "avgWasteSlf",
    "quantityDisposed",
    "projectCost",
    "yearOfOperation",
    "image",
    "situated",
    "latitude",
    "longitude",
    "wardName"
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class LandfillInfo implements Serializable {

    private static final long serialVersionUID = -5785368962883228230L;
    @JsonProperty("stateId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @JsonProperty("wardId")
    public Integer wardId;
    @JsonProperty("landFillMisId")
    public String landFillMisId;
    @JsonProperty("landfillName")
    public String landfillName;
    @JsonProperty("address")
    public String address;
    @JsonProperty("landmark")
    public String landmark;
    @JsonProperty("regionalSlf")
    public String regionalSlf;
    @JsonProperty("otherULBs")
    @OneToMany
    public List<OtherULB> otherULBs = new ArrayList<>();
    @JsonProperty("isNonPermeable")
    public Boolean isNonPermeable;
    @JsonProperty("isMechanismLaeachate")
    public Boolean isMechanismLaeachate;
    @JsonProperty("isLocatedhill")
    public Boolean isLocatedhill;
    @JsonProperty("nearestWaterBody")
    public String nearestWaterBody;
    @JsonProperty("isDailyCovering")
    public Boolean isDailyCovering;
    @JsonProperty("isQualityMonotoring")
    public Boolean isQualityMonotoring;
    @JsonProperty("isLandFillShared")
    public Boolean isLandFillShared;
    @JsonProperty("wasteInspectionArea")
    public String wasteInspectionArea;
    @JsonProperty("temporaryWasteStorage")
    public String temporaryWasteStorage;
    @JsonProperty("status")
    public String status;
    @JsonProperty("dateOfStart")
    public String dateOfStart;
    @JsonProperty("area")
    public String area;
    @JsonProperty("heightOfDesigned")
    public String heightOfDesigned;
    @JsonProperty("heightOfCurrent")
    public String heightOfCurrent;
    @JsonProperty("nearestHabitation")
    public String nearestHabitation;
    @JsonProperty("avgWasteSlf")
    public String avgWasteSlf;
    @JsonProperty("quantityDisposed")
    public Integer quantityDisposed;
    @JsonProperty("projectCost")
    public Integer projectCost;
    @JsonProperty("yearOfOperation")
    public String yearOfOperation;
    @JsonProperty("image")
    @OneToMany
    public List<Media> media = new ArrayList<>();
    @JsonProperty("situated")
    public String situated;
    @JsonProperty("latitude")
    public String latitude;
    @JsonProperty("longitude")
    public String longitude;
    @JsonProperty("wardName")
    public String wardName;
    @OneToOne
    @JoinColumn(name = "fk_subtype")
    private Subtype subType;
}
