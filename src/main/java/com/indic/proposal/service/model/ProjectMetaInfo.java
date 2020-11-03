package com.indic.proposal.service.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectMetaInfo {
    private String projectId;
    private String projectType;
    private Double projectCost;
    private Double centralShare;
    private Double stateShare;
    private Double otherShare;
}
