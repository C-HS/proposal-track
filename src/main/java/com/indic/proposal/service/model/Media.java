
package com.indic.proposal.service.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "url",
    "media"
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Media implements Serializable {

    private static final long serialVersionUID = -1710746659892856271L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("mediaId")
    public Long mediaId;
    @JsonProperty("mediaUrl")
    public String mediaUrl;
    @JsonProperty("mediaName")
    public String mediaName;
    @JsonProperty("mediaType")
    public String mediaType;
    @ManyToOne
    @JoinColumn(name = "fk_plant_info")
    @JsonBackReference(value = "plantinfo-media-list")
    private PlantInfo plantInfo;
    @ManyToOne
    @JoinColumn(name = "fk_landfill_info")
    @JsonBackReference(value = "landfillinfo-media-list")
    private LandfillInfo landfillInfo;
}
