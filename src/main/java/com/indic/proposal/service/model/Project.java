
package com.indic.proposal.service.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import springfox.documentation.spring.web.json.Json;

import javax.persistence.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Project implements Serializable {
    private static final long serialVersionUID = 4345878585547353539L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("projectId")
    private Long projectId;
    @JsonProperty("projectTypeId")
    public String projectTypeId;
    @JsonProperty("projectType")
    public String projectType;
    @JsonProperty("projectCost")
    public String projectCost;
    @JsonProperty("centralShare")
    public String centralShare;
    @JsonProperty("stateShare")
    public String stateShare;
    @JsonProperty("otherShare")
    public String otherShare;
	@Column(name = "dateCreated")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	@Column(name = "dateLastUpdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateLastUpdate;
    @JsonProperty("jsonData")
    public String jsonData;
    @JsonProperty("plantInfo")
    @OneToOne(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "plant-info-object")
    public PlantInfo plantInfo;
    @JsonProperty("subtypes")
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference(value = "subtype-list")
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    public Set<Subtype> subtypesList = new HashSet<>();
    @ManyToOne
    @JoinColumn(name = "fk_component")
    @JsonBackReference(value = "project-list")
    @ToString.Exclude
    private Component component;
    public void addSubType(Subtype subtype){
        if (subtype == null) {
            return;
        }
        subtype.setProject(this);
        this.subtypesList.add(subtype);
    }

}
