
package com.indic.proposal.service.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MediaDTO implements Serializable {

    private static final long serialVersionUID = -1710746659892856271L;
    public Long mediaId;
    public String mediaUrl;
    public String mediaName;
    public String mediaType;
//    private PlantInfoDTO plantInfoDTO;
//    private LandfillInfoDTO landfillInfoDTO;
}
