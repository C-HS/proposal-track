package com.indic.proposal.service.model;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ComponentMetaInfo {
    private String componentTypeId;
    private String componentType;
    private Long componentUnit;
    private Double projectCost;
    private Double installment;
    private Double firstInstallment;
    private Double stateShare;
    private Double otherShare;
    private String actionPlanDocument;
}
