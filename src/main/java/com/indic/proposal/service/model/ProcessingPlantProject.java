package com.indic.proposal.service.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProcessingPlantProject extends ProjectMetaInfo{
    private PlantInfo plantInfo;
}
