
package com.indic.proposal.service.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DumpsiteDTO implements Serializable {

    private static final long serialVersionUID = 3808135983059468424L;
    public Long dumpSiteId;
    public Integer quantity;
    public Integer area;
    public Integer height;
    public Integer yearOfStart;
    private SubtypeDTO subType;

}
