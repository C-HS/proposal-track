
package com.indic.proposal.service.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "clusterUlbName",
    "ulbId"
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class OtherULB implements Serializable {

    private static final long serialVersionUID = 9045278521591480057L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    public String id;
    @JsonProperty("clusterUlbName")
    public String clusterUlbName;
    @JsonProperty("ulbId")
    public String ulbId;
    @JsonProperty("distanceFromTarget")
    public Long distanceFromTarget;
    @ManyToOne
    @JoinColumn(name = "fk_plant_info")
    private PlantInfo plantInfo;

}
