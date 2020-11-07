
package com.indic.proposal.service.model;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dumpSiteId",
    "quantity",
    "area",
    "height",
    "yearOfStart"
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Dumpsite implements Serializable {

    private static final long serialVersionUID = 3808135983059468424L;
    @JsonProperty("dumpSiteId")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long dumpSiteId;
    @JsonProperty("quantity")
    public Integer quantity;
    @JsonProperty("area")
    public Integer area;
    @JsonProperty("height")
    public Integer height;
    @JsonProperty("yearOfStart")
    public Integer yearOfStart;
    @ManyToOne
    @JoinColumn(name = "fk_subtype")
    @JsonBackReference(value = "dumpsite-list")
    private Subtype subType;

}
