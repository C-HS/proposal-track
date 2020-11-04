
package com.indic.proposal.service.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "projectSubTypeId",
    "projectSubType",
    "projectBrief",
    "attachmentDoc",
    "dumpsites",
    "landfillInfo"
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Subtype implements Serializable {

    private static final long serialVersionUID = 7745758322404492880L;
    @JsonProperty("projectSubTypeId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long projectSubTypeId;
    @JsonProperty("projectSubType")
    public String projectSubType;
    @JsonProperty("projectBrief")
    public String projectBrief;
    @JsonProperty("attachmentDoc")
    public String attachmentDoc;
    @JsonProperty("dumpsites")
    @OneToMany(mappedBy = "subType")
    public List<Dumpsite> dumpsites = new ArrayList<>();
    @JsonProperty("landfillInfo")
    @OneToOne(mappedBy = "subType")
    public LandfillInfo landfillInfo;
    @ManyToOne
    @JoinColumn(name = "fk_project")
    private Project project;

}
