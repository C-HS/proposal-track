
package com.indic.proposal.service.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
/*@JsonPropertyOrder({
    "projectSubTypeId",
    "projectSubType",
    "projectBrief",
    "attachmentDoc",
    "dumpsites",
    "landfillInfo"
})*/
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
    @JsonManagedReference
    public Set<Dumpsite> dumpsiteList = new HashSet<>();
    @JsonProperty("landfillInfo")
    @OneToOne(mappedBy = "subType")
    public LandfillInfo landfillInfo;
    @ManyToOne
    @JoinColumn(name = "fk_project")
    @JsonBackReference
    @ToString.Exclude
    private Project project;
    public void addDumpSite(Dumpsite dumpsite){
        if (dumpsite == null) {
            return;
        }
        dumpsite.setSubType(this);
        this.dumpsiteList.add(dumpsite);
    }

}
