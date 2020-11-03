package com.indic.proposal.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.annotation.Nonnull;
import javax.annotation.security.DenyAll;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectSubType {
    private String subTypeId;
    private String subTypeName;
}
