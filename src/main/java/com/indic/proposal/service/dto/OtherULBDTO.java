
package com.indic.proposal.service.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OtherULBDTO implements Serializable {

    private static final long serialVersionUID = 9045278521591480057L;
    public String id;
    public String clusterUlbName;
    public String ulbId;
    public Long distanceFromTarget;
//    private PlantInfoDTO plantInfoDTO;

}
